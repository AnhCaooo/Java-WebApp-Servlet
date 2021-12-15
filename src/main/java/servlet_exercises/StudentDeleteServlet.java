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


/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/deleteStudent")
public class StudentDeleteServlet extends HttpServlet {
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
		
		if (idText != null) {
			try {
				studentId = Integer.parseInt(idText);
			} catch (Exception ex) { }
		}
		
		int errorCode = studentDAO.deleteStudent(studentId); 
		
		Gson gson = new Gson(); 
		String json = gson.toJson(new Status(errorCode));
		
		out.print(json);
	}

}
