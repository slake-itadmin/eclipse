

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserRequestReset")
public class UserRequestReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRequestReset() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Get MYSQL JDBC's driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PasswordResetPortal", "root", "abc$123");
			
			// Create a statement
			Statement request_record = myConn.createStatement();
			
			// Get current date
			Date startDate = new Date();
			SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			// Generate random key
			String characters = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String random_key = "";
			int length = 16;
			
			Random rand = new Random();
			
			char[] text = new char[length];
			
			for (int i = 0; i < length; i++) {
				text[i] = characters.charAt(rand.nextInt(characters.length()));
			}
			
			for (int i = 0; i < text.length; i++) {
				random_key += text[i];
			}
			
			// Get user's detail from user.jsp
			HttpSession session = request.getSession();
			String domain_name = (String)session.getAttribute("domain_name");
			String domain_id = (String)session.getAttribute("domain_id");
			String user_email = (String)session.getAttribute("user_email");
			String escape_backslash = "\\";
			String final_domain_id = domain_name + escape_backslash + domain_id;
			
			System.out.println(user_email);
			
			// Execute SQL query
			String sql = "insert into uservalidation " 
					 + " (start_date_time, domain_id, user_email, random_key, expire)" 
					 + " values ('" + datetimeFormat.format(startDate) + "', '" + final_domain_id + "', '" + user_email + "', '" + random_key + "', '1')";
			request_record.execute(sql);		
			
			// Send reset password link to user's email
			String user_request_reset_script = "powershell.exe  \"E:\\OneDrive\\Work\\PowerShell\\PasswordPortal\\request_reset_password.ps1 " + user_email + " " + domain_id + " " + random_key + "\" ";
			Process user_request_reset_process = Runtime.getRuntime().exec(user_request_reset_script);
			user_request_reset_process.getOutputStream().close();
			String user_request_reset_result;
			BufferedReader user_request_reset_output = new BufferedReader(new InputStreamReader(user_request_reset_process.getInputStream()));
			List<String> requestReset = new ArrayList<String>();
			while ((user_request_reset_result = user_request_reset_output.readLine()) != null) {
				requestReset.add(user_request_reset_result);
			}
			request.setAttribute("UserRequestResetResult", requestReset);
			user_request_reset_output.close();

			// send output to userRequestReset.jsp
			RequestDispatcher dispatcher_admin = request.getRequestDispatcher("/user.jsp");
			dispatcher_admin.forward(request, response);
				
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
