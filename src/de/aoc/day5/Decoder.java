package de.aoc.day5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Decoder {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		 String baseDoorId = "ffykfhsq";
//		String baseDoorId = "abc";
		Decoder decoder = new Decoder();
		System.out.println("Simple password: "
				+ decoder.simplePassword(baseDoorId));

		System.out.println("Advanced password: "
				+ decoder.advancedPassword(baseDoorId));
	}

	public String simplePassword(String baseDoorId)
			throws NoSuchAlgorithmException {
		String doorId = "";
		String generatedPassword = "";
		int counter = 0;
		while (generatedPassword.length() < 8) {
			doorId = baseDoorId + counter;
			String hash = this.hash(doorId);
			if (hash.startsWith("00000")) {
				generatedPassword += hash.charAt(5);
				System.out.println("Next Charcter found: " + generatedPassword
						+ " -> " + (8 - generatedPassword.length())
						+ " charcters missing");
			}
			counter++;
		}
		return generatedPassword;
	}

	public String advancedPassword(String baseDoorId)
			throws NoSuchAlgorithmException {
		String doorId = "";
		char[] generatedPassword = new char[] { '_', '_', '_', '_', '_', '_',
				'_', '_' };
		int counter = 0, charCounter = 0;
		while (charCounter < 8) {
			doorId = baseDoorId + counter;
			String hash = this.hash(doorId);
			if (hash.startsWith("00000")) {
				try {
					int position = Integer.valueOf(String.valueOf(hash
							.charAt(5)));
					if (position < 8 && generatedPassword[position] == '_') {
						generatedPassword[position] = hash.charAt(6);
						charCounter++;
						System.out.println("Next Charcter found: "
								+ new String(generatedPassword) + " -> "
								+ (8 - charCounter) + " charcters missing");
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Unable to process hash: " + hash);
				}
			}
			counter++;
		}
		return new String(generatedPassword);
	}

	public String hash(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes());
		byte[] digest = md.digest();
		StringBuilder builder = new StringBuilder();
		for (byte b : digest) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}
