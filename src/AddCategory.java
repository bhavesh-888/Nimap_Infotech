import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCategoryServlet")
public class AddCategory extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String CategoryName=req.getParameter("CategoryName");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
			PreparedStatement pstm=connection.prepareStatement("insert into Category(CategoryName) values(?)");
			pstm.setString(1, CategoryName);
			int i=pstm.executeUpdate();
			resp.sendRedirect("./categoryservlet");
			
		} catch (ClassNotFoundException e) {
			resp.sendRedirect("Index.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			resp.sendRedirect("Index.jsp");
			e.printStackTrace();
		}
		
	}
	
	
}
