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

@WebServlet("/DeleteProductServletAll")
public class Delete_ProductAll extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session=req.getSession();
			String Id=req.getParameter("ProductId");
			int ProductId = Integer.parseInt(Id);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nimap_project", "root", "root");		
			PreparedStatement pstm=connection.prepareStatement("delete from product where ProductId=?");
			pstm.setInt(1, ProductId);
			int i=pstm.executeUpdate();
			if(i!=0) {
			resp.sendRedirect("./AllProductServlet");
			}else {
				
			}
			
		} catch (ClassNotFoundException e) {
			resp.sendRedirect("./AllProductServlet");
			e.printStackTrace();
		} catch (SQLException e) {
			resp.sendRedirect("./AllProductServlet");
			e.printStackTrace();
		}
		
	}
	
	
}

