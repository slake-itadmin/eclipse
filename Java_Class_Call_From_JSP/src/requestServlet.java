

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestServlet")
public class requestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public requestServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/passwordresetportal", "root", "abc$123");
			
			// Create a statement
			Statement myStmt = myConn.createStatement();
			
			// Get current date
			Date currentDate = new Date();
			SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			// Generate random key
			String characters = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String randomString = "";
			int length = 16;
			
			Random rand = new Random();
			
			char[] text = new char[length];
			
			for (int i = 0; i < length; i++) {
				text[i] = characters.charAt(rand.nextInt(characters.length()));
			}
			
			for (int i = 0; i < text.length; i++) {
				randomString += text[i];
			}
			
			// Login email from LoginCheck
			String login_email = "edmundchiu@silverglobe.com";
			
			// 3. Execute SQL query
			String sql = "insert into uservalidation " 
					 + " (start_date_time, random_key, user_email, expire)" 
					 + " values ('" + datetimeFormat.format(currentDate) + "', '" + randomString + "', '" + login_email + "', '1')";
			
			myStmt.execute(sql);
			System.out.println("Please check your email for the reset password link.");
			
			RequestDispatcher rd=request.getRequestDispatcher("in.jsp");
            rd.forward(request, response);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
