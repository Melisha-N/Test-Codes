package com.wolken.wolkenapp.exception;

public class MobileException extends Exception {
	
	@Override
	public String getMessage() {
		return "Please enter valid BrandName of the Mobile!!";
	}
	
	@Override
	public String toString() {
		return "Re-check the mobile BrandName entered";
	}

}
