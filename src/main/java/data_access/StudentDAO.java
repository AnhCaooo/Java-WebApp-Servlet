package data_access;

import java.util.ArrayList;
import java.util.List;

import webapp.model.Student;

public class StudentDAO {
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student(40, "Baker","Ginger", "Rumputie 10", "54120", "PULP"));
		studentList.add(new Student(30, "Bruce","Jack", "Asematori 3", "00520", "HELSINKI"));
		studentList.add(new Student(20, "Clapp","Eric", "Luuttutie", "54120", "PULP"));
		studentList.add(new Student(10, "Doe","Diana", "Kuusikuja 6", "01200", "VANTAA"));

		return studentList;
	}	
	
	public String getStudentById(int studentId){
		String result = "";
		List<Student> studentList = new  ArrayList<Student>();
		
		studentList.add(new Student(40, "Baker","Ginger", "Rumputie 10", "54120", "PULP"));
		studentList.add(new Student(30, "Bruce","Jack", "Asematori 3", "00520", "HELSINKI"));
		studentList.add(new Student(20, "Clapp","Eric", "Luuttutie", "54120", "PULP"));
		studentList.add(new Student(10, "Doe","Diana", "Kuusikuja 6", "01200", "VANTAA"));
		
		for(int i =0; i< studentList.size();i++) {
			if(studentList.get(i).getId() == studentId) {
				result = studentId + " " + studentList.get(i).getFirstname() + " " + studentList.get(i).getLastname();
		}
	}
		return result;

	}
}
