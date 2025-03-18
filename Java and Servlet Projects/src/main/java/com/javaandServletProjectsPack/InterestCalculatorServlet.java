package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/InterestCalculatorServlet")
public class InterestCalculatorServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        double principal = Double.parseDouble(request.getParameter("principal"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        int time = Integer.parseInt(request.getParameter("time"));

        double interest = (principal * rate * time) / 100;

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Simple Interest Calculator</h1>");
        response.getWriter().println("<p>Principal: " + principal + "</p>");
        response.getWriter().println("<p>Rate: " + rate + "%</p>");
        response.getWriter().println("<p>Time: " + time + " years</p>");
        response.getWriter().println("<p>Calculated Interest: " + interest + "</p>");
        response.getWriter().println("<a href='interest.html'>Back</a>");
        response.getWriter().println("</body></html>");
    }
}
