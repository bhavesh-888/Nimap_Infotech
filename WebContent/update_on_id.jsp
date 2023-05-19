<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update_on_id</title>
</head>
<body>
		<%
		int Category_ID=Integer.parseInt(request.getParameter("Category_ID")); 
		session.setAttribute("Category_ID", Category_ID);	
		response.sendRedirect("./sepcificproductservlet");
		
		%>
</body>
</html>