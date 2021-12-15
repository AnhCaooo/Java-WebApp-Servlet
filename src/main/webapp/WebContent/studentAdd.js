function main(){
	var url = "http://localhost:8080/WebAppExercises/addStudent";
	var parameterData = 
		"id=1&firstname=Anh&lastname=Cao&streetaddress=kitarakuja&postcode=00420&postoffice=Helsinki";
	
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
 		.catch(errorText =>alert("postDataToServer failed: " + errorText));
		
}

function processResponseStatus(status) {

		if(status.errorCode == 0) {
			console.log("Student data added!");
		} else if(status.errorCode == 1) {
			console.log("Cannot add the student. The id is already in use!");
		} else if(status.errorCode == -1) {
			console.log("The database is temporarily unavailable. Please try again later.");
		}
}

main();