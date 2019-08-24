<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/bidding";
	Connection connection = null;
	Statement statement = null;	
	ResultSet rs = null;
%>
<html>
 <script type="text/javascript" src="js/myjs.js"></script> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br /> Give us your name sir!
	<form method="post" >
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" id="username" name="username" size=12 onblur="return doWork();" /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>
	<%
   String name = request.getParameter( "username" );
   session.setAttribute( "username", name );
	%>	
	<%
		if (name!=null){
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "");
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM auction WHERE active = 1");
			%>
			<center>
				
		<table border="5">
			<tr>
				<td>Description</td>
				<td>AuctionID</td>
			</tr>
			<%
			while (rs.next()) {
				%>
	
			<tr>
				<td><%=rs.getString("description")%></td>
				<td><%=rs.getString("auction_id")%></td>
				<%String auction_id = rs.getString("auction_id"); %>
				 <%session.setAttribute( "auction_id", auction_id ); %>
			</tr>
			<%
			}
	
			rs.close();
		%>
		</table>
		</center>
		
		
		
		<%
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "");
		statement = connection.createStatement();
		rs = statement.executeQuery("SELECT t.* FROM bids t , auction a  WHERE a.active = 1 AND t.auction_id = a.auction_id");		
		%>
		<center>
				
		<table border="5">
			<tr>
				<td>Username</td>
				<td>Amount</td>
			</tr>
			<%
			while (rs.next()) {
				%>
	
			<tr>
				<td><%=rs.getString("username")%></td>
				<td><%=rs.getString("amount")%></td>
			</tr>
			<%
			}
	
			rs.close();
		%>
		</table>
		</center>
		<%
		
		}	
	
	%>

</body>
</html>