package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EventRegistrationServlet")
public class EventRegistrationServlet extends HttpServlet {
	// List to store registered users
	private List<String[]> registeredUsers = new ArrayList<>();

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		// Get user input from the form
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String eventPreference = request.getParameter("eventPreference");

		// If the form is submitted, store the user's data
		if (name != null && email != null && eventPreference != null && !name.isEmpty() && !email.isEmpty()
				&& !eventPreference.isEmpty()) {
			registeredUsers.add(new String[] { name, email, eventPreference });
		}

		// Display the registration form and the list of registered users
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h1>Event Registration</h1>");

		// Form to register for the event
		response.getWriter().println("<form action='EventRegistrationServlet' method='post'>");
		response.getWriter().println("<label for='name'>Name:</label><br>");
		response.getWriter().println("<input type='text' id='name' name='name' required><br>");
		response.getWriter().println("<label for='email'>Email:</label><br>");
		response.getWriter().println("<input type='email' id='email' name='email' required><br>");
		response.getWriter().println("<label for='eventPreference'>Event Preference:</label><br>");
		response.getWriter().println("<input type='text' id='eventPreference' name='eventPreference' required><br>");
		response.getWriter().println("<button type='submit'>Register</button>");
		response.getWriter().println("</form>");

		// Display the list of registered users
		response.getWriter().println("<h2>Registered Users</h2>");
		if (!registeredUsers.isEmpty()) {
			response.getWriter().println("<table border='1'>");
			response.getWriter().println("<tr><th>Name</th><th>Email</th><th>Event Preference</th></tr>");
			for (String[] user : registeredUsers) {
				response.getWriter().println("<tr>");
				response.getWriter().println("<td>" + user[0] + "</td>");
				response.getWriter().println("<td>" + user[1] + "</td>");
				response.getWriter().println("<td>" + user[2] + "</td>");
				response.getWriter().println("</tr>");
			}
			response.getWriter().println("</table>");
		} else {
			response.getWriter().println("<p>No users have registered yet.</p>");
		}

		response.getWriter().println("</body></html>");
	}
}
