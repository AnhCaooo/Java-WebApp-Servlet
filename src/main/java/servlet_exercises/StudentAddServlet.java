package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data_access.StudentDAO;
import webapp.model.Status;
import webapp.model.Student;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/addStudent")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter(); 
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		StudentDAO studentDAO = new StudentDAO();
		
		int studentId = -1;
		
		String idText = request.getParameter("id");
		String firstNameText = request.getParameter("firstname");
		String lastNameText = request.getParameter("lastname");
		String streetaddressText = request.getParameter("streetaddress");
		
		String postcodeText = request.getParameter("postcode");
		String postofficeText = request.getParameter("postoffice");

		
		if (idText != null) {
			try {
				studentId = Integer.parseInt(idText);
			} catch (Exception ex) { }
		}
		
		Student newStudent = new Student(studentId, firstNameText, lastNameText, streetaddressText, postcodeText, postofficeText);
		
		int errorCode = studentDAO.insertStudent(newStudent);
		
		Gson gson = new Gson(); 
		String json = gson.toJson(new Status(errorCode));
		
		out.print(json);
	}

}
