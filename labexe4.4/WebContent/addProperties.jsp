<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if
		(
				request.getParameter("pname") != null 
			&& 
				request.getParameter("pvalue") != null
			&& 
				!request.getParameter("pname").trim().equals("") 
			&&
				!request.getParameter("pvalue").trim().equals("")
		) 
		{
			
			
			FileInputStream in = new FileInputStream(application.getRealPath("/WEB-INF/example.properties"));			
			Properties props = new Properties();
			props.load(in);
			
			// Change path Location
			FileOutputStream outputStream = new FileOutputStream("C:/Users/dimst/Desktop/example.properties");
			props.setProperty(request.getParameter("pname"), request.getParameter("pvalue"));
			props.store(outputStream,"This is a comment");
			outputStream.close();
		}

	%>



	<form method="get" action="addProperties.jsp">
		<table>
			<tr>
				<td>Property Name:</td>
				<td><input type="text" name="pname" size=12 /></td>
			</tr>
			<tr>
				<td>Property Value:</td>
				<td><input type="text" name="pvalue" size=12 /></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>
</body>
</html>