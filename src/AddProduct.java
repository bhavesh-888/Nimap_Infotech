import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			int Category_Id=(int)session.getAttribute("Category_ID");
			
			
			String Product_Name=req.getParameter("Product_Name");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
			
			PreparedStatement pstm1=connection.prepareStatement("select * from Category where CategoryID=?");
			pstm1.setInt(1, Category_Id);
			ResultSet rs1=pstm1.executeQuery();
			rs1.next();
			
			System.out.println(rs1.getInt("CategoryID"));
			System.out.println(rs1.getString("CategoryName"));			
			
			PreparedStatement pstm=connection.prepareStatement("insert into product(ProductName,CategoryName,CategoryID) values(?,?,?)");
			pstm.setString(1, Product_Name);
			pstm.setString(2, rs1.getString("CategoryName"));
			pstm.setInt(3, rs1.getInt("CategoryId"));
			int i=pstm.executeUpdate();
			resp.sendRedirect("./sepcificproductservlet");
			
		} catch (ClassNotFoundException e) {
			resp.sendRedirect("./sepcificproductservlet");
			e.printStackTrace();
		} catch (SQLException e) {
			resp.sendRedirect("./sepcificproductservlet");
			e.printStackTrace();
		}
		
	}
	
	
}
