
package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Startseite extends HttpServlet {

		
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

			resp.getWriter().write("Hello World");
	//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
			//req.getRequestDispatcher("/helloWorld.jsp");
			if(req.getParameter("name") != null){
				if(req.getParameter("name").equals("test@mail.de") && req.getParameter("pass").equals("test"))
				{
					System.out.println("login erfolgreich");
					req.setAttribute("name", "Peter");
					//getServletContext().getRequestDispatcher("/NewFile.jsp").forward(req, resp);
					resp.sendRedirect("/Startseite.jsp");
					
					Index.setGoodLogin(true);
				}
			}
			
			if(Index.getGoodLogin()) resp.sendRedirect("/Startseite.jsp");
			else resp.getWriter().write("Deine Mutter ist fett");
			
			
			
			System.out.println(req.getParameter("name"));
			

		}
	}
