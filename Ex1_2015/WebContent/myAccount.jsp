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
<title>myAccount</title>
<script type="text/javascript" src="js/myjs.js"></script> 
</head>
<body>
<%= session.getAttribute( "userName" ) %>
<%= session.getAttribute( "fullName" ) %>
<%= session.getAttribute( "Birth" ) %>
<%= session.getAttribute( "Address" ) %>

</body>
</html>