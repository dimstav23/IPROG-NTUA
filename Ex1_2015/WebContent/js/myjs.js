function checkit() {

	/*
	 * var strval = document.form1.name.value; // input text value if(!strval) {
	 * alert("Input name is null "); return( false ); }
	 * 
	 * return true;
	 */
	alert("Checking");
	return false;

}

function validate_form ()
{
    var valid = true;
    var given_name = document.form1.name.value;
    //var given_name = document.getElementById("given_name").value;
    //if (!given_name)
    if(given_name == "")	
    {
        alert ( "Please fill in the 'Your Name' box." );
        valid = false;
    }

    return valid;
}

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
	//alert("Preparing doWork() ");
	if (httpObject != null) {
		httpObject.open("GET", "check_username.jsp?username="
				+ document.getElementById('username').value, true);
		httpObject.send(null);
		httpObject.onreadystatechange = setOutput;
	}
}

function setOutput() {
	if (httpObject.readyState == 4 && httpObject.status==200) {
		//alert("total = " + httpObject.responseText);
		var responseFromPage = httpObject.responseText;
		if(responseFromPage.indexOf("available") != -1) {
			document.getElementById('total').style.color = "green";	 	    
	    }
		else {
			document.getElementById('total').style.color = "red";		
		}
		document.getElementById('total').innerHTML = httpObject.responseText;
	}
}


