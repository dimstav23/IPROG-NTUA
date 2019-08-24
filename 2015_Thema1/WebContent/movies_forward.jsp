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
<title>Insert title here</title>
</head>
<body>
<%
		if (   Integer.parseInt(request.getParameter("rating")) > 10 || Integer.parseInt(request.getParameter("rating")) < 0 
				) {
	%>
	<br /> Please Enter a valid Rating
	<form method="post" action="movies_forward.jsp">
		<table>
			<tr>
				<td>Movie ID:</td>
				<td><input type="text" name="movie_id" id="movie_id" size=12 /></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><input type="text" name="rating"  id="rating" size=12 /></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>

	<%
			}else {
			
				String movie_id = request.getParameter("movie_id");
				String rating = request.getParameter("rating");
				Object o_name = session.getAttribute("theName");
				String name	 = o_name.toString();
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(connectionURL, "root","");
				statement = connection.createStatement();
				String sql = "INSERT INTO rates (movie_id,username,rate) VALUES( \"" + movie_id  + "\" ,\"" + name + "\" , \"" + rating + "\") ;";					
				int result = statement.executeUpdate(sql);
			
				//rs.close();
					%>
				<center><h3>Your Rating has been inserted into our DB</h3></center>
				<center>If you want to sumbit another rating press here:</center>
				<center>	<a href="movies.jsp">here</a> </center>
				<center>If you want to enter as another user press here:</center>
				<center>	<a href="home.jsp">here</a> </center>
			<%} %>

	
</body>
</html>