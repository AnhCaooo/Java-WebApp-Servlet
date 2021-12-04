
function main() {
	 // Send a request to the server
 		fetch("http://localhost:8080/WebAppExercises/students")
	
	// Convert the server's JSON response to a JavaScript object
 		.then(response => { // 1.
 			if (response.ok) { // 2.
 				return response.json(); // 3.
 			} else {
 				throw "HTTP status code is " + response.status; // 4.
			}
 		})
 		.then(studentList => printStudents(studentList)) // 5.
 		.catch(errorText => console.error("Fetch failed: " + errorText)); // 6.
}
	
function printStudents(studentList) { // 7.

	var divOutput = document.getElementById("divOutput");
    var outputText = "";
 	
	for (var student of studentList) {
 		//console.log(student.lastname);
		outputText += '<tr><td>' + student.id + '</td><td>' + student.firstname + '</td><td>' + student.lastname + '</td><td>' + student.streetaddress + '</td><td>' + student.postcode + '</td><td>' + student.postoffice + '</td></tr>'; 
 	}
	
	divOutput.innerHTML += outputText;
}
// Call the main function when the browser loads the HTML page
main();
