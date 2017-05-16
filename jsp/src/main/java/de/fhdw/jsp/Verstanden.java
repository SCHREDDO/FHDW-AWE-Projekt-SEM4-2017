
package de.fhdw.jsp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Verstanden extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

			resp.getWriter().write("Hello World");
	//		System.out.println(req.getRequestDispatcher("/helloWorld.jsp"));
			//req.getRequestDispatcher("/helloWorld.jsp");
			List<Student> students = new ArrayList<Student>();
			students.add(new Student(123, 123));
			students.add(new Student(1234,1234));
			students.add(new Student(12345, 12345));
			req.setAttribute("student", students);
			System.out.println("Studis erstellt");
			System.out.println(students.get(1).zahl);


			if(req.getParameter("name").equals("test@mail.de") && req.getParameter("pass").equals("test"))
			{
				System.out.println("login erfolgreich");
				req.setAttribute("name", "Peter");
				//getServletContext().getRequestDispatcher("/NewFile.jsp").forward(req, resp);
				resp.sendRedirect("/NewFile.jsp");
			}
			else 
				//getServletContext().getRequestDispatcher("/helloWorld.jsp").forward(req, resp);
			
			
			System.out.println(req.getParameter("name"));
			

		}
	}
