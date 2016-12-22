package de.aoc.day9;

public class Marker {
	private int nextChars;
	private int repeat;

	public Marker(int nextChars, int repeat) {
		this.nextChars = nextChars;
		this.repeat = repeat;
	}

	public int getNextChars() {
		return nextChars;
	}

	public int getRepeat() {
		return repeat;
	}
	
	@Override
	public String toString() {
		return "Marker [nextChars=" + nextChars + ", repeat=" + repeat + "]";
	}

}
