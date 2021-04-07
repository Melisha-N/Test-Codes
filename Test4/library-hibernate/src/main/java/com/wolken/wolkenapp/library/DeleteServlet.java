package com.wolken.wolkenapp.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolken.wolkenapp.dao.LibraryDAOImpl;
import com.wolken.wolkenapp.service.LibraryService;
import com.wolken.wolkenapp.service.LibraryServiceImpl;

@WebServlet("/deletelib")
public class DeleteServlet extends HttpServlet{
		
		LibraryService libraryService = new LibraryServiceImpl();

		public DeleteServlet() {
			System.out.println("Inside Library Delete Servlet");
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				
				String libraryName = req.getParameter("lnm");
				PrintWriter printWriter = resp.getWriter();
				boolean status = libraryService.validateAndDeleteByLibraryName(libraryName);
				if(status) {
					
				resp.setContentType("text/html");
				
				printWriter.print("data is deleted successfully\n");
				printWriter.print("<body><a href = 'getlib.jsp'>Go Back</body>");
				printWriter.flush();
				printWriter.close();
				}
				else {
					printWriter.print("There is no such entity to be deleted!\n");
					}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		}
		
}
