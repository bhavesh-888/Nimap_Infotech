
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SQL_Database_Entry")
public class SQL_Database_Entry extends HttpServlet {
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");		
				Statement stm=connection.createStatement();
				stm.execute("create database Nimap_Project");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_Project", "root", "root");		
				Statement statement=con.createStatement();
				statement.execute("Create table Category(CategoryId int Primary Key Auto_Increment,CategoryName varchar(255))");
				statement.execute("Create table Product(ProductId int Primary Key Auto_Increment,ProductName varchar(255),CategoryName varchar(255),CategoryId int,FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId))");
				
				resp.sendRedirect("HomePage.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
			
			
		
		
		}
	
}

