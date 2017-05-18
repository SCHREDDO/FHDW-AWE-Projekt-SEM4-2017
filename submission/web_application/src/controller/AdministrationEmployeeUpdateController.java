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

public class AdministrationEmployeeUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
			ConvertObjectAndClass cac = new ConvertObjectAndClass();
			db.connectTODB();
			
			AdministrationEmployee administrationemployee = new AdministrationEmployee();
			
			administrationemployee.setPeid(Integer.parseInt(req.getParameter("peid")));
			administrationemployee.setAeid(Integer.parseInt(req.getParameter("aeid")));
			administrationemployee.setTask_area(req.getParameter("task_area"));
			
			List<Object[]> temp = new ArrayList<Object[]>();
			temp.add(cac.ConvertToAdministrationEmployeeo(administrationemployee));
			
			if(db.updateAdministrationEmployee(temp))
			{
				req.setAttribute("info", "");
			}
			else
			{
				req.setAttribute("info", "");
			}
			
			getServletContext().getRequestDispatcher("/UpdateVervaltung.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
