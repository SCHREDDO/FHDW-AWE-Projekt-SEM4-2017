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

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		List<Student> students = new ArrayList<Student>();
		
		List<Object[]> objs = db.getObjectDataPersonStudent();
		
		for (int i = 0; i < objs.size(); i++) {
			students.add(cac.ConvertToStudent(objs.get(i)));
		}
		req.setAttribute("students", students);
		
		resp.getWriter().write("Hello World");
//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
		//req.getRequestDispatcher("/helloWorld.jsp");
		getServletContext().getRequestDispatcher("/Studenten.jsp").forward(req, resp);

		
		System.out.println(req.getParameter("name"));
		

	}
}