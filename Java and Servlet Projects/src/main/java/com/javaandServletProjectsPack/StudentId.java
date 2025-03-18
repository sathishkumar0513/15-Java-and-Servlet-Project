package com.javaandServletProjectsPack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentId")
public class StudentId extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Set the response content type
		res.setContentType("text/html");

		// Retrieve parameters from the request
		String name = req.getParameter("name");
		String idParam = req.getParameter("id");
		String ageParam = req.getParameter("age");
		String addr = req.getParameter("addr");
		String dg = req.getParameter("dg");

		// Initialize variables
		int id = 0;
		int age = 0;

		// Parse id and age with error handling
		try {
			id = Integer.parseInt(idParam);
			age = Integer.parseInt(ageParam);
		} catch (NumberFormatException e) {
			res.getWriter().println("<h3>Error: 'id' and 'age' must be valid integers.</h3>");
			return;
		}

		// HTML response
		PrintWriter writer = res.getWriter();
		writer.println("<html><body>");
		writer.println("<h2>Student Information:</h2>");
		writer.println("<p>Name: " + name + "</p>");
		writer.println("<p>Student ID: " + id + "</p>");
		writer.println("<p>Age: " + age + "</p>");
		writer.println("<p>Address: " + addr + "</p>");
		writer.println("<p>Degree: " + dg + "</p>");
		writer.println("</body></html>");
	}
}
