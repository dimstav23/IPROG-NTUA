<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	if(request.getParameter("username") == null
	   || request.getParameter("password") == null
	   || request.getParameter("username").trim().equals("")
	   || request.getParameter("password").trim().equals(""))
	{
	
%>
<br /> Please Register! 
<form method="get" action="register_in_file.jsp">
	<table>
		<tr>
			<td>Name:</td>
			<td> <input type="text" name="username" size=12 /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" size=12 /></td>
		</tr>
		<tr>
			<td colspan=2><input type=submit /></td>
		</tr>
	</table>
</form>
				
<%
	}
	else
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try 
			{

//     			System.out.println(application.getRealPath(""));
			
				FileWriter filewrt = new FileWriter(application.getRealPath("/users.txt"),true);
				BufferedWriter fileout = new BufferedWriter(filewrt);
				
				fileout.write(username+" "+password);
				fileout.newLine();
				fileout.close();
			}
		   
		catch (IOException e) {}
%>

<h1>Thank you for registering user <%=username %></h1>
<% 
			}
%>			
</body>
</html>