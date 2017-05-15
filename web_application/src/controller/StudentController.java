package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import helper.*;
import models.*;

public class StudentController 
{
	public void studentview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		List<Student> list = new ArrayList<Student>();
		
		db.getObjectDataPersonStudent();
	}
	
	public void studentnewview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void studentdeletview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void studentshowview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
}