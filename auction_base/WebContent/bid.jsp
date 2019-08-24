<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%
	String connectionURL = "jdbc:mysql://localhost:3306/bidding";
	Connection connection = null;
	Statement statement = null;	
	ResultSet rs = null;
	float maxID = 100000;
	double bid = 0;
	
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
				<td>Place your bid here:</td>
				<td><input type="text" id="bid" name="bid" size=12 onblur="return doWork();" /></td>
				<td><span id="total"></span></td>
			</tr>
			<tr>
				<td colspan=2><input type=submit /></td>
			</tr>
		</table>
	</form>
	<%
   String bid2 = request.getParameter( "bid" );
   if(bid2!=null)
   bid = Float.parseFloat(bid2);
   session.setAttribute( "bid", bid );
   
	%>	
	<%
		if (bid2!=null){
			Object o_name = session.getAttribute("username");
			String name	 = o_name.toString();
			Object o_auction_id = session.getAttribute("auction_id");
			String auction_id_1	 = o_auction_id.toString();
			int auction_id = Integer.parseInt(auction_id_1);
			Object o_bid= session.getAttribute("bid");
			String bid3	 = o_bid.toString();
			float bid4 = Float.parseFloat(bid3);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "");
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT MAX(t.amount) as  max FROM bids t , auction a  WHERE a.active = 1 AND t.auction_id = a.auction_id");		
	%>
			<%if (rs.next()) {
				 maxID = rs.getFloat(1);
				} 
			rs.close();
			%>
			<% 
			if (bid>maxID){
				Object o_name1 = session.getAttribute("username");
				String name1	 = o_name1.toString();
				Object o_auction_id1 = session.getAttribute("auction_id");
				String auction_id_11	 = o_auction_id1.toString();
				int auction_id1 = Integer.parseInt(auction_id_11);
				Object o_bid2= session.getAttribute("bid");
				String bid32	 = o_bid2.toString();
				float bid42 = Float.parseFloat(bid32);
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(connectionURL, "root", "");
				statement = connection.createStatement();
				rs = statement.executeQuery("INSERT INTO bids (username,amount,auction_id) VALUES ( \"" + name1  + "\" ,\" + bid42 + \" , \" + auction_id1 + \") ;");		
			}
			else{
			%>
			<h1> there is an error with your bid</h1>
			<a href = "bid.jsp"> Try Again!</a>
			<%
			}
			
			
			%>
		
		
		
		
		
	<%} %>
</body>
</html>