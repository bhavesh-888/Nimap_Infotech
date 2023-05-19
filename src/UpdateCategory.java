
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
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateCategoryServlet")
public class UpdateCategory extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session=req.getSession();
			String CategoryName=req.getParameter("CategoryName");
			String id = req.getParameter("Categoryno");
			int Category_ID = Integer.parseInt(id);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
			PreparedStatement pstm=connection.prepareStatement("update  Category set CategoryName=? where CategoryId=?");
			pstm.setString(1, CategoryName);
			pstm.setInt(2, Category_ID);
			int i=pstm.executeUpdate();
			if(i!=0) {
			session.setAttribute("update_on_id", 0);
			resp.sendRedirect("./categoryservlet");
			}else {
				resp.sendRedirect("Index.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			resp.sendRedirect("Index.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			resp.sendRedirect("Index.jsp");
			e.printStackTrace();
		}
		
	}
	
	
}
