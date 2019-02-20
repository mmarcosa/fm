package br.com.fm.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public void doHash(String args[]) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String senha = "admin";

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		System.out.println(messageDigest);

	}

}
