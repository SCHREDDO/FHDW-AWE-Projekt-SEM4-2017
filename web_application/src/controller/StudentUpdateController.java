package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.beans.util.Cache;

import helper.*;
import models.*;

public class StudentUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		Student student = new Student();
		StudyGroup studygroup = new StudyGroup();
		
		studygroup.setSgid(Integer.parseInt(req.getParameter("")));
		
		student.setPeid(Integer.parseInt(req.getParameter("")));
		student.setStid(Integer.parseInt(req.getParameter("")));
		student.setMatrikelnumber(Integer.parseInt(req.getParameter("")));
		student.setGroup(studygroup);
		
		List<Object[]> temp = new ArrayList<Object[]>();
		temp.add(cac.ConvertToStudento(student));
		
		if(db.updateStudent(temp))
		{
			req.setAttribute("info", "");
		}
		else
		{
			req.setAttribute("info", "");
		}	
		
		getServletContext().getRequestDispatcher("/Studenten.jsp").forward(req, resp);
	}
}
