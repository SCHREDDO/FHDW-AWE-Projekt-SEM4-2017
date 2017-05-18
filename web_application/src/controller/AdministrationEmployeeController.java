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

public class AdministrationEmployeeController  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		List<AdministrationEmployee> administrationemployees = new ArrayList<AdministrationEmployee>();
		List<Person> persons = new ArrayList<Person>();
		
		List<Object[]> objs = db.getObjectDataPersonAdministrationEmployee();
		
		for (int i = 0; i < objs.size(); i++) {
			administrationemployees.add(cac.ConvertToAdministrationEmployee(objs.get(i)));
		}
		
		objs = db.getObjectData(DBAccessJDBCSQLite.TableName.person);
		for (int i = 0; i < objs.size(); i++) {
			persons.add(cac.ConvertToPerson(objs.get(i)));
		}
		
		req.setAttribute("administrationemployees", administrationemployees);
		req.setAttribute("persons", persons);
		
		getServletContext().getRequestDispatcher("/Vervaltung.jsp").forward(req, resp);
	}
}