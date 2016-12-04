package de.aoc.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

	private String path;
	
	public InputReader(String path) {
		this.path = path;
	}

	public List<Room> readInput() throws IOException {
		InputStream is = new FileInputStream(new File(this.path));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		RoomFactory roomFactory = new RoomFactory();
		List<Room> rooms = br.lines().map(roomFactory::toObject).collect(Collectors.toList());
		br.close();
		return rooms;
	}
}
