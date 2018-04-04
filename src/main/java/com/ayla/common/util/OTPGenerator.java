package com.ayla.common.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class OTPGenerator {

	public static synchronized String generateOTP() {

		String otp = new String();
		int otpSample = 0;
		for (int i = 0; i < 8; i++) {
			otp = otp + "9";
		}

		otpSample = Integer.parseInt(otp);

		SecureRandom prng;
		try {
			prng = SecureRandom.getInstance("SHA1PRNG");
			otp = new Integer(prng.nextInt(otpSample)).toString();
			otp = (otp.length() < 8) ? padleft(otp, 8, '0') : otp;
		} catch (NoSuchAlgorithmException e) {
		}
		return otp;
	}

	private static String padleft(String s, int len, char c) {
		s = s.trim();
		StringBuffer d = new StringBuffer(len);
		int fill = len - s.length();
		while (fill-- > 0)
			d.append(c);
		d.append(s);
		return d.toString();
	}

}
