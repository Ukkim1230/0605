package com.test.shop.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util {
	
	private static final String SALT = "123456789123456789123456789123456789123456";
	
	public static String encodePassword(String password) {
		return DigestUtils.sha1Hex(password + SALT);
	}
}
