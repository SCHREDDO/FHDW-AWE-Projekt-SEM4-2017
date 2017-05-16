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

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		List<Lecturer> lecturers = new ArrayList<Lecturer>();
		
		List<Object[]> objs = db.getObjectDataPersonLecturer();
		
		for (int i = 0; i < objs.size(); i++) {
			lecturers.add(cac.ConvertToLecturer(objs.get(i)));
		}
		req.setAttribute("lecturers", lecturers);
		
		resp.getWriter().write("Hello World");
//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
		//req.getRequestDispatcher("/helloWorld.jsp");
		getServletContext().getRequestDispatcher("/Dozenten.jsp").forward(req, resp);

		
		System.out.println(req.getParameter("name"));
		

	}
}