package de.aoc.day4;

import java.util.HashMap;
import java.util.Map;

public class Decoder {
	private Map<Character, Character> dictionary = new HashMap<>();
	private int rotation;

	public Decoder(int rotation) {
		this.rotation = rotation;
		dictionary.put('a', 'b');
		dictionary.put('b', 'c');
		dictionary.put('c', 'd');
		dictionary.put('d', 'e');
		dictionary.put('e', 'f');
		dictionary.put('f', 'g');
		dictionary.put('g', 'h');
		dictionary.put('h', 'i');
		dictionary.put('i', 'j');
		dictionary.put('j', 'k');
		dictionary.put('k', 'l');
		dictionary.put('l', 'm');
		dictionary.put('m', 'n');
		dictionary.put('n', 'o');
		dictionary.put('o', 'p');
		dictionary.put('p', 'q');
		dictionary.put('q', 'r');
		dictionary.put('r', 's');
		dictionary.put('s', 't');
		dictionary.put('t', 'u');
		dictionary.put('u', 'v');
		dictionary.put('v', 'w');
		dictionary.put('w', 'x');
		dictionary.put('x', 'y');
		dictionary.put('y', 'z');
		dictionary.put('z', 'a');
	}

	public String decode(String encodedPart) {
		StringBuilder decodedPart = new StringBuilder();
		for (int i = 0; i < encodedPart.length(); i++) {
			Character character = encodedPart.charAt(i);
			for (int z = 0; z < rotation; z++) {
				character = this.dictionary.get(character);
			}
			decodedPart.append(character);
		}
		return decodedPart.toString();
	}
}
