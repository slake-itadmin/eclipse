import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt_Decrypt {
	public void run() 
    {
        try 
        {
            String text = "edmundchiu@silverglobe.com";
            String key = "Edmund12Edmund12"; // 128 bit key
            
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.err.println(new String(encrypted));
            
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println(decrypted);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
    	Encrypt_Decrypt app = new Encrypt_Decrypt();
        app.run();
    }
}
