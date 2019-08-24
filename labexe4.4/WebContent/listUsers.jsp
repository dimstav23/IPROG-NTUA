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
String fileName = application.getRealPath("/users.txt");
System.out.println(fileName+" records");
String inStr = null;

int lineCount=0;
int wordCount=0;


try{
FileReader fileIn = new FileReader(fileName);
BufferedReader bfr = new BufferedReader(fileIn);

while((inStr=bfr.readLine())!=null){
%>
<%=inStr%> <br>
<%
	lineCount++;
	String [] words = inStr.split(" ");
	wordCount = wordCount+words.length;
}
bfr.close();
}catch(IOException ex){
	System.out.println(ex.toString());
}
System.out.println(lineCount+" records");
System.out.println(wordCount+" words");

%>

</body>
</html>