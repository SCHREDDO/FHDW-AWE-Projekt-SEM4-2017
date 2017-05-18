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

public class PersonShowController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		Person person = new Person();
		Permission permission = new Permission();
		
		List<Object[]> temp = new ArrayList<Object[]>();
		
		person.setPeid(Integer.parseInt(req.getParameter("")));
		
		temp = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.person, person.getPeid());
		person = cac.ConvertToPerson(temp.get(0));
		
		temp = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.permission, person.getRight().getRiid());
		permission = cac.ConvertToRight(temp.get(0));
		
		req.setAttribute("person", person);
		
		getServletContext().getRequestDispatcher("/Studenten.jsp").forward(req, resp);
	}
}
