
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PushDateToDatabase {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/passwordresetportal";
		String user = "root";
		String password = "abc$123";
				
		try {
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String sql = "insert into employees " 
						 + " (user_name, user_password, user_email)" 
						 + " values ('Testing', 'abc%123', 'testing@silverglobe.com')";
						
			myStmt.execute(sql);
			
			System.out.println("Insert Complete.");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}	
	}
}
