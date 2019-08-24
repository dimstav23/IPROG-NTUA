<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%
   String name = request.getParameter( "username" );
   session.setAttribute( "theName", name );
%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/imdb";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
%>


<html>
<body>
<center><h1>These are the movies with their IDs and launch years:</h1></center>
<center>
	<%
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "");
		statement = connection.createStatement();
		rs = statement.executeQuery("SELECT * FROM movies");
		%>
		</center>
	
	<center>
	<br/>
	<br/>		
	<table border="5">
		<tr>
			<td>ID</td>
			<td>Title</td>
			<td>Year</td>
		</tr>
		<%
		while (rs.next()) {
			%>

		<tr>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("title")%></td>
			<td><%=rs.getString("year") %></td>
		</tr>
		<%
		}

		rs.close();
	%>
	</table>
	</center>
<center><h1>These are the movies with their rates from users:</h1></center>
<center>
	<%
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "");
		statement = connection.createStatement();
		rs = statement.executeQuery("SELECT * FROM rates");
		%>
		</center>
	
	<center>
	<br/>
	<br/>		
	<table border="5">
		<tr>
			<td>ID</td>
			<td>Movie ID</td>
			<td>Username</td>
			<td>Rate</td>
		</tr>
		<%
		while (rs.next()) {
			%>

		<tr>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("movie_id")%></td>
			<td><%=rs.getString("username") %></td>
			<td><%=rs.getString("rate") %>
		</tr>
		<%
		}

		rs.close();
	%>
	</table>
	</center>	

<a href="movies.jsp">Click here if you want to rate a movie</a>

</body>
</html>