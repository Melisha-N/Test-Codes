package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.custom.GunException;
import com.wolken.wolkenapp.dao.GunDAO;
import com.wolken.wolkenapp.dao.GunDAOImpl;
import com.wolken.wolkenapp.dto.GunDTO;

public class GunServiceImpl implements GunService{

	GunDAO gunDAO = new GunDAOImpl();
	
	@Override
	public GunDTO validateAndAdd(GunDTO gunDTO) {
		// TODO Auto-generated method stub
		try{if(gunDTO != null) {
			gunDAO.add(gunDTO);
		}
		else
			throw new GunException();
		}catch(GunException| NullPointerException e) {
			System.out.println(e);
			
		}
		return gunDTO;
	}

	@Override
	public void validateAndGetAll() {
		// TODO Auto-generated method stub
		try {
			gunDAO.getAllData();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void validateAndGetByBrandName(String brandName) {
		// TODO Auto-generated method stub
		try {
			if (brandName != null && brandName.length() > 2) {
				gunDAO.getDataByBrandName(brandName);
			} else {
				// System.out.println("Brand name error");
				throw new GunException();
			}
		} catch (GunException e) {
			System.out.println(e);
		}
		
	}
	
	public void validateAndGetByCountryName(String madeIn) {
		// TODO Auto-generated method stub
		try {
			if (madeIn != null && madeIn.length() > 2) {
				gunDAO.getDataByCountryName(madeIn);
			} else {
				// System.out.println("Brand name error");
				throw new GunException();
			}
		} catch (GunException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void validateAndUpdate(String serialNumber) {
		// TODO Auto-generated method stub
		try {
			if (serialNumber.length()>10) {
				gunDAO.updateBySerialNumber(serialNumber);
			} else {
				System.out.println("Cannot update the data");
				throw new GunException();
			}
		} catch (GunException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void validateAndDeleteByGunId(int gunId) {
		// TODO Auto-generated method stub
		try {
			if (gunId > 0) {
				gunDAO.deleteByGunId(gunId);
			} else {
				System.out.println("Cannot delete the data");
				throw new GunException();
			}
		} catch (GunException e) {
			System.out.println(e);
		}
	}

}
