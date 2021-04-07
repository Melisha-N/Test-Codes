package com.wolken.wolkenapp.service;

import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.wolken.wolkenapp.custom.BookNameException;
import com.wolken.wolkenapp.custom.LibraryException;
import com.wolken.wolkenapp.custom.LibraryNameException;
import com.wolken.wolkenapp.custom.NoOfBookException;
import com.wolken.wolkenapp.dao.LibraryDAO;
import com.wolken.wolkenapp.dao.LibraryDAOImpl;
import com.wolken.wolkenapp.dto.LibraryDTO;

public class LibraryServiceImpl implements LibraryService{
	
	 LibraryDAO libraryDAO = new LibraryDAOImpl();
	 Logger libraryLogger= Logger.getLogger("LibraryServiceImpl");
	 
	@Override
	public void validateAndAdd(LibraryDTO libraryDTO) {
		try {
			
			if (libraryDTO != null) {
				if(libraryDTO.getLibraryName() != null && !libraryDTO.getLibraryName().isEmpty() && libraryDTO.getLibraryName().length() > 2) {
					if(libraryDTO.getBookName() != null && !libraryDTO.getBookName().isEmpty() && !libraryDTO.getBookName().contains(" ")) {
						if(libraryDTO.getNoOfBooks() >0) {
							libraryLogger.info("Inside validateAndAdd\n");
							libraryDAO.addLibraryData(libraryDTO);
						}
						else {
							throw new NoOfBookException();
						}
					}
					else {
						throw new BookNameException();
					}
				}
				else {
					throw new LibraryNameException();
				}
				
			}
			else {
				throw new LibraryException();
			}
		} catch (NullPointerException | NoOfBookException| BookNameException| LibraryNameException | LibraryException e) {
			
				System.out.println(e);
				libraryLogger.info("Catch Exception of validateAndAdd\n");
		} 
		
		
	}

	@Override
	public void validateAndUpdateBookName(String bookName, int noOfBooks) {
		try {
			
			if(bookName != null && bookName.length() > 2) {
				if(noOfBooks > 0) {
					
					libraryLogger.info("Inside validateAndUpdateBookName\n");
					libraryDAO.updateDataByBookName(bookName,noOfBooks);
					
				}
				else {
					libraryLogger.info("validateAndUpdateBookName--->NoOfBookException\n");
					throw new NoOfBookException();
				}
			}
			else {
				throw new BookNameException();
			}
			
		} catch (NullPointerException | BookNameException | NoOfBookException e) {
			System.out.println(e);
//			libraryLogger.info(e);
			libraryLogger.info("Catch Exception of validateAndUpdateBookName\n");
			
		}
		
		
		
	}
	
	@Override
	public List<LibraryDTO> validateAndGetAll(LibraryDTO libraryDTO) {
		
		try {
			libraryLogger.info("Inside validateAndGetAll\n");
			List<LibraryDTO> ldto = libraryDAO.getAllData(libraryDTO);
			return ldto;
			
		} catch (Exception  e) {
			e.printStackTrace();
			libraryLogger.info("Catch Exception of validateAndGetAll\n");
		}
		
		return null;
	}

	
	@Override
	public boolean validateAndDeleteByLibraryName(String libraryName) {
		try {
			boolean status;
			if(libraryName != null && libraryName.length() > 2) {
				libraryLogger.info("Inside validateAndDeleteByLibraryName\n");
				status = libraryDAO.deleteDataByLibraryName(libraryName);
				return status;
			}
			else {
				throw new LibraryNameException();
			}
			
		} catch (NullPointerException | LibraryNameException e) {
			System.out.println(e);
			libraryLogger.info("Catch Exception of validateAndDeleteByLibraryName\n");

		}
		return false;	
	}

	
	
	

}
