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

@WebServlet("/AdminUnlock")
public class AdminUnlock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminUnlock() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get email from admin.jsp
		String admin_unlock_email = request.getParameter("admin_unlock_email");
		
		// Get login email from LoginCheck.java
		Object login_email = request.getSession().getAttribute("login_email");

		// Unlock Account
		String admin_unlock_script = "powershell.exe  \"E:\\OneDrive\\Work\\PowerShell\\PasswordPortal\\unlock_account.ps1 " + login_email + " " + admin_unlock_email + "\" ";
		Process admin_unlock_process = Runtime.getRuntime().exec(admin_unlock_script);
		admin_unlock_process.getOutputStream().close();
		String admin_unlock_result;
		BufferedReader admin_unlock_output = new BufferedReader(new InputStreamReader(admin_unlock_process.getInputStream()));
		while ((admin_unlock_result = admin_unlock_output.readLine()) != null) {
			request.setAttribute("adminUnlockResult", admin_unlock_result);
		}
		admin_unlock_output.close();
		
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
		
		// send output to admin.jsp
		RequestDispatcher dispatcher_admin = request.getRequestDispatcher("/admin.jsp");
		dispatcher_admin.forward(request, response);

	}

}
