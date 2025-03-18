package com.javaandServletProjectsPack;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductCatalogServlet")
public class ProductCatalogServlet extends HttpServlet {
	// List to store products
	private List<String[]> products = new ArrayList<>();

	public void init() {
		// Initialize with some example products
		products.add(new String[] { "Laptop", "799.99", "A high-performance laptop with 16GB RAM." });
		products.add(new String[] { "Smartphone", "599.99", "A smartphone with a great camera and fast processor." });
		products.add(new String[] { "Headphones", "199.99", "Noise-canceling over-ear headphones." });
		products.add(new String[] { "Smartwatch", "129.99", "A fitness tracking smartwatch with heart rate monitor." });
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		// Display the product catalog
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h1>Product Catalog</h1>");

		// Display each product in the catalog
		response.getWriter().println("<table border='1'>");
		response.getWriter().println("<tr><th>Product Name</th><th>Price</th><th>Description</th></tr>");
		for (String[] product : products) {
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>" + product[0] + "</td>");
			response.getWriter().println("<td>$" + product[1] + "</td>");
			response.getWriter().println("<td>" + product[2] + "</td>");
			response.getWriter().println("</tr>");
		}
		response.getWriter().println("</table>");

		response.getWriter().println("</body></html>");
	}
}
