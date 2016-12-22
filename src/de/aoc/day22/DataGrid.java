package de.aoc.day22;

import java.util.Arrays;
import java.util.List;

public class DataGrid {
	private List<GridEntry> gridEntries;
	Node[][] grid = new Node[35][30];

	public DataGrid(List<GridEntry> gridEntries) {
		this.gridEntries = gridEntries;
		this.init();
	}

	public int getViablePairs() {
		int viablePairs = 0;
		for (int y = 0; y < this.grid.length; y++) {
			for (int x = 0; x < this.grid[y].length; x++) {
				viablePairs += this.checkPairForNode(this.grid[y][x]);
			}
		}
		return viablePairs;
	}

	private int checkPairForNode(Node node) {
		int viablePairs = 0;
		for (int y = 0; y < this.grid.length; y++) {
			for (int x = 0; x < this.grid[y].length; x++) {
				Node nodeToCompare = this.grid[y][x];
				if (!node.equals(nodeToCompare) && node.getUsed() > 0 && node.getUsed() <= nodeToCompare.getAvail()) {
					viablePairs++;
				}
			}
		}
		return viablePairs;
	}

	private void init() {
		for (GridEntry entry : this.gridEntries) {
			grid[entry.getY()][entry.getX()] = entry.getNode();
		}
	}

	public void show() {
		for (int y = 0; y < this.grid.length; y++) {
			System.out.println(y + "." + Arrays.toString(this.grid[y]));
		}
	}

}
