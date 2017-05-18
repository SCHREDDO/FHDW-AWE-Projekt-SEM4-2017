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

public class PersonShowController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
			ConvertObjectAndClass cac = new ConvertObjectAndClass();
			db.connectTODB();
			
			Person person = new Person();
			Permission permission = new Permission();
			
			List<Object[]> temp = new ArrayList<Object[]>();
			
			person.setPeid(Integer.parseInt(req.getParameter("peid")));
			
			temp = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.person, person.getPeid());
			person = cac.ConvertToPerson(temp.get(0));
			
			temp = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.permission, person.getRight().getRiid());
			permission = cac.ConvertToRight(temp.get(0));
			
			req.setAttribute("person", person);
			
			getServletContext().getRequestDispatcher("/ShowPerson.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
