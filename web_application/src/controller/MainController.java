package controller;
import java.awt.List;

import com.sun.glass.ui.TouchInputSupport;
import com.sun.org.apache.xpath.internal.operations.Mod;

import helper.*;
import models.*;
import views.*;


public class MainController {
	// Eingabe je eine Methode
	
	// Ausgabe je eine Methode
	
	
	private AdministrationEmployee administrationEmployee;
	public AdministrationEmployee getAdministrationEmployee() {
		return administrationEmployee;
	}

	public void setAdministrationEmployee(AdministrationEmployee administrationEmployee) {
		this.administrationEmployee = administrationEmployee;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Modul getModul() {
		return modul;
	}

	public void setModul(Modul modul) {
		this.modul = modul;
	}

	public ModulLecturer getModulLecturer() {
		return modulLecturer;
	}

	public void setModulLecturer(ModulLecturer modulLecturer) {
		this.modulLecturer = modulLecturer;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Permission getRight() {
		return right;
	}

	public void setRight(Permission right) {
		this.right = right;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

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


