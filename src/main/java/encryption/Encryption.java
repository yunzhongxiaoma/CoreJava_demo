package main.java.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {

	public static String encodeByMd5(String str) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] digest = md5.digest(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
		return Base64.getEncoder().encodeToString(digest);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String psw = "123456";
		System.out.println(encodeByMd5(psw)); // 输出：1B2M2Y8EoHdQqjLZTf0lF7P9Xh/7iRgD
	}
}