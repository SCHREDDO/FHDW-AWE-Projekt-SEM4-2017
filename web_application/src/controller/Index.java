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
		contect.addServlet(LecturerCreateController.class, "/createDozent");
		contect.addServlet(LecturerEditController.class, "/editDozenten");
		contect.addServlet(LecturerUpdateController.class, "/updateDozenten/Update");
		contect.addServlet(LecturerDeleteController.class, "/deleteDozenten");
		contect.addServlet(LecturerShowController.class, "/showDozent");
		
		contect.addServlet(StudentController.class, "/Studenten");
		contect.addServlet(StudentCreateController.class, "/createStudenten");
		contect.addServlet(StudentEditController.class, "/editStudenten");
		contect.addServlet(StudentUpdateController.class, "/updateStudenten/");
		contect.addServlet(StudentDeleteController.class, "/deleteStudenten/");
		contect.addServlet(StudentShowController.class, "/showStudenten/");
		
		contect.addServlet(AdministrationEmployeeController.class, "/Verwaltung");
		contect.addServlet(AdministrationEmployeeCreateController.class, "/createVerwaltung");
		contect.addServlet(AdministrationEmployeeEditController.class, "/editVerwaltung");
		contect.addServlet(AdministrationEmployeeUpdateController.class, "/updateVerwaltung");
		contect.addServlet(AdministrationEmployeeDeleteController.class, "/deleteVerwaltung");
		contect.addServlet(AdministrationEmployeeShowController.class, "/showVerwaltung");
		
		
		contect.addServlet(PersonController.class, "/Personen");
		contect.addServlet(PersonCreateController.class, "/createPerson");
		contect.addServlet(PersonEditController.class, "/editPerson");
		contect.addServlet(PersonUpdateController.class, "/updatePerson");
		contect.addServlet(PersonDeleteController.class, "/deletePerson");
		contect.addServlet(PersonShowController.class, "/showPerson");
		
		contect.addServlet(ModulController.class, "/Modul");
		contect.addServlet(ModulCreateController.class, "/createModul");
		contect.addServlet(ModulShowController.class, "/showModul");
		
		contect.addServlet(StudyGroupController.class, "/Kurse");
		contect.addServlet(StudyGroupCreateController.class, "/createKurse");
		contect.addServlet(StudyGroupShowController.class, "/showKurse");
		
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
