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

<form method="get" action="findProperties.jsp">
		<table>
			<tr>
				<td>Property Name:</td>
				<td><input type="text" name="pname" size=12 /></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>
	 <%
		if (request.getParameter("pname") != null) 
		{
			Properties props = new Properties();
			
			try {
				// Change path Location
			props.load(new FileInputStream("C:/Users/dimst/Desktop/example.properties"));
				} catch (IOException e) {} 
	 %>
	 <%=request.getParameter("pname")+"="+props.getProperty(request.getParameter("pname"))%>
	 <%
		}
     %>
</body>
</html>