package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		String operation = request.getParameter("operation");
		double result = 0;

		switch (operation) {
		case "add":
			result = num1 + num2;
			break;
		case "subtract":
			result = num1 - num2;
			break;
		case "multiply":
			result = num1 * num2;
			break;
		case "divide":
			result = num1 / num2;
			break;
		}

		response.setContentType("text/html");
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h1>Calculator Result</h1>");
		response.getWriter().println("<p>Result: " + result + "</p>");
		response.getWriter().println("<a href='calculator.html'>Back</a>");
		response.getWriter().println("</body></html>");
	}
}
