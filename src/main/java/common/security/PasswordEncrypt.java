package common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncrypt {
	
	public static String getEncryptedPassword(String inputPassword) {
		String result = null;
		
		return result;
	}

	public static String makeEncryptedPassword(String inputPassword, String salt) {

		String result = null;

		StringBuffer encryptedPassword = new StringBuffer();

		encryptedPassword.append(inputPassword).append(salt);
		
		try {
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			mdSHA256.update(encryptedPassword.toString().getBytes());
			result = PasswordEncrypt.bytesToHex(mdSHA256.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public static Long getSalt() {
		Long result = null;
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			result = sr.nextLong();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static boolean checkPassword(String encryptedPassword, String passwordFromDB) {
		boolean result = false;
		if (encryptedPassword.equals(passwordFromDB)) {
			result = true;
		}
		return result;
	}

	public static String bytesToHex(byte[] bytes) {
		StringBuffer builder = new StringBuffer();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

}