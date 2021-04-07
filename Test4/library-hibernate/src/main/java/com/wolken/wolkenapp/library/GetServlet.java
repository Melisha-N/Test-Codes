package com.wolken.wolkenapp.library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.dto.LibraryDTO;
import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;

@WebServlet("/getlib")
public class GetServlet extends HttpServlet{
	
	LibraryDTO libraryDTO = new LibraryDTO();
	LibraryService libraryService = new LibraryServiceImpl();
	
	public GetServlet() {
			System.out.println("Inside Library Get Servlet "+getClass());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			List<LibraryDTO> libraryList = libraryService.validateAndGetAll(libraryDTO);
			req.setAttribute("libraryList", libraryList);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("finalgetlib.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
