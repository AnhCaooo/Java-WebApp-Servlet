package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data_access.StudentDAO;
import webapp.model.Student;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		StudentDAO studentDAO = new StudentDAO();
		List<Student> studentList = studentDAO.getAllStudents(); 
		
		Gson gson = new Gson();
		String json = gson.toJson(studentList); 
		
		out.println(json);
		
	}

}
