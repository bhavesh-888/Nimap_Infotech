<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NIMAP INFOTECH</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="StyleSheet.css">
</head>
<body>

	<div class="cubemain">
        <div class="cube">
            
            <div class="top"></div>
            <div>
                <span style="--i:0;"><h1>NIMAP INFOTECH</h1></span>
                <span style="--i:1;"><h1>NIMAP INFOTECH</h1></span>
                <span style="--i:2;"><h1>NIMAP INFOTECH</h1></span>
                <span style="--i:3;"><h1>NIMAP INFOTECH</h1></span>
            </div>
            
        </div>
    </div>
    <div class="container1">
        <div class="batch_table">
            <table>
                <%
                try{
                    ResultSet rs=(ResultSet)session.getAttribute("rs_allproduct");	 
                    ResultSetMetaData rsm=rs.getMetaData();
                    int i=rsm.getColumnCount();
                %>
                <caption>Products</caption>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Category Name</th>
                    <th>Category ID</th>
                </tr>
                
                <% 
                    while(rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("ProductId")%> </td>
                    <td><%= rs.getString("ProductName") %> </td>
                    <td><%= rs.getString("CategoryName") %> </td>
                    <td><%= rs.getInt("CategoryId")%> </td>
                </tr>
                <% }%>
                <% }
                catch(Exception e1){
                    e1.printStackTrace();
                }%>
                
            </table>
        </div>
    </div> 
    <div class="button1">

            <a href="Index.jsp"><input type="button" value="Category"></a>
		
			<input type="button" value="New Product" onclick="toggleMenu1();">
		
			<input type="button" value="Update Product" onclick="toggleMenu();">
			<input type="button" value="Delete Product" onclick="toggleMenu2();">
		
	</div>

    <div class="box2">
        <div class="cut">
            <i class="fa-solid fa-square-xmark"  onclick="toggleMenu();"></i>
        </div>
		<form action="./UpdateProductServletAll" method="post">
	        <h1>Update Product</h1>
	        <span>Product ID:</span> 
	        <input type="number" name="ProductId"><br>
	        <span>Product Name:</span> 
	        <input type="text" name="ProductName"><br>
	        <input type="submit" value="Update">
		</form>
    </div>

    <div class="box3">
        <div class="cut">
            <i class="fa-solid fa-square-xmark"  onclick="toggleMenu1();"></i>
        </div>
        <form action="./AddProductAll" method="post">
            <h1>Add New Product</h1>
            <span>Category ID:</span> 
            <input type="text" name="Category_ID"><br>
            <span>Product Name:</span> 
            <input type="text" name="Product_Name">
            <input type="submit" value="Add">
        </form>
    </div>
    <div class="box5">
        <div class="cut">
            <i class="fa-solid fa-square-xmark"  onclick="toggleMenu2();"></i>
        </div>
        <form action="./DeleteProductServletAll" method="post">
            <h1>Delete Product</h1>
            <span>Product ID:</span> 
            <input type="number" name="ProductId" required><br>
            <input type="submit" value="Delete">
        </form>
    </div>
    <div class="icon1">
        <%
			int pageNumber=(int)session.getAttribute("pageNumber");
		%>
		
		
		
        <form action="./AllProductServlet">
        	<%
			if(pageNumber != 1){
		%>
        	<input type="submit" value="Previous" name="Previous">
        
        <% } else { %>
        
            <input type="button">

        <%}%>
                    
		<%
			int rowSize=(int)session.getAttribute("rowSize");
		%>
		
        <input type="number" value="<%=pageNumber %>" name="pageNumber" readonly>
        
        <h2><%=pageNumber %></h2>
                 
       
 		<%
			if(rowSize > pageNumber){
		%>
        	<input type="submit" value="Next" name="Next">
        	<% } else { %>
        	   <input type="button" >

        	<%}%>
        </form>
        
    </div>
    
    <script>

        function toggleMenu(){
           const menutoggle = document.querySelector('.box2');
           menutoggle.classList.toggle('active');
       }
       function toggleMenu1(){
           const menutoggle1 = document.querySelector('.box3');
           menutoggle1.classList.toggle('active');
       }
       function toggleMenu2(){
           const menutoggle1 = document.querySelector('.box5');
           menutoggle1.classList.toggle('active');
       }

   </script>

</body>
</html>
