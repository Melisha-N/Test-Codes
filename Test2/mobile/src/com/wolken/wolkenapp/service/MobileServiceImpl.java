//package com.wolken.wolkenapp.service;
//
//import com.wolken.wolkenapp.dao.MobileDAO;
//import com.wolken.wolkenapp.dto.MobileDTO;
//
//public class MobileServiceImpl implements MobileService{
//	public MobileDAO mobileDAO;
//
//	public MobileServiceImpl(MobileDAO mobileDAO) {
//		// TODO Auto-generated constructor stub
//		this.mobileDAO = mobileDAO;
//	}
//	
//	
//	@Override
//	public boolean validateAndSave(MobileDTO mobileDTO) {
//		// TODO Auto-generated method stub
//		boolean check = false;
//		if(mobileDTO != null) {
////			String modelName = mobileDTO.getModelName();
////			if(modelName != null ) {
////				System.out.println("Valid ModelName");
////				check = true;
////			}
////			else {
////				System.out.println("Invalid ModelName");
////				check = false;
////			}
//			if(check) {
//				String brandName = mobileDTO.getBrandName();
//				if(brandName != null && !brandName.isEmpty()) {
//					System.out.println("Valid BrandName");
//					check = true;
//				}
//				else {
//					System.out.println("Invalid BrandName");
//					check = false;
//				}
//			}
//			if(check) {
//				int noOfCamera = mobileDTO.getNoOfCamera();
//				if(noOfCamera < 5) {
//					System.out.println("Valid No.OfCamera");
//					check = true;
//				}
//				else {
//					System.out.println("Invalid No.OfCamera");
//					check = false;
//				}
//			}
//			mobileDAO.add(mobileDTO);
//		}
////		else {
////			System.out.println("MobileDTO is null");
////			check = false;
////		}
//		return check;
//	}
//
//}
