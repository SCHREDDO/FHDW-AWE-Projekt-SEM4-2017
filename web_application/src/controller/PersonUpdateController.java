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

public class PersonUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();

		Person person = new Person();
		
		person.setPeid(Integer.parseInt(req.getParameter("")));
		person.setFirstname(req.getParameter(""));
		person.setLarstname(req.getParameter(""));
		person.setShortname(req.getParameter(""));
		Permission p = new Permission();
		p.setRiid(Integer.parseInt(req.getParameter("")));
		person.setRight(p);
		person.setE_mail(req.getParameter(""));
		person.setPassword(req.getParameter(""));
		person.setAddreass(req.getParameter(""));
		person.setPhoneNumber(Integer.parseInt(req.getParameter("")));
		
		List<Object[]> temp = new ArrayList<Object[]>();
		temp.add(cac.ConvertToPerson(person));
		
		if(db.updatePerson(temp))
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
