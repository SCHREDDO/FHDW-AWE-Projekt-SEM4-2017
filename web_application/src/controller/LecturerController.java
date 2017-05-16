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

public class LecturerController extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.getWriter().write("Hello World");
//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
		//req.getRequestDispatcher("/helloWorld.jsp");
		getServletContext().getRequestDispatcher("/Dozenten.jsp").forward(req, resp);

		
		System.out.println(req.getParameter("name"));
		

	}
	
	public void lecturerview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		List<Lecturer> list = new ArrayList<Lecturer>();
		
		db.getObjectDataPersonLecturer();
	}
	
	public void lecturernewview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		Lecturer lecturer = new Lecturer();
	}
	
	public void lecturerdeletview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void lectureshowview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		Lecturer lecturer = new Lecturer();
	}
}