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
    <script type="text/javascript" src="js/myjs.js"></script> 
</head>
<body>

	<br /> Give us your username sir!
	<form method="post" >
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" id="username" name="username" size=12 /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>
	<%
   		String username = request.getParameter( "username" );
   		session.setAttribute( "userName", username );
	%>
	
	<%
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "");
		statement = connection.createStatement();
		rs = statement.executeQuery("SELECT * FROM selection WHERE username = \"" + username  + "\"");
		%>
		
		<%boolean val = rs.next();
		if (!val){
			String redirectURL = "register.jsp";
			if (username!=null)
		    response.sendRedirect(redirectURL);
		}
		else{%>
			<% String fullname = rs.getString("fullname");%>
				<%session.setAttribute( "fullName", fullname );%>
				<% String birth  = rs.getString("birth");%>
				<%session.setAttribute( "Birth", birth );%>
				<% String address = rs.getString("address"); %>
				<%session.setAttribute( "Address", address );%>	
		<%
				String redirectURL = "myAccount.jsp";
				if (username!=null)
	    		response.sendRedirect(redirectURL);
		}

		rs.close();%>
</body>
</html>