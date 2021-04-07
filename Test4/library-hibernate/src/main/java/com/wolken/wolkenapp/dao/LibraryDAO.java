package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.dto.LibraryDTO;

public interface LibraryDAO {

	 public void addLibraryData(LibraryDTO libraryDTO);

	public void updateDataByBookName(String bookName, int noOfBooks);

	public List<LibraryDTO> getAllData(LibraryDTO libraryDTO);

	public boolean deleteDataByLibraryName(String libraryName);

}
