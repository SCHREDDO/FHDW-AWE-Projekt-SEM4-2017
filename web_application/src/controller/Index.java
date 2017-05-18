package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Index {
	
	public static boolean goodLogin = false;

	public static void main(String[] args) throws Exception {
		URL rootURL = Index.class.getClassLoader().getResource("resources");
		String rootURLString = rootURL.toExternalForm();

		Server server = new Server(8080);
		WebAppContext contect = new WebAppContext(rootURLString, "/");
		contect.addServlet(LoginController.class, "/Index");
		contect.addServlet(Startseite.class, "/Startseite");
		
		contect.addServlet(LecturerController.class, "/Dozenten");
		contect.addServlet(LecturerCreateController.class, "/Dozenten/Create");
		contect.addServlet(LecturerEditController.class, "/Dozenten/Edit");
		contect.addServlet(LecturerUpdateController.class, "/Dozenten/Update");
		contect.addServlet(LecturerDeleteController.class, "/Dozenten/Delete");
		contect.addServlet(LecturerShowController.class, "/Dozenten/Show");
		
		contect.addServlet(StudentController.class, "/Studenten.jsp");
		contect.addServlet(StudentCreateController.class, "/Studenten/Create");
		contect.addServlet(StudentEditController.class, "/Studenten/Edit");
		contect.addServlet(StudentUpdateController.class, "/Studenten/Update");
		contect.addServlet(StudentDeleteController.class, "/Studenten/Delete");
		contect.addServlet(StudentShowController.class, "/Studenten/Show");
		
		contect.addServlet(AdministrationEmployeeController.class, "/Verwaltung");
		contect.addServlet(AdministrationEmployeeCreateController.class, "/Verwaltung/Create");
		contect.addServlet(AdministrationEmployeeEditController.class, "/Verwaltung/Edit");
		contect.addServlet(AdministrationEmployeeUpdateController.class, "/Verwaltung/Update");
		contect.addServlet(AdministrationEmployeeDeleteController.class, "/Verwaltung/Delete");
		contect.addServlet(AdministrationEmployeeShowController.class, "/Verwaltung/Show");
		
		
		contect.addServlet(PersonController.class, "/Person");
		contect.addServlet(PersonCreateController.class, "/Person/Create");
		contect.addServlet(PersonEditController.class, "/Person/Edit");
		contect.addServlet(PersonUpdateController.class, "/Person/Update");
		contect.addServlet(PersonDeleteController.class, "/Person/Delete");
		contect.addServlet(PersonShowController.class, "/Person/Show");
		
		contect.addServlet(ModulController.class, "/Modul");
		contect.addServlet(ModulCreateController.class, "/Modul/Create");
		contect.addServlet(ModulShowController.class, "/Modul/Show");
		
		contect.addServlet(StudyGroupController.class, "/Kurse");
		contect.addServlet(StudyGroupCreateController.class, "/Kurse/Create");
		contect.addServlet(StudyGroupShowController.class, "/Kurse/Show");
		
		contect.addServlet(Kontakt.class, "/Kontakt");
		//contect.addServlet(editDozenten.class, "/editDozenten");
		//contect.addServlet(deleteDozenten.class, "/deleteDozenten");
		//contect.addServlet(editStudent.class, "/editStudent");
		//contect.addServlet(deleteStudent.class, "/deleteStudent");
		//contect.addServlet(newStudent.class, "/newStudent");
		//contect.addServlet(newDozent.class, "/newDozent");

		server.setHandler(contect);
		
		server.start();
		System.out.println("server gestartet");
		server.join();
	}

	public static boolean getGoodLogin(){
		return goodLogin;
		
	}
	
	public static void setGoodLogin(boolean bool){
		
		goodLogin = bool;
	}
}
