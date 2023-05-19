<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="StyleSheet.css">
</head>
<body>
	<table border="2">
		<%
		try{
			ResultSet rs=(ResultSet)session.getAttribute("rs_category");	 
			ResultSetMetaData rsm=rs.getMetaData();
			int i=rsm.getColumnCount();
		%>
		
		<tr>
		<%for(int j=1;j<=i;j++){ %>
		
		<td style="color:black"><center><b><%= rsm.getColumnName(j) %></center></b></td>
		<% }	%>
		</tr>
		<% while(rs.next()) {
			int CategoryId = rs.getInt("CategoryId");
		
		%>
		
		<tr>
		
		<td><a href="update_product_on_id.jsp?value=<%=rs.getInt("CategoryId")%>"><%= rs.getInt("CategoryId")%> </td>
		<td><%= rs.getString("CategoryName") %> </td>
		</tr>
		</a>
		<% }%>
		</table>
		<form action="./view_all_product">
		<input type="submit" value="View All Product">
		
		</form>
		<% }
		catch(Exception e1){
			e1.printStackTrace();
		}%>
	
	
</body>
</html>