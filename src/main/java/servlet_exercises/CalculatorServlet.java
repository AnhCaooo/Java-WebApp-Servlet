package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Get a PrintWriter object for writing the text to be sent to the browser
		PrintWriter out = response.getWriter();

		// Get the request parameters
		String firstNumber = request.getParameter("x");
		String secondNumber = request.getParameter("y");

		String operator = request.getParameter("operation");

		// Print the output
		switch (operator) {
		case "add": 
			out.println(firstNumber + " + " + secondNumber + " = " + (Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber)));
			break; 
		case "multiply":
			out.println(firstNumber + " * " + secondNumber + " = " + ( Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber)));
			break; 
		case "subtract":
			out.println(firstNumber + " - " + secondNumber + " = " + (Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber)));
			break; 
		case "divide":
			out.println(firstNumber + " / " + secondNumber + " = " + (Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber)));
			break; 
		}
		

	}

}
