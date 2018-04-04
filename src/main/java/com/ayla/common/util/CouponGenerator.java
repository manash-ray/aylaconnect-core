package com.ayla.common.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CouponGenerator {

	public static synchronized String generateToken() {

		String generated = null;
		try {
			final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed((System.nanoTime() + new SecureRandom().nextLong()));
			generated = Long.toHexString(random.nextLong());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return generated;

	}

	public static List<String> generateToken(int n) {
		
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		for(int i=0; i<n; i++){
			//list.add(UUID.randomUUID().toString().replaceAll("-", ""));
			list.add(generateToken());
		}
		return list;

	}

}
