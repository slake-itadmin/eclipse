
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserCheck")
public class UserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get t from URL pass from AAMS
		String encoded = request.getParameter("t");

		String user_email = null;
		String full_name = null;
		String issue_date = null;
		String found_email = null;

		// Use TokenDecode to decode t and get
		try {
			user_email = TokenDecode.email(encoded);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Use TokenDecode to decode full name and pass to here
		try {
			full_name = TokenDecode.fullName(encoded);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Use TokenDecode to decode full name and pass to here
		try {
			issue_date = TokenDecode.date(encoded);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Use SearchEmail to find company email
		try {
			found_email = SearchEmail.search(user_email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(found_email);

		// Get ID's Detail from Active Directory
		String user_detail_result_script = "powershell.exe  \"E:\\OneDrive\\Work\\PowerShell\\PasswordPortal\\user_detail_result.ps1 " + found_email + "\" ";
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

		request.setAttribute("found_email", found_email);
		request.getRequestDispatcher("user.jsp").forward(request, response);

		RequestDispatcher dispatcher_user = request.getRequestDispatcher("/user.jsp");
		dispatcher_user.forward(request, response);

		// pass user email to UserUnlock
		request.setAttribute("login_email", found_email);
		RequestDispatcher dispatcher_userUnlock = request.getRequestDispatcher("/UserUnlock.java");
		dispatcher_userUnlock.forward(request, response);

		// pass login email to UserUnlock.java & UserReset.java
		HttpSession userEmailSession = request.getSession();
		userEmailSession.setAttribute("login_email", found_email);

	}
}
