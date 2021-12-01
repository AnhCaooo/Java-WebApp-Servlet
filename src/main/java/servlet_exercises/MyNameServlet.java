package servlet_exercises;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyNameServlet
 */
@WebServlet("/myname")
public class MyNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// The web server invokes the doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get a PrintWriter object for writing the text to be sent to the browser
		PrintWriter out = response.getWriter();
		
		//  Write the text to the response (to be sent to the browser)
		out.println("My name is Anh");
	}

}
