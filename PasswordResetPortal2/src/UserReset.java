
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserReset")
public class UserReset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserReset() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get login email from LoginCheck.java
		Object login_email = request.getSession().getAttribute("login_email");

		// Reset password
		String user_reset_script = "powershell.exe  \"E:\\OneDrive\\Work\\PowerShell\\PasswordPortal\\reset_password.ps1 " + login_email + "\" ";
		Process user_reset_process = Runtime.getRuntime().exec(user_reset_script);
		user_reset_process.getOutputStream().close();
		String user_reset_result;
		BufferedReader user_reset_output = new BufferedReader(
				new InputStreamReader(user_reset_process.getInputStream()));
		while ((user_reset_result = user_reset_output.readLine()) != null) {
			request.setAttribute("userResetResult", user_reset_result);
		}
		user_reset_output.close();

		// Get User's Detail
		String user_detail_result_script = "powershell.exe  \"E:\\OneDrive\\Work\\PowerShell\\PasswordPortal\\user_detail_result.ps1 " + login_email + "\" ";
		Process user_detail_result_process = Runtime.getRuntime().exec(user_detail_result_script);
		user_detail_result_process.getOutputStream().close();
		BufferedReader user_detail_result_output = new BufferedReader(new InputStreamReader(user_detail_result_process.getInputStream()));

		String user_detail_result;
		List<String> details = new ArrayList<String>();
		while ((user_detail_result = user_detail_result_output.readLine()) != null) {
			details.add(user_detail_result);
		}
		request.setAttribute("UserDetailResult", details);
		user_detail_result_output.close();

		// send output to user.jsp
		RequestDispatcher dispatcher_admin = request.getRequestDispatcher("/user.jsp");
		dispatcher_admin.forward(request, response);
	}

}
