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

public class ModulShowController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		Modul modul = new Modul();
		
		List<Object[]> objs = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.modul, Integer.parseInt(req.getParameter("")));
		
		modul = cac.ConvertToModul(objs.get(0));
		
		req.setAttribute("modul", modul);
		
		getServletContext().getRequestDispatcher("/ShowModul.jsp").forward(req, resp);
	}
}
