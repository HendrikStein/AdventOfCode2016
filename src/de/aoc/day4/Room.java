package de.aoc.day4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Room {
	private String encryptedName;
	private String originalName;
	private int sectorId;
	private String checksum;
	private Map<Character, Integer> checkMap = new HashMap<>();

	public Room(String encryptedName, String originalName, int sectorId, String checksum) {
		this.originalName = originalName;
		this.encryptedName = encryptedName;
		this.sectorId = sectorId;
		this.checksum = checksum;
		this.buildMap();
	}

	public int getSectorId() {
		return sectorId;
	}

	public String getDecryptedName() {
		StringBuilder builder = new StringBuilder();
		Decoder decoder = new Decoder(this.sectorId);
		String[] words = this.originalName.split(" ");
		for (String word : words) {
			builder.append(decoder.decode(word));
			builder.append(" ");
		}
		return builder.toString().trim();
	}

	private void buildMap() {
		int counter = 0;
		Character key;
		for (int i = 0; i < this.encryptedName.length(); i++) {
			key = this.encryptedName.charAt(i);
			if (this.checkMap.get(key) != null) {
				counter = this.checkMap.get(key);
				this.checkMap.put(key, ++counter);
			} else {
				this.checkMap.put(key, 1);
			}
		}
	}

	private SortedSet<Map.Entry<Character, Integer>> sort(Map<Character, Integer> map) {
		SortedSet<Map.Entry<Character, Integer>> sortedEntries = new TreeSet<>(
				new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
						int res = e2.getValue().compareTo(e1.getValue());
						if (res == 0) {
							return e1.getKey().compareTo(e2.getKey());
						}
						return res;
					}
				});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}

	public boolean isValid() {
		System.out.println(this.originalName);
		SortedSet<Map.Entry<Character, Integer>> sortedSet = sort(this.checkMap);
		int counter = 0;
		for (Map.Entry<Character, Integer> entry : sortedSet) {
			if (entry.getKey().equals(this.checksum.charAt(counter))) {
				if (counter == 4) {
					return true;
				}
				counter++;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Room [encryptedName=" + encryptedName + ", sectorId=" + sectorId + ", checksum=" + checksum + "]";
	}

}
