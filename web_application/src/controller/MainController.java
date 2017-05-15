package controller;

import java.util.Set;
import helper.*;
import models.*;

public class MainController 
{
	public void indexview()
	{
		
	}
	
	public void loginview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		String shortname = "";
		String password = "";
		
		db.login(shortname, password);
	}
}