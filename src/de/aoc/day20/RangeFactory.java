package de.aoc.day20;

public class RangeFactory implements IRangeFactory {

	@Override
	public Range toObject(String inst) {
		String[] range = inst.split("-");
		return new Range(Long.parseLong(range[0]), Long.parseLong(range[1]));
	}
}
