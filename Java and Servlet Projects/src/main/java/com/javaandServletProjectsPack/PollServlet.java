package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/PollServlet")
public class PollServlet extends HttpServlet {
    private Map<String, Integer> pollResults = new HashMap<>();

    public void init() {
        // Initialize the poll options with zero votes
        pollResults.put("Option A", 0);
        pollResults.put("Option B", 0);
        pollResults.put("Option C", 0);
        pollResults.put("Option D", 0);
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Get the selected option from the form
        String selectedOption = request.getParameter("option");

        // Update the vote count
        if (selectedOption != null && pollResults.containsKey(selectedOption)) {
            pollResults.put(selectedOption, pollResults.get(selectedOption) + 1);
        }

        // Display the poll form and results
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Online Poll System</h1>");

        // Poll form
        response.getWriter().println("<form action='PollServlet' method='post'>");
        response.getWriter().println("<p>Vote for your favorite option:</p>");
        for (String option : pollResults.keySet()) {
            response.getWriter().println("<input type='radio' name='option' value='" + option + "' required> " + option + "<br>");
        }
        response.getWriter().println("<button type='submit'>Vote</button>");
        response.getWriter().println("</form>");

        // Display poll results
        response.getWriter().println("<h2>Poll Results</h2>");
        for (Map.Entry<String, Integer> entry : pollResults.entrySet()) {
            response.getWriter().println("<p>" + entry.getKey() + ": " + entry.getValue() + " votes</p>");
        }

        response.getWriter().println("</body></html>");
    }
}
