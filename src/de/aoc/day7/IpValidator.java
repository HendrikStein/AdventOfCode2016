package de.aoc.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IpValidator {

	public long countTls(String path) throws IOException {
		InputStream is = new FileInputStream(new File(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		IpAddressFactory ipAddressFactory = new IpAddressFactory();
		long tlsAddressCount = br.lines().map(ipAddressFactory::toObject)
				.filter(ip -> ip.isTlsValid()).count();
		br.close();
		return tlsAddressCount;
	}

	public long countSsl(String path) throws IOException {
		InputStream is = new FileInputStream(new File(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		IpAddressFactory ipAddressFactory = new IpAddressFactory();
		long sslAddressCount = br.lines().map(ipAddressFactory::toObject)
				.filter(ip -> ip.isSslValid()).count();
		br.close();
		return sslAddressCount;
	}
	
}
