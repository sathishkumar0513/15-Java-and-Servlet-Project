package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        String city = request.getParameter("city");
        String weather;

        switch (city.toLowerCase()) {
            case "new york":
                weather = "Sunny, 25°C";
                break;
            case "london":
                weather = "Cloudy, 15°C";
                break;
            case "mumbai":
                weather = "Rainy, 30°C";
                break;
            case "tokyo":
                weather = "Clear, 20°C";
                break;
            default:
                weather = "Weather data not available for this city.";
        }

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Weather App</h1>");
        response.getWriter().println("<p>City: " + city + "</p>");
        response.getWriter().println("<p>Weather: " + weather + "</p>");
        response.getWriter().println("<a href='weather.html'>Check Another City</a>");
        response.getWriter().println("</body></html>");
    }
}

