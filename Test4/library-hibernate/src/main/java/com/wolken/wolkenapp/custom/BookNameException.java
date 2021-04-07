package com.wolken.wolkenapp.custom;

public class BookNameException extends Exception {

//	public BookNameException() {   //constructor overloading
//		System.out.println("Book name");
//	}
//	  public BookNameException(int noOfBooks) {
//	  System.out.println("books="+noOfBooks);
//	  }
	
//	public void toString(String abc) {   //method overloading
//		System.out.println("Invalid book name" + abc);
//	}

	@Override
	public String toString() {
		return "Please Enter valid Book Name";
	}
}