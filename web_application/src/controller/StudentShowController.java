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

public class StudentShowController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
			ConvertObjectAndClass cac = new ConvertObjectAndClass();
			db.connectTODB();
			
			Student student = new Student();
			List<Object[]> temp = new ArrayList<Object[]>();
			
			temp = db.getObjectDataPersonStudent(Integer.parseInt(req.getParameter("stid")));
			student = cac.ConvertToStudent(temp.get(0));
			
			req.setAttribute("student", student);
			
			getServletContext().getRequestDispatcher("/ShowStudent.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
