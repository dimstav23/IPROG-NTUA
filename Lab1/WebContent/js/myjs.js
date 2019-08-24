// Get the HTTP Object
var httpObject = null;
function getHTTPObject() {
	if (window.ActiveXObject)
		return new ActiveXObject("Microsoft.XMLHTTP");
	else if (window.XMLHttpRequest)
		return new XMLHttpRequest();
	else {
		alert("Your browser does not support AJAX.");
		return null;
	}
}

function doWork() {	
	httpObject = getHTTPObject();
	if (httpObject != null) {
		httpObject.open("GET", "\ValidationServlet?username="
				+ document.getElementById('username').value, true);
		httpObject.send(null);
		httpObject.onreadystatechange = setOutput;
	}
}

function setOutput() {
	if (httpObject.readyState == 4 && httpObject.status==200) {
		//alert("total = " + httpObject.responseText);
		document.getElementById('total').innerHTML = httpObject.responseText;
	}
}


