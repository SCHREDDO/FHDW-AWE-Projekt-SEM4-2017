package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.*;
import models.*;

public class Kontakt extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.getWriter().write("Hello World");
//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
		//req.getRequestDispatcher("/helloWorld.jsp");
		getServletContext().getRequestDispatcher("/Kontakt.jsp").forward(req, resp);

		
		System.out.println(req.getParameter("name"));
		

	}
	
}