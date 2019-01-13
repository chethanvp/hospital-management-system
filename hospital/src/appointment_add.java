

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class appointment_add
 */
@WebServlet("/appointment_add")
public class appointment_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			int a_id=Integer.parseInt(request.getParameter("a_id"));
			int p_id=Integer.parseInt(request.getParameter("p_id"));
			String p_name=request.getParameter("p_name");
			int d_id=Integer.parseInt(request.getParameter("d_id"));
			String a_time=request.getParameter("a_time");
			String a_date=request.getParameter("a_date");
			String phone=request.getParameter("phone");
			String p_disease=request.getParameter("p_disease");
			String description=request.getParameter("description");

			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root","root");

			
			String SQL="insert into appointment values(?,?,?,?,?,?,?,?);";
			
			
			PreparedStatement pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1,a_id );
			pstmt.setInt(2, p_id);
			pstmt.setString(3, p_name);
			pstmt.setInt(4, d_id);
			pstmt.setString(5, a_time);
			pstmt.setString(6, a_date);
			pstmt.setString(7, phone);
			pstmt.setString(8, p_disease);
			pstmt.setString(9, description);
			
			pstmt.executeUpdate();
			
			response.sendRedirect("appointment.html");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
