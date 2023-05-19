import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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


@WebServlet("/categoryservlet")
public class Category extends HttpServlet {
			
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session=req.getSession();
			String Nexts = req.getParameter("Next");
			String Backs = req.getParameter("Previous");
			String Back = Backs == null ?"NO" : Backs;
			
			String pageNo = req.getParameter("pageNumber");
			String Next = Nexts == null ? "No" : Nexts;
			
			int pageNumber = pageNo == null ? 0 : Integer.parseInt(pageNo);
			int limit;
			
			if(pageNumber == 0) {
				
				
				limit = 0;
				
				pageNumber++;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
					PreparedStatement pstm=connection.prepareStatement("select * from Category limit ?, 10");
					pstm.setInt(1, limit);
					ResultSet rs=pstm.executeQuery();
					session.setAttribute("rs_category", rs);
					session.setAttribute("pageNumber", pageNumber);
					PreparedStatement pstm1=connection.prepareStatement("select * from Category");
					ResultSet rs1 = pstm1.executeQuery();
					int size =0;
					if (rs1 != null) 
					{
					  rs1.last();    
					  size = rs1.getRow(); 
					}
					
					double z = (double) size / 10;
					int rowSize =(int) Math.ceil(z);
					session.setAttribute("rowSize", rowSize);
					
					resp.sendRedirect("Category_Home.jsp");
					
					
				} catch (ClassNotFoundException e) {
					resp.sendRedirect("Index.jsp");
					e.printStackTrace();
				} catch (SQLException e) {
					resp.sendRedirect("Index.jsp");
					e.printStackTrace();
				}
			
			
			
			}
			
			else if(Next.equals("Next")) {

				limit = pageNumber  * 10;
				pageNumber++;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
					PreparedStatement pstm=connection.prepareStatement("select * from Category limit ?, 10");
					pstm.setInt(1, limit);
					ResultSet rs=pstm.executeQuery();
					session.setAttribute("rs_category", rs);
					session.setAttribute("pageNumber", pageNumber);
					PreparedStatement pstm1=connection.prepareStatement("select * from Category");
					ResultSet rs1 = pstm1.executeQuery();
					int size =0;
					if (rs1 != null) 
					{
					  rs1.last();    
					  size = rs1.getRow(); 
					}
					
					double z = (double) size / 10;
					int rowSize =(int) Math.ceil(z);
					session.setAttribute("rowSize", rowSize);
					
					resp.sendRedirect("Category_Home.jsp");
					
					
				} catch (ClassNotFoundException e) {
					resp.sendRedirect("Index.jsp");
					e.printStackTrace();
				} catch (SQLException e) {
					resp.sendRedirect("Index.jsp");
					e.printStackTrace();
				}
				
			} else if (Back.equals("Previous")) {

				pageNumber = pageNumber - 2;
				
				if(pageNumber == 0) {
					limit = 0;
					pageNumber = 1;
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
						PreparedStatement pstm=connection.prepareStatement("select * from Category limit ?, 10");
						pstm.setInt(1, limit);
						ResultSet rs=pstm.executeQuery();
						session.setAttribute("rs_category", rs);
						session.setAttribute("pageNumber", pageNumber);
						PreparedStatement pstm1=connection.prepareStatement("select * from Category");
						ResultSet rs1 = pstm1.executeQuery();
						int size =0;
						if (rs1 != null) 
						{
						  rs1.last();    
						  size = rs1.getRow(); 
						}
						
						double z = (double) size / 10;
						int rowSize =(int) Math.ceil(z);
						session.setAttribute("rowSize", rowSize);
						
						resp.sendRedirect("Category_Home.jsp");
						
						
					} catch (ClassNotFoundException e) {
						resp.sendRedirect("Index.jsp");
						e.printStackTrace();
					} catch (SQLException e) {
						resp.sendRedirect("Index.jsp");
						e.printStackTrace();
					}
					
				}else {

					
					limit = pageNumber *10;
					pageNumber++;
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
						PreparedStatement pstm=connection.prepareStatement("select * from Category limit ?, 10");
						pstm.setInt(1, limit);
						ResultSet rs=pstm.executeQuery();
						session.setAttribute("rs_category", rs);
						session.setAttribute("pageNumber", pageNumber);
						PreparedStatement pstm1=connection.prepareStatement("select * from Category");
						ResultSet rs1 = pstm1.executeQuery();
						int size =0;
						if (rs1 != null) 
						{
						  rs1.last();    
						  size = rs1.getRow(); 
						}
						
						double z = (double) size / 10;
						int rowSize =(int) Math.ceil(z);
						session.setAttribute("rowSize", rowSize);
						
						resp.sendRedirect("Category_Home.jsp");
						
						
					} catch (ClassNotFoundException e) {
						resp.sendRedirect("Index.jsp");
						e.printStackTrace();
					} catch (SQLException e) {
						resp.sendRedirect("Index.jsp");
						e.printStackTrace();
					}
				}
				
				
				
				
				
			}else {
				limit = 0;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
					PreparedStatement pstm=connection.prepareStatement("select * from Category limit ?, 10");
					pstm.setInt(1, limit);
					ResultSet rs=pstm.executeQuery();
					session.setAttribute("rs_category", rs);
					session.setAttribute("pageNumber", pageNumber);
					PreparedStatement pstm1=connection.prepareStatement("select * from Category");
					ResultSet rs1 = pstm1.executeQuery();
					int size =0;
					if (rs1 != null) 
					{
					  rs1.last();    
					  size = rs1.getRow(); 
					}
					
					double z = (double) size / 10;
					int rowSize =(int) Math.ceil(z);
					session.setAttribute("rowSize", rowSize);
					
					resp.sendRedirect("Category_Home.jsp");
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
			
			
}
