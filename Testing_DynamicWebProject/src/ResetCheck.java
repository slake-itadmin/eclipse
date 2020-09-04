import java.io.IOException;
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

@WebServlet("/ResetCheck")
public class ResetCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reset_key = request.getParameter("reset_key");

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PasswordResetPortal", "root", "abc$123");

			
			myStmt = myConn.prepareStatement("select * from uservalidation where random_key=?");
			myStmt.setString(1, reset_key);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String userEmail = myRs.getString("user_email");
				String randomKey = myRs.getString("random_key");
				System.out.println(userEmail);
				
				if (reset_key.equals(randomKey)) {
					response.sendRedirect("resetPage.jsp");
				}
				else {
					response.sendRedirect("errorLink.jsp");
				}
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
