

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/KeyCheck")
public class KeyCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KeyCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get random key from requestResetLogin.jsp
		String random_key = request.getParameter("random_key");
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// Get MYSQL JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PasswordResetPortal", "root", "abc$123");

			// Get current date
			Date stopDate = new Date();
			SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			// Checking key validity
			myStmt = myConn.prepareStatement("select * from uservalidation where random_key=?");
			myStmt.setString(1, random_key);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				// Get user's email, domain id and random key from MariaDB
				String startDate = myRs.getString("start_date_time");
				String domainId = myRs.getString("domain_id");
				String userEmail = myRs.getString("user_email");
				String randomKey = myRs.getString("random_key");
				
				long compareTime = CompareDateTime.main(startDate, datetimeFormat.format(stopDate));
				
				if ((random_key.equals(randomKey)) && (compareTime <= 60)) {
					// Send variable to userReset.jsp
					request.setAttribute("domain_id", domainId);
					request.setAttribute("user_email", userEmail);
					request.getRequestDispatcher("userReset.jsp").forward(request, response);
					response.sendRedirect("userReset.jsp");
				}
				else if (compareTime > 60) {
					response.sendRedirect("linkExpired.jsp");
				}
				else {
					response.sendRedirect("errorPage.jsp");
				}
				
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
