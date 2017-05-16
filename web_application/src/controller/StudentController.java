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

public class StudentController extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.getWriter().write("Hello World");
//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
		//req.getRequestDispatcher("/helloWorld.jsp");
		getServletContext().getRequestDispatcher("/Studenten.jsp").forward(req, resp);

		
		System.out.println(req.getParameter("name"));
		

	}
	
	public void studentview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		List<Student> list = new ArrayList<Student>();
		
		db.getObjectDataPersonStudent();
	}
	
	public void studentnewview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void studentdeletview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void studentshowview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
}