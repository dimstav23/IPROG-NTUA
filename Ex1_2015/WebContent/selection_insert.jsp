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
<title>Insert title here</title>
</head>
<body>
<%
				String username2 = request.getParameter("username2");
				String fullname2 = request.getParameter("fullname2");
				String birth2 = request.getParameter("birth2");
				String address2 = request.getParameter("address2");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(connectionURL, "root","");
				statement = connection.createStatement();
				String sql = "INSERT INTO selection (username,fullname,birth,address) VALUES( \"" + username2  + "\" ,\"" + fullname2 + "\" , \"" + birth2 + "\", \"" + address2 + "\") ;";					
				int result = statement.executeUpdate(sql);
%>
<h2>You have been successfully registered!</h2>
<a href = "login.jsp">Go to the login page</a>
<a href = "update.jsp">Go to the update page</a>
</body>
</html>