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
		contect.addServlet(StudentController.class, "/Student");
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
