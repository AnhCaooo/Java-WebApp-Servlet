function main(){
	var url = "http://localhost:8080/WebAppExercises/deleteStudent";
	var parameterData = 
		"id=1i";
	
	var requestOptions = {
		method: "POST", 
		headers: {"Content-Type" : "text/x-www-form-urlencoded"},
		body: parameterData
	}; 
	
	fetch(url, requestOptions)
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
 				throw "HTTP status code is " + response.status;		
			}
		})
 		.then(status => processResponseStatus(status))
 		.catch(errorText => alert("postDataToServer failed: " + errorText));
		
}

function processResponseStatus(status) {

		if(status.errorCode == 0) {
			console.log("Student data deleted!");
		} else if(status.errorCode == 1) {
			console.log("Student data not deleted. Unknown student id!");
		} else if(status.errorCode == -1) {
			console.log("The database is temporarily unavailable. Please try again later.");
		}
}

main();