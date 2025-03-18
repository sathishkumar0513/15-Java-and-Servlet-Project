package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/TemperatureConverterServlet")
public class TemperatureConverterServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double celsius = Double.parseDouble(request.getParameter("celsius"));
		double fahrenheit = (celsius * 9 / 5) + 32;

		response.getWriter().println("Temperature in Fahrenheit: " + fahrenheit);
	}
}
