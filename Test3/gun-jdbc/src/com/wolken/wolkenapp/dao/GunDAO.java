package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.dto.GunDTO;

public interface GunDAO {

	public GunDTO add(GunDTO gunDTO);

	public void getAllData();

	public void getDataByBrandName(String brandName);
	
	public void getDataByCountryName(String madeIn);

	public GunDTO deleteByGunId(int gunId);

	public GunDTO updateBySerialNumber(String serialNumber);

}
