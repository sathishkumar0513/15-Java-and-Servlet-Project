package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/SessionTrackingServlet")
public class SessionTrackingServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 0;
        }

        visitCount++;
        session.setAttribute("visitCount", visitCount);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Session Tracking Example</h1>");
        response.getWriter().println("<p>You have visited this page " + visitCount + " times.</p>");
        response.getWriter().println("</body></html>");
    }
}
