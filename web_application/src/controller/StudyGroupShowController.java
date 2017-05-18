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

public class StudyGroupShowController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
			ConvertObjectAndClass cac = new ConvertObjectAndClass();
			db.connectTODB();
			
			StudyGroup studygroup = new StudyGroup();
			List<Student> students = new ArrayList<Student>();
			
			List<Object[]> objs = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.study_group, Integer.parseInt(req.getParameter("sgid")));
			
			studygroup = cac.ConvertToStudyGroup(objs.get(0));
			
			objs = db.getObjectDataStudentGroup(studygroup.getSgid());
			
			for (int i = 0; i < objs.size(); i++) {
				students.add(cac.ConvertToStudent(objs.get(i)));
			}
			
			req.setAttribute("studygroup", studygroup);
			req.setAttribute("students", students);
			
			getServletContext().getRequestDispatcher("/ShowKurs.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
