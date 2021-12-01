package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import webapp.model.Student;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsontest")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get a PrintWriter object for writing the text to be sent to the browser
			PrintWriter out = response.getWriter();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			Student student1 =  new Student(1, "Anh", "Cao", "Kitarakuja", "00420", "Helsinki");
			Student student2 = new Student(2, "Filip", "Maxwell", "Râtpihantie", "00520", "Helsinki");
			
			List<Student> studentList = new ArrayList<Student>();
			studentList.add(student1);
			studentList.add(student2);
			
			Gson gson = new Gson();
			String json = gson.toJson(studentList); 
			
			out.print(json);
				
	}

}
