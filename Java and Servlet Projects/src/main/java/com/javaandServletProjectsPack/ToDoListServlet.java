package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/ToDoListServlet")
public class ToDoListServlet extends HttpServlet {
    private static final ArrayList<String> tasks = new ArrayList<>();

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>To-Do List</h1>");
        response.getWriter().println("<form action='ToDoListServlet' method='post'>");
        response.getWriter().println("Task: <input type='text' name='task'><br>");
        response.getWriter().println("<button type='submit'>Add Task</button>");
        response.getWriter().println("</form>");
        
        response.getWriter().println("<h2>Tasks:</h2><ul>");
        for (String task : tasks) {
            response.getWriter().println("<li>" + task + "</li>");
        }
        response.getWriter().println("</ul></body></html>");
    }

    public void service1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");
        if (task != null && !task.trim().isEmpty()) {
            tasks.add(task);
        }
        response.sendRedirect("ToDoListServlet");
    }
}
