package com.wolken.wolkenapp.dto;

public class MobileDTO {	
	private int mobileId;
	private String modelName;
	private double price;
	private String memory;
	private String brandName;
	private String serialNumber;
	private int noOfCamera;
	
	
	public MobileDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MobileDTO(int mobileId, String modelName, double price, String memory, String brandName, String serialNumber,
			int noOfCamera) {
		super();
		this.mobileId = mobileId;
		this.modelName = modelName;
		this.price = price;
		this.memory = memory;
		this.brandName = brandName;
		this.serialNumber = serialNumber;
		this.noOfCamera = noOfCamera;
	}



	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandName() {
		return brandName;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public int getNoOfCamera() {
		return noOfCamera;
	}
	public void setNoOfCamera(int noOfCamera) {
		this.noOfCamera = noOfCamera;
	}


//	@Override
//	public String toString() {
//		return "MobileDTO [mobileId=" + mobileId + ", modelName=" + modelName + ", price=" + price + ", memory="
//				+ memory + ", brandName=" + brandName + ", serialNumber=" + serialNumber + ", noOfCamera=" + noOfCamera
//				+ "]";
//	}
	
	
}
