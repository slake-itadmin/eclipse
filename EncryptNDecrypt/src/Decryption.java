

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Decryption")
public class Decryption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Decryption() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String decrypt_string = request.getParameter("decrypt_string");
		String decrypt_key = request.getParameter("decrypt_key");
		
		String decryptedString = DecryptionClass.main(decrypt_string, decrypt_key);
		
		request.setAttribute("decrypt_string",decryptedString);
	    request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

}
