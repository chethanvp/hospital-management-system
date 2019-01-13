

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class patient_add
 */
@WebServlet("/patient_add")
public class patient_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			String age=request.getParameter("age");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");

			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root","root");

			Statement stmt = con.createStatement();
			String SQL="insert into patient values(?,?,?,?,?,?);";
			
			
			PreparedStatement pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1,id );
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setString(4, age);
			pstmt.setString(5, phone);
			pstmt.setString(6, address);
			
			pstmt.executeUpdate();
			
			response.sendRedirect("patient.html");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
