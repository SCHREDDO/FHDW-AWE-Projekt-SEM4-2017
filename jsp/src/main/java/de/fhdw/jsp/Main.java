package de.fhdw.jsp;

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

public class Main {

	public static void main(String[] args) throws Exception {
		URL rootURL = Main.class.getClassLoader().getResource("webroot");
		String rootURLString = rootURL.toExternalForm();

		Server server = new Server(8080);
		WebAppContext contect = new WebAppContext(rootURLString, "/");
		contect.addServlet(HelloWorldServlet.class, "/hello");
		contect.addServlet(Verstanden.class,"/klar");
		server.setHandler(contect);
		
		server.start();
		System.out.println("server gestartet");
		server.join();
	}

	
}
