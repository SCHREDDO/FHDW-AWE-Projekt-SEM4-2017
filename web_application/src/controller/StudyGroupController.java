package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import helper.*;
import models.*;

public class StudyGroupController 
{
	public void studygroupview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
		
		List<StudyGroup> list = new ArrayList<StudyGroup>();
		
		db.getObjectData(DBAccessJDBCSQLite.TableName.study_group);
	}
	
	public void studygroupnewview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void studygroupdeletview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
	
	public void studygroupshowview()
	{
		DBAccessJDBCSQLite db = new DBAccessJDBCSQLite();
		db.connectTODB();
	}
}