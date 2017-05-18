
package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;
import helper.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class Startseite extends HttpServlet {

		
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
			DBAccessJDBCSQLite db = new DBAccessJDBCSQLite(); //obj erstellen
			db.connectTODB(); //verbindung aufbauen

	//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
			//req.getRequestDispatcher("/helloWorld.jsp");
			if(db.login(req.getParameter("name"), req.getParameter("pass"))) 
			{
				User user = db.getlogindata(req.getParameter("name"), req.getParameter("pass"));
				
				HttpSession session = req.getSession(true);
				session.setAttribute("currentSessionUser", user);
				resp.sendRedirect("/Startseite.jsp");
			}
			else 
			{
				getServletContext().getRequestDispatcher("/Login.jsp").forward(req, resp);
			}
	}
}
