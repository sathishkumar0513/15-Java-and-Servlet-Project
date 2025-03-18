package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.getWriter().println("Registration Successful! Welcome, " + name);
    }
}