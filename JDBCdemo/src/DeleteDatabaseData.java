import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDatabaseData {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/passwordresetportal";
		String user = "root";
		String password = "abc$123";
		String user_name = "testing";
				
		try {
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			
			String sql = "delete from employees where user_name='" + user_name + "'";
			
			int rowsAffected = myStmt.executeUpdate(sql);
			
			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("Delete complete.");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}	
	}
}
