package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.dto.GunDTO;

public interface GunService {

	public GunDTO validateAndAdd(GunDTO gunDTO);

	public void validateAndGetAll();

	public void validateAndGetByBrandName(String brandName);
	
	public void validateAndGetByCountryName(String madeIn);

	public void validateAndUpdate(String serialNumber);

	public void validateAndDeleteByGunId(int nextInt);

	

}
