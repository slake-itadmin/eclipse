

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Encryption")
public class Encryption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Encryption() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String encrypt_string = request.getParameter("encrypt_string");
		String encrypt_key = request.getParameter("encrypt_key");
		
		String encrypted_string = EncryptionClass.main(encrypt_string, encrypt_key);
		
		request.setAttribute("encrypted_string",encrypted_string);
	    request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
