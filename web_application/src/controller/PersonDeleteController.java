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

public class PersonDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();

		if(db.delete(Integer.parseInt(req.getParameter("peid")), DBAccessJDBCSQLite.TableName.person))
		{
			req.setAttribute("info", "");
		}
		else
		{
			req.setAttribute("info", "");
		}	
		
		getServletContext().getRequestDispatcher("/DeletePerson.jsp").forward(req, resp);
	}
}
