package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	// List to store feedback data
	private List<String[]> feedbackList = new ArrayList<>();

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		// Get user input from the feedback form
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String feedback = request.getParameter("feedback");

		// If the form is submitted, store the feedback data
		if (name != null && email != null && feedback != null && !name.isEmpty() && !email.isEmpty()
				&& !feedback.isEmpty()) {
			feedbackList.add(new String[] { name, email, feedback });
		}

		// Display the feedback form and the list of feedback submissions
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h1>Feedback Form</h1>");

		// Form to submit feedback
		response.getWriter().println("<form action='FeedbackServlet' method='post'>");
		response.getWriter().println("<label for='name'>Name:</label><br>");
		response.getWriter().println("<input type='text' id='name' name='name' required><br>");
		response.getWriter().println("<label for='email'>Email:</label><br>");
		response.getWriter().println("<input type='email' id='email' name='email' required><br>");
		response.getWriter().println("<label for='feedback'>Feedback:</label><br>");
		response.getWriter()
				.println("<textarea id='feedback' name='feedback' rows='4' cols='50' required></textarea><br>");
		response.getWriter().println("<button type='submit'>Submit Feedback</button>");
		response.getWriter().println("</form>");

		// Display the list of feedback
		response.getWriter().println("<h2>Feedback Submissions</h2>");
		if (!feedbackList.isEmpty()) {
			response.getWriter().println("<table border='1'>");
			response.getWriter().println("<tr><th>Name</th><th>Email</th><th>Feedback</th></tr>");
			for (String[] feedbackEntry : feedbackList) {
				response.getWriter().println("<tr>");
				response.getWriter().println("<td>" + feedbackEntry[0] + "</td>");
				response.getWriter().println("<td>" + feedbackEntry[1] + "</td>");
				response.getWriter().println("<td>" + feedbackEntry[2] + "</td>");
				response.getWriter().println("</tr>");
			}
			response.getWriter().println("</table>");
		} else {
			response.getWriter().println("<p>No feedback submitted yet.</p>");
		}

		response.getWriter().println("</body></html>");
	}
}
