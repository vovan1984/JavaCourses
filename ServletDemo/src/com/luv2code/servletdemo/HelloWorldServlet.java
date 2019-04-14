package com.luv2code.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: set the content type
	    response.setContentType("text/html");
	    
	    // Step 2: get the PrintWrite
	    PrintWriter out = response.getWriter();
	    
	    // Step 3: generate HTML content
	    out.println("<html><body>");
	    
	    out.println("<h2>Hello World!</h2>");
	    out.println("<hr>");
	    
	    LocalDateTime curDateTime = LocalDateTime.now();
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss");
	    out.println("Time on server is: " + curDateTime.format(dtf));
	    out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
