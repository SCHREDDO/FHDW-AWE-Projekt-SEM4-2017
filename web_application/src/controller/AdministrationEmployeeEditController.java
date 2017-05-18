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

public class AdministrationEmployeeEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
			ConvertObjectAndClass cac = new ConvertObjectAndClass();
			db.connectTODB();
			
			List<Person> persons = new ArrayList<Person>();
			
			List<Object[]> temp = new ArrayList<Object[]>();
			
			temp = db.getObjectData(DBAccessJDBCSQLite.TableName.person);
			for (int i = 0; i < temp.size(); i++) {
				persons.add(cac.ConvertToPerson(temp.get(i)));
			}
			
			AdministrationEmployee administrationemployee = new AdministrationEmployee();
			
			List<Object[]> objs = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.administration_employee, Integer.parseInt(req.getParameter("")));
			
			administrationemployee = cac.ConvertToAdministrationEmployeeo(objs.get(0));
			
			req.setAttribute("administrationemployee", administrationemployee);
			req.setAttribute("persons", persons);
	
			getServletContext().getRequestDispatcher("/EditVervaltung.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
