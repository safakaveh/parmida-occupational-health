package com.parmida.common.utils;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.parmida.common.utils.exception.UtilityException;
import com.parmida.common.utils.exception.UtilityException.UtilityExceptionList;

public class PasswordTools {
	public static String getHash(String password) throws UtilityException {
		try {
			// SecureRandom random = new SecureRandom();
			byte[] salt = { 0x53, 0x61, 0x66, 0x61, 0x20, 0x4b, 0x61, 0x76, 0x65, 0x68, 0x20, 0x4a, 0x61, 0x76, 0x61,
					0x20 };
			// random.nextBytes(salt);
			KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = factory.generateSecret(spec).getEncoded();
			return Base64.getEncoder().encodeToString(hash);
		} catch (Exception e) {
			throw new UtilityException(UtilityExceptionList.PASSEORD_HASHING);
		}
	}
}
