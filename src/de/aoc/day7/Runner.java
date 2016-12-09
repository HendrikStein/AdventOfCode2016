package de.aoc.day7;

import java.io.IOException;

public class Runner {
	public static void main(String[] args) throws IOException {
		IpValidator validator = new IpValidator();
		long count = validator.countTls("resource//day7.csv");
		System.out.println("Amount of TLS supports:" + count);
		
		count = validator.countSsl("resource//day7.csv");
		System.out.println("Amount of SSL supports:" + count);
	}
}
