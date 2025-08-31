package com.parmida.common.utils;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignatureTools {
	public static void main(String args[]) throws Exception {

		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048);
		KeyPair pair = keyPairGen.generateKeyPair();
		PrivateKey privKey = pair.getPrivate();
		String pk = Base64.getEncoder().encodeToString(privKey.getEncoded());
		String puk = Base64.getEncoder().encodeToString(pair.getPublic().getEncoded());
		String signed = sign("Safa", pk);
	}

	public static String sign(String planetxt, String privateBase64)
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		byte[] bPrvKey = Base64.getDecoder().decode(privateBase64);

		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey privyKey = kf.generatePrivate(new PKCS8EncodedKeySpec(bPrvKey));
		Signature sign = Signature.getInstance("SHA256withRSA");
		sign.initSign(privyKey);
		sign.update(planetxt.getBytes());

		return Base64.getEncoder().encodeToString(sign.sign());
	}

	public static boolean isValidSign(String str, String sign, String publiclyBase64)
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		byte[] bPubkey = Base64.getDecoder().decode(publiclyBase64);
		byte[] bsign = Base64.getDecoder().decode(sign);

		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey pubKey = kf.generatePublic(new X509EncodedKeySpec(bPubkey));

		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(pubKey);
		signature.update(str.getBytes());

		return signature.verify(bsign);
	}

	public static KeyPair getKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048);
		return keyPairGen.generateKeyPair();
	}

	public static String getPublicKey(String privateBase64)
			throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
		byte[] bPrvKey = Base64.getDecoder().decode(privateBase64);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey privKey = kf.generatePrivate(new PKCS8EncodedKeySpec(bPrvKey));
		RSAPrivateCrtKey privk = (RSAPrivateCrtKey) privKey;
		RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(privk.getModulus(), privk.getPublicExponent());
		PublicKey pubKey = kf.generatePublic(publicKeySpec);
		return Base64.getEncoder().encodeToString(pubKey.getEncoded());
	}

}
