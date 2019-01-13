<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PATIENT VIEW</title>
<link rel="stylesheet" href="index.css" type="text/css" />
</head>
<body>
<div id="wrapper">
    	<div id="header"><h1>Hospital Management System</h1></div>
        <div id="link" >
        <ul>
        	<li><a href="index.html">Home</a></li>
            <li><a href="patient.html">Patient</a></li>
            <li><a href="docter.html">Docter</a></li>
            <li><a href="appointment.html">Appointment</a></li>
            <li><a href="medicine.html">Medicine</a></li>
        </ul>
    	</div>
    </div>
    
    <div id="wrapper">
    	<h2 align="center">DOCTER DETAILS</h2>
    	<a href="login.jsp"><h3 align="right">LOGOUT</h3></a>
    </div>
    
     <%@ page language="java" %>
        <%@ page import="java.sql.*" %>
         <%@ page import="java.io.*" %>
     <div align="center" id="header" style="color:white" >    
     <form method="post">
     <table>
     <tr>
     	<th>ID</th>
     	<th> NAME</th>
     	<th>GENDER</th>
     	<th> AGE</th>
     	<th> PHONE</th>
     	<th>ADDRESS</th>
     	<th>SPECIAILISATION</th>
     	<th>QUALIFICATION</th>
     </tr>
     
     <%
     	try
     	{
     		String SQL="select * from docter";
     		Class.forName("com.mysql.jdbc.Driver");
     		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root","root");
     		Statement stmt=con.createStatement();
     		ResultSet rs=stmt.executeQuery(SQL);
     	
     		while(rs.next())
     		{
     	%>
     		<tr>
     			<td><%= rs.getInt(1) %>
     			<td><%= rs.getString(2) %></td>
     			<td><%= rs.getString(3) %></td>
     			<td><%= rs.getString(4) %></td>
     			<td><%= rs.getString(5) %></td>
     			<td><%= rs.getString(6) %></td>
     			<td><%= rs.getString(7) %></td>
     			<td><%= rs.getString(8) %></td>
     		</tr>
     		<%} %>		
     </table>
     <%
     	rs.close();
     	stmt.close();
     	con.close();
     	}
     catch(Exception e){
    	 e.printStackTrace();
     }
     %>
     </form>
</body>
</html>

<style>
   #link  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
    background-color: #111;
}

table {  
    color: #333; /* Lighten up font color */
    font-family: Helvetica, Arial, sans-serif; /* Nicer font */
    width: 900px; 
    border-collapse: 
    collapse; border-spacing: 0; 
}

td, th { border: 1px solid #CCC; height: 30px; } /* Make cells a bit taller */

th { 
    background: #F3F3F3; /* Light grey background */
    font-weight: bold; /* Make sure they're bold */
}

td {  
    background: #FAFAFA; /* Lighter grey background */
    text-align: center; /* Center our text */
}
</style>