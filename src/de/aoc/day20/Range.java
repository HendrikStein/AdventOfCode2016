package de.aoc.day20;

public class Range {
	long min;
	long max;

	public Range(long min, long max) {
		this.min = min;
		this.max = max;
	}

	public long getMin() {
		return min;
	}

	public long getMax() {
		return max;
	}

	@Override
	public String toString() {
		return "Range [min=" + min + ", max=" + max + "]";
	}

}
