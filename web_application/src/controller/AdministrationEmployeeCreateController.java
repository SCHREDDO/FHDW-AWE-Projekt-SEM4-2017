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

public class AdministrationEmployeeCreateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		AdministrationEmployee administrationemployee = new AdministrationEmployee();
		
		administrationemployee.setPeid(Integer.parseInt(req.getParameter("")));
		administrationemployee.setTask_area(req.getParameter(""));
		
		List<Object[]> temp = new ArrayList<Object[]>();
		temp.add(cac.ConvertToAdministrationEmployeeo(administrationemployee));
		
		if(db.insertIntoAdministrationEmployee(temp))
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
