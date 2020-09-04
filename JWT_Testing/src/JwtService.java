import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.util.Date;
import java.util.HashMap;

public class JwtService {
	public JwtService() {
        super();
    }
    
    public static void main (String[] args){
        try{
            HashMap<String, String> dataMap = new HashMap<String, String>();
            dataMap.put("email", "abc@silverglobe.com|ccc@silveraxis.com");
            dataMap.put("firstname", "LIM");
            dataMap.put("lastname", "ALI");
            System.out.println("token: " + generateToken(dataMap));    
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static String generateToken(HashMap<String, String> dataMap) throws Exception{
        String secret = "841D8A6C80CBA4FCAD32D5367C18C53B";
        JWSSigner signer = new MACSigner(secret);

         
        JWTClaimsSet.Builder builder= new JWTClaimsSet.Builder();
        for(String key: dataMap.keySet()){
            builder.claim(key, dataMap.get(key));
        }
        builder.issueTime(new Date());
        JWTClaimsSet claimsSet = builder.build();
        
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

        // Apply the HMAC protection
        signedJWT.sign(signer);

        String s = signedJWT.serialize();
        
        return s;
    }
    
    public static String parseToken(String token) throws Exception{
        String secret = "841D8A6C80CBA4FCAD32D5367C18C53B";
        
        SignedJWT signedJWT = SignedJWT.parse(token);
        JWSVerifier verifier = new MACVerifier(secret);
        String emails = signedJWT.getJWTClaimsSet().getStringClaim("emails");
        String firstName = signedJWT.getJWTClaimsSet().getStringClaim("firstName");
        String lastName = signedJWT.getJWTClaimsSet().getStringClaim("lastName");
        Date issueDate = signedJWT.getJWTClaimsSet().getIssueTime();
        
        String t = emails + " :: " + firstName + " :: " + lastName + " :: " + issueDate;
        
        return t;
    }    
}
