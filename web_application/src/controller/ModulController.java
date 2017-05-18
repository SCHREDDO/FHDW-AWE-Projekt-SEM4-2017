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

public class ModulController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		List<Modul> moduls = new ArrayList<Modul>();
		
		List<Object[]> objs = db.getObjectData(DBAccessJDBCSQLite.TableName.modul);
		
		for (int i = 0; i < objs.size(); i++) {
			moduls.add(cac.ConvertToModul(objs.get(i)));
		}
		
		req.setAttribute("moduls", moduls);
		
		getServletContext().getRequestDispatcher("/Dozenten.jsp").forward(req, resp);
	}
}