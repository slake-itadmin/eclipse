
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
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login_email = request.getParameter("user_email");
		String login_password = request.getParameter("user_password");
		
// login
		
		if (login_password.equals("1234")) {

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
			
			RequestDispatcher dispatcher_user = request.getRequestDispatcher("/user.jsp");
			dispatcher_user.forward(request, response);
			
			request.setAttribute("loginEmail", login_email);
			RequestDispatcher dispatcher_email = request.getRequestDispatcher("/UserUnlock.java");
			dispatcher_email.forward(request, response);

		    // pass login email to UserUnlock.java & UserReset.java 
			HttpSession userEmailSession = request.getSession();
			userEmailSession.setAttribute("login_email", login_email);
		}
		else if (login_password.equals("qwer")) {

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

		    // pass login email to AdminUnlock.java & AdminReset.java
			HttpSession adminEmailSession = request.getSession();
			adminEmailSession.setAttribute("login_email", login_email);
			
		}
		else if (login_password.equals("12qw")) {

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
			RequestDispatcher dispatcher_admin = request.getRequestDispatcher("/test.jsp");
			dispatcher_admin.forward(request, response);

		    // pass login email to AdminUnlock.java & AdminReset.java
			HttpSession adminEmailSession = request.getSession();
			adminEmailSession.setAttribute("login_email", login_email);
		}
		else {
			response.sendRedirect("/error.jsp");
		}
	}
}
