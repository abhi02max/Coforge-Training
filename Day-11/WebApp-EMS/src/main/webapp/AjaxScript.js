
function getEmployeeDetails() {
	var eid = document.getElementById("eid").value;
		
		var req = new XMLHttpRequest(); //object creation for ajax functionality
		req.open("GET","http://localhost:8022/WebApp-EMS/EmployeeController?eid="+eid,true);
		//opening connection with server with get method
		// ?pwd + password is the query string -- sending data to server
		// argument true is -- communicate asynchronously
		req.onreadystatechange = function() {
			//alert(req.responseText);
			if(req.readyState == 4 && req.status == 200){
				// 200 is sucess state
				var result = req.responseText;
				var arr = result.split(" ");
				document.getElementById("ename").value = arr[0];
				document.getElementById("esalary").value = arr[1];
				document.getElementById("dno").value = arr[2];
			}
		};
		req.send();
}