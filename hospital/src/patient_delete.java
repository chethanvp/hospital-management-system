

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class patient_delete
 */
@WebServlet("/patient_delete")
public class patient_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
try {
			
			response.setContentType("text/html");
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","root");
			
			Statement stmt=con.createStatement();
			
			
			
			stmt.executeUpdate("delete from patient where p_id="+id);
			
			response.sendRedirect("patient.html");
		}
		catch(Exception e) {
			response.sendRedirect("patient_delete.html");
		}
	}

	

}
