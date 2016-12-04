package de.aoc.day4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Room {
	private String encryptedName;
	private int sectorId;
	private String checksum;
	private Map<Character, Integer> checkMap = new HashMap<>();

	public Room(String encryptedName, int sectorId, String checksum) {
		this.encryptedName = encryptedName;
		this.sectorId = sectorId;
		this.checksum = checksum;
		this.buildMap();
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

	public int getSectorId() {
		return sectorId;
	}

	public boolean isValid() {
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
