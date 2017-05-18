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

public class LecturerShowController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		Lecturer lecturer = new Lecturer();
		List<Object[]> temp = new ArrayList<Object[]>();
		
		temp = db.getObjectDataPersonLecturer(Integer.parseInt(req.getParameter("leid")));
		lecturer = cac.ConvertToLecturer(temp.get(0));
		
		req.setAttribute("lecturer", lecturer);
		
		getServletContext().getRequestDispatcher("/ShowDozent.jsp").forward(req, resp);
	}
}
