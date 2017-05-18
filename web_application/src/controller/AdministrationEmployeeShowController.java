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

public class AdministrationEmployeeShowController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		AdministrationEmployee administrationemployee = new AdministrationEmployee();
		List<Object[]> temp = new ArrayList<Object[]>();
		
		temp = db.getObjectDataPersonAdministrationEmployee();
		
		administrationemployee = cac.ConvertToAdministrationEmployee(temp.get(0));
		
		req.setAttribute("administrationemployee", administrationemployee);
		
		getServletContext().getRequestDispatcher("/ShowVervaltung.jsp").forward(req, resp);
	}
}
