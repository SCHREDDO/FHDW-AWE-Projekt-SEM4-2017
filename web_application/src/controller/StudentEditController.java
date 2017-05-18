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

public class StudentEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		ConvertObjectAndClass cac = new ConvertObjectAndClass();
		db.connectTODB();
		
		List<Person> persons = new ArrayList<Person>();
		List<StudyGroup> studygroups = new ArrayList<StudyGroup>();
		
		List<Object[]> temp = new ArrayList<Object[]>();
		
		temp = db.getObjectData(DBAccessJDBCSQLite.TableName.study_group);
		for (int i = 0; i < temp.size(); i++) {
			studygroups.add(cac.ConvertToStudyGroup(temp.get(i)));
		}
		
		temp = db.getObjectData(DBAccessJDBCSQLite.TableName.person);
		for (int i = 0; i < temp.size(); i++) {
			persons.add(cac.ConvertToPerson(temp.get(i)));
		}
		
		Student student = new Student();
		
		List<Object[]> objs = db.getObjectDataByID(DBAccessJDBCSQLite.TableName.student, Integer.parseInt(req.getParameter("")));
		
		student = cac.ConvertToStudento(objs.get(0));
		
		req.setAttribute("student", student);
		req.setAttribute("studygroups", studygroups);
		req.setAttribute("persons", persons);

		
		getServletContext().getRequestDispatcher("/EditStudenten.jsp").forward(req, resp);
	}
}
