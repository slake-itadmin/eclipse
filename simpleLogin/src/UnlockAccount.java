
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

@WebServlet("/UnlockAccount")
public class UnlockAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UnlockAccount() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String get_email_address = request.getParameter("input_email_address");

		// Unlock Account
		String unlock_account_script = "powershell.exe  \"C:\\Users\\PNCHIU\\OneDrive\\Work\\PowerShell\\PasswordPortal\\unlock_account.ps1 " + get_email_address + "\" ";
		Process unlock_account_process = Runtime.getRuntime().exec(unlock_account_script);
		unlock_account_process.getOutputStream().close();
		String unlock_account_result;
		BufferedReader unlock_account_output = new BufferedReader(
				new InputStreamReader(unlock_account_process.getInputStream()));
		while ((unlock_account_result = unlock_account_output.readLine()) != null) {
			request.setAttribute("unlockAccountResult", unlock_account_result);
		}
		unlock_account_output.close();
		
		// Get and Display User Detail
		
		String loginEmail = (String)request.getAttribute("login_email");
		String user_detail_result_script = "powershell.exe  \"C:\\Users\\PNCHIU\\OneDrive\\Work\\PowerShell\\PasswordPortal\\user_detail_result.ps1 " + loginEmail + "\" ";
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/member.jsp");
		dispatcher.forward(request, response);

	}

}
