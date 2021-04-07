package com.wolken.wolkenapp;

import java.util.Scanner;

import com.wolken.wolkenapp.dao.MobileDAOImpl;
import com.wolken.wolkenapp.dto.MobileDTO;
import com.wolken.wolkenapp.exception.MobileException;

public class MobileUtil {
public static void main(String[] args)  {
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the size:");
	int size = scanner.nextInt();
	MobileDTO mobileDTO = new MobileDTO();
	MobileDAOImpl mobileDAO = new MobileDAOImpl(size);
	
	System.out.println("Enter the details of Mobile:");
	for (int i = 0; i < size; i++) { //dao.dto.length
		System.out.println("Enter the MobileId:");
		int mobileId = scanner.nextInt();
		System.out.println("Enter the BrandName:");
		String brandName = scanner.next();
		System.out.println("Enter the ModelName:");
		String modelName = scanner.next();
		System.out.println("Enter the Price:");
		double price = scanner.nextDouble();
		System.out.println("Enter the Memory:");
		String memory = scanner.next();
		System.out.println("Enter the SerialNumber:");
		String serialNumber = scanner.next();
		System.out.println("Enter the No. Of Cameras:");
		int noOfCamera = scanner.nextInt();
		
		MobileDTO mdto = new MobileDTO();
		mdto.setMobileId(mobileId);
		mdto.setBrandName(brandName);
		mdto.setModelName(modelName);
		mdto.setPrice(price);
		mdto.setMemory(memory);
		mdto.setSerialNumber(serialNumber);
		mdto.setNoOfCamera(noOfCamera);
		
//		MobileService mobileService = new MobileServiceImpl(mobileDAO);
//		mobileService.validateAndSave(mobileDTO);
	//	mobileService.getData();
		
	//	MobileDAO dao1 = new MobileDAOImpl();
	//	mobileDAO.add(mdto);
		
		
//this wrong way to do the exception		
//		Mobile mobile = new Mobile();
//		try{
//			mobile.check(price);
//		}catch(MobileException e)
//		{
//			System.out.println("Inside Catch:");
//			MobileException mexcp = new MobileException();
//			//System.out.println(mexcp.getMessage());
//			System.out.println(mexcp);
//		}
		
		
		
		
		
		try {
			mobileDAO.add(mdto);		
		}catch(MobileException e)
		{	
			System.out.println("Inside catch");
			MobileException mexcp = new MobileException();
			System.out.println(mexcp.getMessage()); 
			System.out.println(mexcp);
		}
	}
	//MobileDAO dao2 = new MobileDAOImpl();
	System.out.println("\nGetting Mobile data:");
	mobileDAO.getAll();
		
	mobileDAO.updateBySerialNumber("abc1");
	System.out.println("\nUpdating");
	mobileDAO.getAll();
	
//	System.out.println("\nGetting by brandName");
//this also a wrong way to adda exception -- handle it	
//	try {
//		mobileDAO.getAllByBrandName("MI");
//	}catch(MobileException e)
//	{
//		System.out.println("Inside catch");
//		MobileException mexcp = new MobileException();
//		System.out.println(mexcp.getMessage()); 
//		System.out.println(mexcp);
//	}
	mobileDAO.getAllByBrandName("MI");
	mobileDAO.deleteByMobileId(123);
	System.out.println("\nAfter deleting :");
	mobileDAO.getAll();

}
	
		
}
