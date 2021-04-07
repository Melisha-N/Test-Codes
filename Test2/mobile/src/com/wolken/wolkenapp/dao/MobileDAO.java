package com.wolken.wolkenapp.dao;

import com.wolken.wolkenapp.dto.MobileDTO;
import com.wolken.wolkenapp.exception.MobileException;

public interface MobileDAO {
	
	public boolean add(MobileDTO dto) throws MobileException;
	public void getAll();
	public MobileDTO deleteByMobileId(int mobileId);
	public MobileDTO updateBySerialNumber(String serialNumber);
	public void getAllByBrandName(String brandName) throws MobileException;

}
