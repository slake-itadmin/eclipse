import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CipherHelper {

	// Algorithm used
	private final static String ALGORITHM = "DES";
	
	
	/**
	 * Encrypt data
	 * @param secretKey - a key used for encryption
	 * @param data      - data to encrypt
	 * @return Encrypted data
	 * @throws Exception
	 */
	public static String cipher (String secretKey, String data) throws Exception {
		// Key has to be of length 8
		if (secretKey == null || secretKey.length() != 8)
			throw new Exception("Invalid key length - 8 bytes key needed!");
		
		SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		return new String(cipher.doFinal(data.getBytes()));
	}
	
	/**
	 * Decrypt data
	 * @param secretKey - a secret key used for decryption
	 * @param data      - data to decrypt
	 * @return Decrypted data
	 * @throws Exception
	 */
	public static String decipher (String secretKey, String data) throws Exception {
		// Key has to be of length 8
		if (secretKey == null || secretKey.length() != 8)
			throw new Exception("Invalid key length - 8 bytes key needed!");
		
		SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		return new String(cipher.doFinal(data.getBytes(data)));
	}

	
}
