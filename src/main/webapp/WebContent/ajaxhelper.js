 function getDataFromServer(url, printStudents){
	fetch(url, printStudents)	
		.then(response => { 
			 if (response.ok) { 
				return response.json(); 
			 } else {
			 	throw "HTTP status code is " + response.status;
			 }
		}) 
		.then(studentList => printStudents(studentList))
		.catch(errorText => alert("getDataFromServer failed: " + errorText));
}

