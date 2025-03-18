package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@WebServlet("/QuoteServlet")
public class QuoteServlet extends HttpServlet {
    private List<String> quotes = new ArrayList<>();

    public void init() {
        quotes.add("The only way to do great work is to love what you do. - Steve Jobs");
        quotes.add("Success is not the key to happiness. Happiness is the key to success. - Albert Schweitzer");
        quotes.add("The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt");
        quotes.add("It does not matter how slowly you go as long as you do not stop. - Confucius");
        quotes.add("Don't watch the clock; do what it does. Keep going. - Sam Levenson");
        quotes.add("Believe you can and you're halfway there. - Theodore Roosevelt");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Random random = new Random();
        int index = random.nextInt(quotes.size());

        String randomQuote = quotes.get(index);

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Random Quote Generator</h1>");
        response.getWriter().println("<p><strong>" + randomQuote + "</strong></p>");
        response.getWriter().println("<hr>");
        response.getWriter().println("<a href='QuoteServlet'>Get Another Quote</a>");
        response.getWriter().println("</body></html>");
    }
}
