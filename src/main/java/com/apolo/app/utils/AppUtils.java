package com.apolo.app.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class AppUtils {

	public static String generateFixedSizeUniqueRandom(int size) {
		SecureRandom random = new SecureRandom();
		byte[] randomBytes = new byte[size];
		random.nextBytes(randomBytes);
		String token = Base64.getUrlEncoder().encodeToString(randomBytes);
		return token;
	}

	public static String encodeBase64(String data) {
		return Base64.getEncoder().encodeToString(data.getBytes());
	}

}
