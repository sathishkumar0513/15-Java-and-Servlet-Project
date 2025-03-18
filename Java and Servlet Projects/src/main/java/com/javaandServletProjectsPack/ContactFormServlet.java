package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/ContactFormServlet")
public class ContactFormServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		response.setContentType("text/html");
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h1>Contact Form Submitted</h1>");
		response.getWriter().println("<p>Name: " + name + "</p>");
		response.getWriter().println("<p>Email: " + email + "</p>");
		response.getWriter().println("<p>Message: " + message + "</p>");
		response.getWriter().println("<a href='contact.html'>Back</a>");
		response.getWriter().println("</body></html>");
	}
}
