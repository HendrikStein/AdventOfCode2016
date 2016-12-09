package de.aoc.day6;

import java.io.IOException;

public class Runner {
	public static void main(String[] agrgs) throws IOException {
		Recorder recorder = new Recorder("resource//day6.csv", Order.ASC);
		System.out.println(recorder.getErrorCorrectedMessage());
		
		recorder = new Recorder("resource//day6.csv", Order.DESC);
		System.out.println(recorder.getErrorCorrectedMessage());
	}
}
