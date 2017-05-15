package controller;
<<<<<<< HEAD
import java.awt.List;
import java.util.Set;

import com.sun.glass.ui.TouchInputSupport;
import com.sun.org.apache.xpath.internal.operations.Mod;
=======
>>>>>>> origin/master

import helper.*;

public class MainController {

	public void rtest()
	{
		DBAccessJDBCSQLite test = new DBAccessJDBCSQLite();
		test.
	}
<<<<<<< HEAD

	public StudyGroup getStudyGroup() {
		return studyGroup;
	}

	public void setStudyGroup(StudyGroup studyGroup) {
		this.studyGroup = studyGroup;
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

	public ConvertObjectAndClass getConvertObjectAndClass() {
		return convertObjectAndClass;
	}

	public void setConvertObjectAndClass(ConvertObjectAndClass convertObjectAndClass) {
		this.convertObjectAndClass = convertObjectAndClass;
	}

	public DBAccessJDBC getDbAccessJDBC() {
		return dbAccessJDBC;
	}

	public void setDbAccessJDBC(DBAccessJDBC dbAccessJDBC) {
		this.dbAccessJDBC = dbAccessJDBC;
	}

	public DBAccessJDBCSQLite getDbAccessJDBCSQLite() {
		return dbAccessJDBCSQLite;
	}

	public void setDbAccessJDBCSQLite(DBAccessJDBCSQLite dbAccessJDBCSQLite) {
		this.dbAccessJDBCSQLite = dbAccessJDBCSQLite;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	private Lecturer lecturer;
	private Modul modul;
	private ModulLecturer modulLecturer;
	private Person person;
	private Permission right;
	private Student student;
	private StudyGroup studyGroup;
	
	private MainView mainView;
	
    private ConvertObjectAndClass convertObjectAndClass;
    private DBAccessJDBC dbAccessJDBC;
    private DBAccessJDBCSQLite dbAccessJDBCSQLite;
    
    private String currentStatus;
    
    public MainController(){
    	
    }
    
    public void GetRequestFromView(){}
    public void GetDataFromView(){}
    public void SetCurrentView(){}
    public String GetCurrentView(){
    	return this.currentStatus;
    }
    
    public void GetDataFromDatabase(){}

    
   }


=======
}
>>>>>>> origin/master
