<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/imdb";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
</head>
<body>
	<br /> Give us the id of the movie and your rating Mr/Mrs <%= session.getAttribute( "theName" ) %> 
	<form method="post" action="movies_forward.jsp">
		<table>
			<tr>
				<td>Id of the movie:</td>
				<td><input type="text" id="movie_id" name="movie_id" size=12  /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td>Rating of the movie:</td>
				<td><input type="text" id="rating" name="rating" size=12 /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>
	

</body>
</html>