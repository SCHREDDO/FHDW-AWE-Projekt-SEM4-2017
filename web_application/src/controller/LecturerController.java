package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import helper.*;
import models.*;

public class LecturerController 
{
	public void lecturerview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		List<Lecturer> list = new ArrayList<Lecturer>();
		
		db.getObjectDataPersonLecturer();
	}
	
	public void lecturernewview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		Lecturer lecturer = new Lecturer();
	}
	
	public void lecturerdeletview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void lectureshowview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		Lecturer lecturer = new Lecturer();
	}
}