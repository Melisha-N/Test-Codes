package com.wolken.wolkenapp.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;

@WebServlet("/updatelib")
public class UpdateServlet extends HttpServlet{
	
		LibraryService libraryService = new LibraryServiceImpl();

		public UpdateServlet() {
			System.out.println("Inside Library Update Servlet"+getClass());
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
				
				String bookName = req.getParameter("bnm");
				String noBook = req.getParameter("nbks");
				int noOfBooks = Integer.parseInt(noBook);
				
				libraryService.validateAndUpdateBookName(bookName, noOfBooks);
				
				resp.setContentType("text/html");
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("<body><a href = 'getlib.jsp'>Go Back</a></body>");
				printWriter.flush();
				printWriter.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

