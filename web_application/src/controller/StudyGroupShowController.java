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

public class StudyGroupShowController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		StudyGroup studygroup = new StudyGroup();
		List<Student> students = new ArrayList<Student>();
		
		List<Object[]> objs = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.study_group, Integer.parseInt(req.getParameter("")));
		
		studygroup = cac.ConvertToStudyGroup(objs.get(0));
		
		objs = db.getObjectDataStudentGroup(studygroup.getSgid());
		
		for (int i = 0; i < objs.size(); i++) {
			students.add(cac.ConvertToStudent(objs.get(i)));
		}
		
		req.setAttribute("studygroup", studygroup);
		req.setAttribute("students", students);
		
		getServletContext().getRequestDispatcher("/Dozenten.jsp").forward(req, resp);
	}
}
