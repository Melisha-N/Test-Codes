package com.wolken.wolkenapp.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.dto.LibraryDTO;
import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;


@WebServlet("/addlib")
public class AddServlet extends HttpServlet {
	 
	LibraryDTO libraryDTO = new LibraryDTO();
	LibraryService libraryService = new LibraryServiceImpl();
	
	 public AddServlet() {
		 System.out.println("Inside Library Add Servlet"+getClass());
	 }
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 try {
			 
			 String libId = req.getParameter("lid");
			 String libraryName = req.getParameter("lnm");
			 String noBook = req.getParameter("nbks");
			 String bookName = req.getParameter("bnm");
			 int libraryId = Integer.parseInt(libId);
			 int noOfBooks = Integer.parseInt(noBook);
			 
			 libraryDTO.setLibraryId(libraryId);
			 libraryDTO.setLibraryName(libraryName);
			 libraryDTO.setNoOfBooks(noOfBooks);
			 libraryDTO.setBookName(bookName);

			 libraryService.validateAndAdd(libraryDTO);
			
			 PrintWriter printWriter = resp.getWriter();
			 printWriter.print("Adding the library data");
			 printWriter.flush();
			 printWriter.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		 
	 }

}
