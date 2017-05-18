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

public class StudyGroupController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
			ConvertObjectAndClass cac = new ConvertObjectAndClass();
			db.connectTODB();
			
			List<StudyGroup> studygroups = new ArrayList<StudyGroup>();
			
			List<Object[]> objs = db.getObjectData(DBAccessJDBCSQLite.TableName.study_group);
			
			for (int i = 0; i < objs.size(); i++) {
				studygroups.add(cac.ConvertToStudyGroup(objs.get(i)));
			}
			
			req.setAttribute("studygroups", studygroups);
			
			getServletContext().getRequestDispatcher("/Kurse.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}