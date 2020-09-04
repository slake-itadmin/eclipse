
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDatabaseData {

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
			String sql = "update employees" 
						 + " set user_email='hongseng.siet@silverglobe.com'" 
						 + " where user_name='sieths'";
						
			myStmt.executeUpdate(sql);
			
			System.out.println("Update complete.");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}	
	}
}
