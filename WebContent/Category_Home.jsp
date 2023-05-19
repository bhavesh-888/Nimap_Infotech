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
    <div class="container">
        <div class="batch_table">
            <table>
                <%
                try{
                    ResultSet rs=(ResultSet)session.getAttribute("rs_category");	 
                    ResultSetMetaData rsm=rs.getMetaData();
                    int i=rsm.getColumnCount();
                %>
                <caption>Category</caption>
                <tr>
                    <th>Category ID</th>
                    <th>Category Name</th>
                </tr>
                <% 
                	while(rs.next()) {
                    int CategoryId = rs.getInt("CategoryId");
                %>
                
                <tr data-href="update_on_id.jsp?Category_ID=<%=rs.getInt("CategoryId")%>">
                    <td><%= rs.getInt("CategoryId")%></td>
                    <td><%= rs.getString("CategoryName") %></td>
                </tr>
                <% }%>
                <%	}
					catch(Exception e1){
						e1.printStackTrace();
					}
				%>
				
            </table>
        </div>
    </div> 
    
    <div class="icon">
        <%
			int pageNumber=(int)session.getAttribute("pageNumber");
		%>
		
		
		
        <form action="./categoryservlet">
        	<%
			if(pageNumber != 1){
		%>
        	<input type="submit" value="Previous" name="Previous">
        
        <% } else { %>
        
            <input type="button" value="Previous" name="Previous">

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
        	   <input type="button" value="Previous" name="Previous">

        	<%}%>
        </form>
        
    </div>

    <div class="button">
		
        <input type="button" value="New Category" onclick="toggleMenu1();">
        <input type="button" value="Update Category" onclick="toggleMenu();">
        <input type="button" value="Delete Category" onclick="toggleMenu2();">
        
    
    </div>

    <div class="box">
        <div class="cut">
            <i class="fa-solid fa-square-xmark"  onclick="toggleMenu();"></i>
        </div>
        <form action="./UpdateCategoryServlet" method="post">
            <h1>Update Category</h1>
            <span>Category ID:</span> 
            <input type="number" name="Categoryno" required><br>
            <span>Category Name:</span> 
            <input type="text" name="CategoryName" required><br>
            <input type="submit" value="Update">
        </form>
    </div>

    <div class="box1">
        <div class="cut">
            <i class="fa-solid fa-square-xmark"  onclick="toggleMenu1();"></i>
        </div>
        <form action="./AddCategoryServlet" method="post">
            <h1>Add New Category</h1>
            <span>Category Name:</span> 
            <input type="text" name="CategoryName" required><br>
            <input type="submit" value="Add">
        </form>
    </div>
    <div class="box4">
        <div class="cut">
            <i class="fa-solid fa-square-xmark"  onclick="toggleMenu2();"></i>
        </div>
        <form action="./DeleteServlet" method="post">
            <h1>Delete Category</h1>
            <span>Category ID:</span> 
            <input type="number" name="Category_ID" required><br>
            <input type="submit" value="Delete">
        </form>
    </div>
    <div class="del">
        <a href="./AllProductServlet"><input type="button" value="All Products"></a>
    </div> 

    <script>

        function toggleMenu(){
           const menutoggle = document.querySelector('.box');
           menutoggle.classList.toggle('active');
       }
       function toggleMenu1(){
           const menutoggle1 = document.querySelector('.box1');
           menutoggle1.classList.toggle('active');
       }
       function toggleMenu2(){
           const menutoggle1 = document.querySelector('.box4');
           menutoggle1.classList.toggle('active');
       }

       document.addEventListener("DOMContentLoaded", () =>{
            const rows = document.querySelectorAll("tr[data-href]");
            
            rows.forEach(row => {
                row.addEventListener("click", () => {
                    window.location.href = row.dataset.href;
                });
            });
        });

   </script>

</body>
</html>