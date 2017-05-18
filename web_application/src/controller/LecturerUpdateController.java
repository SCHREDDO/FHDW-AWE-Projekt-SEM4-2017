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

public class LecturerUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		Lecturer lecturer = new Lecturer();
		
		lecturer.setPeid(Integer.parseInt(req.getParameter("peid")));
		lecturer.setLeid(Integer.parseInt(req.getParameter("leid")));
		if (req.getParameter("is_honouree_lecturer") == "1")
		{
			lecturer.setIs_honouree_lecturer(true);
		}
		else 
		{
			lecturer.setIs_honouree_lecturer(false);
		}
		
		List<Object[]> temp = new ArrayList<Object[]>();
		temp.add(cac.ConvertToLecturero(lecturer));
		
		if(db.updateLecturer(temp))
		{
			req.setAttribute("info", "");
		}
		else
		{
			req.setAttribute("info", "");
		}
		
		getServletContext().getRequestDispatcher("/UpdateDozenten.jsp").forward(req, resp);
	}
}
