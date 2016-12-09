package de.aoc.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Recorder {

	private Map<Character, Integer> record;
	private String path;
	private String message = "";
	private List<String> input = new ArrayList<>();
	private Order order;
	
	public Recorder(String path, Order order) {
		this.path = path;
		this.order = order;
	}

	public String getErrorCorrectedMessage() throws IOException {
		this.readInput();
		this.decryptInput();
		return this.message;
	}

	private void readInput() throws IOException {
		InputStream is = new FileInputStream(new File(this.path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		br.lines().forEach(line -> this.transform(line));
		br.close();
	}

	private void transform(String line) {
		for (int i = 0; i < line.length(); i++) {
			try {
				String rec = this.input.get(i);
				this.input.set(i, rec += String.valueOf(line.charAt(i)));
			} catch (IndexOutOfBoundsException ex) {
				this.input.add(String.valueOf(line.charAt(i)));
			}
		}
	}

	private void decryptInput() {
		this.input.stream().forEach(line -> this.decryptLine(line));
	}

	private void decryptLine(String line) {
		this.buildRecord(line);
		SortedSet<Map.Entry<Character, Integer>> sortedRecord = this.sort(this.order);
		this.message += sortedRecord.first().getKey();
	}

	private void buildRecord(String line) {
		this.record = new HashMap<>();
		int counter = 0;
		Character key;
		for (int i = 0; i < line.length(); i++) {
			key = line.charAt(i);
			if (this.record.get(key) != null) {
				counter = this.record.get(key);
				this.record.put(key, ++counter);
			} else {
				this.record.put(key, 1);
			}
		}
	}

	private SortedSet<Map.Entry<Character, Integer>> sort(Order order) {
		SortedSet<Map.Entry<Character, Integer>> sortedEntries = new TreeSet<>(
				new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> e1,
							Map.Entry<Character, Integer> e2) {
						int res = 0;
						if (order == Order.DESC) {
							res = e1.getValue().compareTo(e2.getValue());
						} else if (order == Order.ASC) {
							res = e2.getValue().compareTo(e1.getValue());
						}
						if (res == 0) {
							return e1.getKey().compareTo(e2.getKey());
						}
						return res;
					}
				});
		sortedEntries.addAll(this.record.entrySet());
		return sortedEntries;
	}
}
