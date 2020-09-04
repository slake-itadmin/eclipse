
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

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		
		
// login
		if (user_password.equals("1234")) {

			// Get and Display User Detail
			String user_detail_result_script = "powershell.exe  \"C:\\Users\\PNCHIU\\OneDrive\\Work\\PowerShell\\PasswordPortal\\user_detail_result.ps1 " + user_email + "\" ";
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
			
			RequestDispatcher dispatcher_member = request.getRequestDispatcher("/member.jsp");
			dispatcher_member.forward(request, response);
			
			request.setAttribute("login_email", user_email);
			RequestDispatcher dispatcher_unlock_account = request.getRequestDispatcher("/UnlockAccount.java");
			dispatcher_unlock_account.forward(request, response);
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}
}
