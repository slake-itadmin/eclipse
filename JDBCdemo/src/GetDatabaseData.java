
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetDatabaseData {

	public static void main(String[] args) {
		
		try {
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PasswordResetPortal", "root", "abc$123");
			
			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			ResultSet myRs  = myStmt.executeQuery("select * from employees");
			
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("user_name") + ", " + myRs.getString("user_email"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
