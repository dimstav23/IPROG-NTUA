<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/account";
	Connection connection = null;
	Statement statement = null;	
	ResultSet rs = null;
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script type="text/javascript" src="js/myjs.js"></script> 
</head>
<body>
<br /> Give us your details Mr/Mrs <%= session.getAttribute( "userName" ) %>
 <% Object o_name = session.getAttribute("userName");
	String username1	 = o_name.toString(); %>
	<form method="post" action="selection_insert.jsp">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" id="username2" name="username2" size=12 value="<%=username1%>" /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td>Fullname:</td>
				<td><input type="text" id="fullname2" name="fullname2" size=12 /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><input type="text" id="birth2" name="birth2" size=12 /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" id="address2" name="address2" size=12 /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>

</body>
</html>