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

public class StudyGroupCreateController extends HttpServlet{
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
			
			studygroup.setShortName(req.getParameter("shortname"));
			
			List<Object[]> temp = new ArrayList<Object[]>();
			temp.add(cac.ConvertToStudyGroup(studygroup));
			
			if(db.insertIntoStudyGroup(temp))
			{
				req.setAttribute("info", "");
			}
			else
			{
				req.setAttribute("info", "");
			}
			
			getServletContext().getRequestDispatcher("/CreateKurs.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
