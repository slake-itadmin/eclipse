
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchEmail")
public class SearchEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchEmail() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emails = request.getParameter("emails");

		String silverglobe = "silverglobe";
		String silverlakeaxis = "silverlakeaxis";
		Boolean silverglobe_true = emails.contains(silverglobe);
		Boolean silverlakeaxis_true = emails.contains(silverlakeaxis);

		if (silverglobe_true == true) {

			final String silverglobe_regex = "[a-zA-Z0-9-_.]+@silverglobe.com";
			final Pattern silverglobe_pattern = Pattern.compile(silverglobe_regex);
			final Matcher silverglobe_matcher = silverglobe_pattern.matcher(emails);

			while (silverglobe_matcher.find()) {
				System.out.println("Full match: " + silverglobe_matcher.group(0));
				for (int i = 1; i < silverglobe_matcher.groupCount(); i++) {
					System.out.println("Group " + i + ": " + silverglobe_matcher.group(i));
				}

				request.setAttribute("found_email", silverglobe_matcher.group(0));
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
		} 
		else if (silverlakeaxis_true == true) {

			final String silverlakeaxis_regex = "[a-zA-Z0-9-_.]+@silverlakeaxis.com";
			final Pattern silverlakeaxis_pattern = Pattern.compile(silverlakeaxis_regex);
			final Matcher silverlakeaxis_matcher = silverlakeaxis_pattern.matcher(emails);

			while (silverlakeaxis_matcher.find()) {
				System.out.println("Full match: " + silverlakeaxis_matcher.group(0));
				for (int i = 1; i < silverlakeaxis_matcher.groupCount(); i++) {
					System.out.println("Group " + i + ": " + silverlakeaxis_matcher.group(i));
				}

				request.setAttribute("found_email", silverlakeaxis_matcher.group(0));
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
		}
	}
}
