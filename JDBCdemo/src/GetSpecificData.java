import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSpecificData {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/passwordresetportal", "root", "abc$123");
			
			// 2. Prepare statement
			myStmt = myConn.prepareStatement("select * from employees where user_name=?");
			
			// 3. Execute SQL query
			myStmt.setString(1, "edmund");
			
			// 4. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 5. Display the result set
			display(myRs);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}	
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}

	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			int userId = myRs.getInt("user_id");
			String userName = myRs.getString("user_name");
			String userPassword = myRs.getString("user_password");
			String userEmail = myRs.getString("user_email");
			
			System.out.printf("ID : %s\nUsername : %s\nPassword : %s\nEmail : %s\n", userId, userName, userPassword, userEmail);
		}
	}
}