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

public class ModulCreateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		Modul modul = new Modul();
		
		modul.setName(req.getParameter(""));
		modul.setShort_name(req.getParameter(""));
		modul.setCreditpoints(Integer.parseInt(req.getParameter("")));
		
		List<Object[]> temp = new ArrayList<Object[]>();
		temp.add(cac.ConvertToModul(modul));
		
		if(db.insertIntoModul(temp))
		{
			req.setAttribute("info", "");
		}
		else
		{
			req.setAttribute("info", "");
		}
		
		getServletContext().getRequestDispatcher("/Dozenten.jsp").forward(req, resp);
	}
}
