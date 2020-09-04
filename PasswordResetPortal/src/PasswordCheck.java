
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PasswordCheck")
public class PasswordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PasswordCheck() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get new and confirm password from userReset.jsp
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");

		// Get user email and domain id from userReset.jsp
		HttpSession session = request.getSession();
		String user_email = (String) session.getAttribute("user_email");	
		String domain_id = (String) session.getAttribute("domainId");	
		
		// if both password match, then process password reset
		if (new_password.equals(confirm_password)) {
			
			confirm_password = "'" + confirm_password + "'";
			
			// Reset user domain's password
			String user_reset_password_script = "powershell.exe  \"E:\\OneDrive\\Work\\PowerShell\\PasswordPortal\\user_reset_password.ps1 " + user_email + " " + confirm_password + "\" ";
			Process user_reset_password_process = Runtime.getRuntime().exec(user_reset_password_script);
			user_reset_password_process.getOutputStream().close();
			String user_reset_password_result;
			String user_reset_password_result_s;
			
			BufferedReader user_reset_password_output = new BufferedReader(new InputStreamReader(user_reset_password_process.getInputStream()));
			if ((user_reset_password_result = user_reset_password_output.readLine()) != null) {
				request.setAttribute("userResetPasswordResult", user_reset_password_result);
				request.setAttribute("domain_id", domain_id);
				request.setAttribute("user_email", user_email);
				request.getRequestDispatcher("userReset.jsp").forward(request, response);
				response.sendRedirect("userReset.jsp");
				
			}
			else if ((user_reset_password_result_s = user_reset_password_output.readLine()) == null) {
				user_reset_password_result_s = "Password Reset Successfully.";
				
				String user_reset_password_notification_script = "powershell.exe  \"E:\\OneDrive\\Work\\PowerShell\\PasswordPortal\\user_reset_password_notification.ps1 " + user_email + "\" ";
				Process user_reset_password_notification_process = Runtime.getRuntime().exec(user_reset_password_notification_script);
				user_reset_password_notification_process.getOutputStream().close();
				
				request.setAttribute("userResetPasswordResult_s", user_reset_password_result_s);
				request.setAttribute("domain_id", domain_id);
				request.setAttribute("user_email", user_email);
				request.getRequestDispatcher("userReset.jsp").forward(request, response);
				response.sendRedirect("userReset.jsp");
			}
			
			user_reset_password_output.close();
			
		}
		else if (!new_password.equals(confirm_password)) {
			String user_reset_password_result = "Passwords you entered does not match.";
			request.setAttribute("userResetPasswordResult", user_reset_password_result);
			request.setAttribute("domain_id", domain_id);
			request.setAttribute("user_email", user_email);
			request.getRequestDispatcher("userReset.jsp").forward(request, response);
			response.sendRedirect("userReset.jsp");
		}
		
	}

}
