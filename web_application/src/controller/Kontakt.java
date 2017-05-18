package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.*;
import models.*;

public class Kontakt extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			resp.getWriter().write("Hello World");
	//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
			//req.getRequestDispatcher("/helloWorld.jsp");
			getServletContext().getRequestDispatcher("/Kontakt.jsp").forward(req, resp);
	
			
			System.out.println(req.getParameter("name"));
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
		

	}
	
}