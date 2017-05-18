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

public class PersonCreateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();

		Person person = new Person();
		
		person.setFirstname(req.getParameter("firstname"));
		person.setLarstname(req.getParameter("lastname"));
		person.setShortname(req.getParameter("shortname"));
		Permission p = new Permission();
		p.setRiid(Integer.parseInt(req.getParameter("pid")));
		person.setRight(p);
		person.setE_mail(req.getParameter("e_mail"));
		person.setPassword(req.getParameter("password"));
		person.setAddreass(req.getParameter("address"));
		person.setPhoneNumber(Integer.parseInt(req.getParameter("phone_number")));
		
		List<Object[]> temp = new ArrayList<Object[]>();
		temp.add(cac.ConvertToPerson(person));
		
		if(db.insertIntoStudent(temp))
		{
			req.setAttribute("info", "");
		}
		else
		{
			req.setAttribute("info", "");
		}
		
		getServletContext().getRequestDispatcher("/CreatePerson.jsp").forward(req, resp);
	}
}
