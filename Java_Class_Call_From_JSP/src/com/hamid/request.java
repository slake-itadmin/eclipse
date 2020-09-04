package com.hamid;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class request {
	
	public void resetPassword() {
		
		public static final String generateUserHash(String value, String secretKey) {
			String hashString = null;
			try {
				Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
				SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
				sha256_HMAC.init(secret_key);

				byte[] hash = (sha256_HMAC.doFinal(value.getBytes()));
				StringBuffer result = new StringBuffer();
				for (byte b : hash) {
					result.append(String.format("%02X", b));
				}
				hashString = result.toString();
			} catch (Exception e) {
				throw new RuntimeException("Exception caught when generating user hash", e);
			}
			return hashString;
		}
	}
	
}
