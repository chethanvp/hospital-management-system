

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
 * Servlet implementation class medicine_add
 */
@WebServlet("/medicine_add")
public class medicine_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int m_id=Integer.parseInt(request.getParameter("m_id"));
			int p_id=Integer.parseInt(request.getParameter("p_id"));
			int d_id=Integer.parseInt(request.getParameter("d_id"));
			String date=request.getParameter("date");
			String medicines=request.getParameter("medicines");
			String prescription=request.getParameter("prescription");
			int amount=Integer.parseInt(request.getParameter("amount"));
						
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root","root");

			
			String SQL="insert into medicine values(?,?,?,?,?,?,?);";
			
			
			PreparedStatement pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1,m_id );
			pstmt.setInt(2, p_id);
			pstmt.setInt(3, d_id);
			pstmt.setString(4, date);
			pstmt.setString(5, medicines);
			pstmt.setString(6, prescription);
			pstmt.setInt(7, amount);
			
			pstmt.executeUpdate();
			
			response.sendRedirect("medicine.html");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
