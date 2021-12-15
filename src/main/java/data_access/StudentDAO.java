package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webapp.model.Student;

public class StudentDAO {
	/*
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student(40, "Baker","Ginger", "Rumputie 10", "54120", "PULP"));
		studentList.add(new Student(30, "Bruce","Jack", "Asematori 3", "00520", "HELSINKI"));
		studentList.add(new Student(20, "Clapp","Eric", "Luuttutie", "54120", "PULP"));
		studentList.add(new Student(10, "Doe","Diana", "Kuusikuja 6", "01200", "VANTAA"));

		return studentList;
	}	
	*/
	public StudentDAO() {
	try {
		Class.forName(ConnectionParameters.jdbcDriver);
	} catch (ClassNotFoundException cnfe) {
		System.out.println(cnfe.getMessage());
	}
}

/**
 * Open a new database connection
 * 
 * @throws SQLException
 */
private Connection openConnection() throws SQLException {
	return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
			ConnectionParameters.password);
}

/**
 * Retrieve all students from the database
 * 
 * @return List<Student>
 * @throws SQLException
 */
public List<Student> getAllStudents() {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<Student> studentList = new ArrayList<Student>();

	try {
		connection = openConnection();

		String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY lastname";

		preparedStatement = connection.prepareStatement(sqlText);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstname = resultSet.getString("firstname");
			String lastname = resultSet.getString("lastname");
			String streetaddress = resultSet.getString("streetaddress");
			String postcode = resultSet.getString("postcode");
			String postoffice = resultSet.getString("postoffice");

			studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
		}

	} catch (SQLException sqle) {
		System.out.println("\n[ERROR] StudentDAO: getStudents() failed. " + sqle.getMessage() + "\n");
		studentList = null;

	} finally {
		DBUtils.closeQuietly(resultSet, preparedStatement, connection);
	}

	return studentList;
}

/**
 * Insert a student into the database
 * 
 * @return 0 = Ok | 1 = Duplicate id | -1 = Other error
 * @throws SQLException
 */

// Insert a new student row (DAO version) 
public int insertStudent(Student student) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	int errorCode = -1;

	try {
		connection = openConnection();

		String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?,?,?,?,?,?)";
		
		preparedStatement = connection.prepareStatement(sqlText);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getFirstname());
		preparedStatement.setString(3, student.getLastname());
		preparedStatement.setString(4, student.getStreetaddress());
		preparedStatement.setString(5, student.getPostcode());
		preparedStatement.setString(6, student.getPostoffice());
		System.out.println(student);

		preparedStatement.executeUpdate();
		errorCode = 0;

	} catch (SQLException sqle) {
		if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
			errorCode = 1;
		} else {
			System.out.println("\n[ERROR] StudentDAO: insertStudent() failed. " + sqle.getMessage() + "\n");
			errorCode = -1;
		}

	} finally {
		DBUtils.closeQuietly(preparedStatement, connection);
	}

	return errorCode;
}

/**
 * Delete a student from the database
 * 
 * @return 0 = Ok | 1 = Not found id | -1 = Other error
 * @throws SQLException
 */

// Insert a new student row (DAO version) 
public int deleteStudent(int studentId) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	int errorCode = -1;

	try {
		connection = openConnection();

		String sqlText = "DELETE FROM Student WHERE id = ?";
		
		preparedStatement = connection.prepareStatement(sqlText);
		
		preparedStatement.setInt(1, studentId);

		int result = preparedStatement.executeUpdate();
		if(result == 1) {
			errorCode = 0;
		} else if (result != 1 ) {
			errorCode = 1; 
		}
		

	} catch (SQLException sqle) {
		if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
			errorCode = -1;
		} else {
			System.out.println("\n[ERROR] StudentDAO: insertStudent() failed. " + sqle.getMessage() + "\n");
			errorCode = 1;
		}

	} finally {
		DBUtils.closeQuietly(preparedStatement, connection);
	}

	return errorCode;
}
}
