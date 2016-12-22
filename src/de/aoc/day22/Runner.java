package de.aoc.day22;

import java.io.IOException;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws IOException {
		List<GridEntry> gridEntries = InputReader.readInput("resource/day22.csv");
		DataGrid dataGrid = new DataGrid(gridEntries);
		System.out.println("Viable Pairs:" + dataGrid.getViablePairs());
	}
}
