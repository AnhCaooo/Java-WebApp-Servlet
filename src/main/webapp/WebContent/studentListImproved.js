
function main() {
	// Call the getDataFromServer function
	getDataFromServer("http://localhost:8080/WebAppExercises/students", printStudents);

}
	
function printStudents(studentList) { // 7.

	var divOutput = document.getElementById("divOutput");
    var outputText = "";
 	
	for (var student of studentList){

		outputText += '<tr><td>' + student.id + '</td><td>' + student.firstname + '</td><td>' + student.lastname + '</td><td>' + student.streetaddress + '</td><td>' + student.postcode + '</td><td>' + student.postoffice + '</td></tr>'; 
 	}
	
	divOutput.innerHTML += outputText;
}
// Call the main function when the browser loads the HTML page
main();
