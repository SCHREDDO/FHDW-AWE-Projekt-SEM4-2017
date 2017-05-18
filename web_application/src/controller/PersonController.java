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

public class PersonController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		List<Person> poersons = new ArrayList<Person>();
		
		List<Object[]> objs = db.getObjectData(DBAccessJDBCSQLite.TableName.person);
		
		for (int i = 0; i < objs.size(); i++) {
			poersons.add(cac.ConvertToPerson(objs.get(i)));
		}
		
		req.setAttribute("poersons", poersons);
		
		getServletContext().getRequestDispatcher("/Studenten.jsp").forward(req, resp);
	}
}
