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

public class PersonEditController extends HttpServlet{
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
			List<Permission> permission = new ArrayList<Permission>();
			
			List<Object[]> temp = new ArrayList<Object[]>();
			temp = db.getObjectData(DBAccessJDBCSQLite.TableName.permission);
			
			for (int i = 0; i < temp.size(); i++) {
				permission.add(cac.ConvertToRight(temp.get(i)));
			}
			
			temp = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.person, Integer.parseInt(req.getParameter("peid")));
			
			person = cac.ConvertToPerson(temp.get(0));
			
			req.setAttribute("permission", permission);
			req.setAttribute("person", person);
			
			
			getServletContext().getRequestDispatcher("/EditPerson.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
