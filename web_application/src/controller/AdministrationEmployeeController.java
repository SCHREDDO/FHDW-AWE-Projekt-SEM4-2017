package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import helper.*;
import models.*;

public class AdministrationEmployeeController 
{
	public void administrationemployeeview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		List<AdministrationEmployee> list = new ArrayList<AdministrationEmployee>();
		
		db.getObjectDataPersonAdministrationEmployee();
	}
	
	public void administrationemployeview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void administrationemployedeletview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void administrationemployeshowview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
}