

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			String userID=request.getParameter("LoginID");
			String password=request.getParameter("password");

			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root","root");

			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from user where user_id='"+userID+"' and password='"+password+"'");
			if(rs.next()) { 
				response.sendRedirect("index.html?msg=login successful");
			}
			else {
				response.sendRedirect("login.jsp?msg=login unsuccessful");;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
