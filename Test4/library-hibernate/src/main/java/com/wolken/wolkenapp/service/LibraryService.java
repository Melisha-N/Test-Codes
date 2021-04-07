package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.LibraryDTO;

public interface LibraryService {
	
	public void validateAndAdd(LibraryDTO libraryDTO);
	public void validateAndUpdateBookName(String bookName, int noOfBooks);
	public List<LibraryDTO> validateAndGetAll(LibraryDTO libraryDTO);
	public boolean validateAndDeleteByLibraryName(String libraryName);
	
}
