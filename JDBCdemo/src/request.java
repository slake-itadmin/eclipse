import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class request {
	
	public void resetPassword() {
		
		try {
			// Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PasswordResetPortal", "root", "abc$123");
			
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
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
}
