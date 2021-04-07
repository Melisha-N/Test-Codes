package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.dto.MobileDTO;
import com.wolken.wolkenapp.exception.MobileException;

public class MobileDAOImpl implements MobileDAO {
	public MobileDTO[] mobileDTO;
	public int index;
	
	public MobileDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public MobileDAOImpl(int size) {
		// TODO Auto-generated constructor stub
		mobileDTO = new MobileDTO[size];
	}

	@Override
	public boolean add(MobileDTO mobileDTO) throws MobileException {
		// TODO Auto-generated method stub
		if(mobileDTO != null) {
			if (mobileDTO.getBrandName().length() > 1) {

				this.mobileDTO[index++] = mobileDTO;
				System.out.println("Mobile details are added successfully!");
				return true;
			}
			else 
				throw new MobileException();
		}
		else {
			System.out.println("Cannot add the Mobile details!");
			return false;
		}
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.mobileDTO.length; i++) {
			if(mobileDTO[i] != null) {
			System.out.println( this.mobileDTO[i].getMobileId()+" "+this.mobileDTO[i].getModelName()+" "+
					this.mobileDTO[i].getPrice()+" "+this.mobileDTO[i].getMemory()+" "+
					this.mobileDTO[i].getBrandName()+" "+this.mobileDTO[i].getSerialNumber()+" "+
					this.mobileDTO[i].getNoOfCamera());	
			}
			else {
				System.out.println("Could not fetch the Mobile data");
			}
		}
		}
		


	@Override
	public MobileDTO deleteByMobileId(int mobileId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mobileDTO.length; i++) {
			if(this.mobileDTO[i] != null) {
				if(this.mobileDTO[i].getMobileId() == mobileId) {
					this.mobileDTO[i] = null;
					System.out.println("Mobile Data deleted successfully!!");
				}
				else {
					System.out.println("Mobile data not found!");
				}
			}
			else {
				System.out.println("Data provided is null");
			}
			
		}
		
		return null;
		
	}

	@Override
	public MobileDTO updateBySerialNumber(String serialNumber) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mobileDTO.length; i++) {
			if(mobileDTO[i] != null) {
				if(this.mobileDTO[i].getSerialNumber().equals(serialNumber)) {
					this.mobileDTO[i].setMobileId(999);
					this.mobileDTO[i].setModelName("X2");
					this.mobileDTO[i].setMemory("64GB Storage");
					this.mobileDTO[i].setBrandName("POCO");
					this.mobileDTO[i].setPrice(17000);
					this.mobileDTO[i].setNoOfCamera(5);	
				}
				else {
					System.out.println("Mobile serialNumber not found!");
				}
			}
			else {
				System.out.println("Data provided is null");
			}
		}
		return null;
	}

	@Override
	public void getAllByBrandName(String brandName) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mobileDTO.length; i++) {
			if(mobileDTO[i] != null) {
				if(mobileDTO[i].getBrandName().equals(brandName)) {
					System.out.println("Get all the data by BrandName:");
					System.out.println( this.mobileDTO[i].getMobileId()+" "+this.mobileDTO[i].getModelName()+" "+
							this.mobileDTO[i].getPrice()+" "+this.mobileDTO[i].getMemory()+" "+
							this.mobileDTO[i].getBrandName()+" "+this.mobileDTO[i].getSerialNumber()+" "+
							this.mobileDTO[i].getNoOfCamera());				
				}
				else {
					System.out.println("Invalid Brand Name!");
					//throw new MobileException();
				}
			}
			else {
				System.out.println("Data provided is null");
				//throw new MobileException();
			}	
		}
	}
	

}
