import java.text.SimpleDateFormat;
import java.util.Date;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;

public class TokenDecode {

	public static String email(String encoded) throws Exception {

		String secret = "841D8A6C80CBA4FCAD32D5367C18C53B";
		String user_email = null;
    	SignedJWT signedJWT = SignedJWT.parse(encoded);
        JWSVerifier verifier = new MACVerifier(secret);
        if (signedJWT.verify(verifier)) {
    		user_email = signedJWT.getJWTClaimsSet().getStringClaim("emails");
        }
		return user_email;
	}

	public static String fullName(String encoded) throws Exception {

		String secret = "841D8A6C80CBA4FCAD32D5367C18C53B";
		String firstName = null;
		String lastName = null;
		String fullName = null;
		SignedJWT signedJWT = SignedJWT.parse(encoded);
        JWSVerifier verifier = new MACVerifier(secret);
        if (signedJWT.verify(verifier)) {
        	firstName = signedJWT.getJWTClaimsSet().getStringClaim("firstName");
        	lastName = signedJWT.getJWTClaimsSet().getStringClaim("lastName");
        	fullName = firstName + " " + lastName;
        }
		return fullName;
	}
	
	public static String date(String encoded) throws Exception {

		String secret = "841D8A6C80CBA4FCAD32D5367C18C53B";
		Date issueDate = null;
    	SignedJWT signedJWT = SignedJWT.parse(encoded);
        JWSVerifier verifier = new MACVerifier(secret);
        if (signedJWT.verify(verifier)) {
        	issueDate = signedJWT.getJWTClaimsSet().getIssueTime();
        }
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return datetimeFormat.format(issueDate);
	}

}
