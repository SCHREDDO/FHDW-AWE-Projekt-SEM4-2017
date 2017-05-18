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

public class PersonController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		if (user != null)
		{
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
			ConvertObjectAndClass cac = new ConvertObjectAndClass();
			db.connectTODB();
			
			List<Person> poersons = new ArrayList<Person>();
			List<Permission> permissions = new ArrayList<Permission>();
			
			List<Object[]> objs = db.getObjectData(DBAccessJDBCSQLite.TableName.person);
			
			for (int i = 0; i < objs.size(); i++) {
				poersons.add(cac.ConvertToPerson(objs.get(i)));
			}
			
			objs = db.getObjectData(DBAccessJDBCSQLite.TableName.permission);
			
			for (int i = 0; i < objs.size(); i++) {
				permissions.add(cac.ConvertToRight(objs.get(i)));
			}
			
			req.setAttribute("poersons", poersons);
			req.setAttribute("permissions", permissions);
			req.setAttribute("rpid", user.getPid());
			
			getServletContext().getRequestDispatcher("/Personen.jsp").forward(req, resp);
		}
		else 
		{
			getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
	}
}
