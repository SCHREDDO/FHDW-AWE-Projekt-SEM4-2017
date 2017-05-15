package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import helper.*;
import models.*;

public class ModulController 
{
	public void modulview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		List<Modul> list = new ArrayList<Modul>();
		
		db.getObjectData(DBAccessJDBCSQLite.TableName.modul);
	}
	
	public void modulnewview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void moduldeletview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void modulshowview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
}