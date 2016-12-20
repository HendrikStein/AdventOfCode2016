package de.aoc.day15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws IOException {
		Runner runner = new Runner();
		List<Disc> discs = runner.initDiscsPart1();
		runner.runFor(discs);

		discs = runner.initDiscsPart2();
		runner.runFor(discs);
	}

	private void runFor(List<Disc> discs) {
		int time = 0;
		while (true) {
			if (this.hasValidPositions(discs, time)) {
				System.out.println(time);
				return;
			}
			time++;
		}
	}

	private List<Disc> initDiscsPart1() {
		ArrayList<Disc> discs = new ArrayList<>();
		// discs.add(new Disc(1, 5, 4));
		// discs.add(new Disc(2, 2, 1));

		discs.add(new Disc(1, 17, 1));
		discs.add(new Disc(2, 7, 0));
		discs.add(new Disc(3, 19, 2));
		discs.add(new Disc(4, 5, 0));
		discs.add(new Disc(5, 3, 0));
		discs.add(new Disc(6, 13, 5));
		return discs;
	}

	private List<Disc> initDiscsPart2() {
		ArrayList<Disc> discs = new ArrayList<>();

		discs.add(new Disc(1, 17, 1));
		discs.add(new Disc(2, 7, 0));
		discs.add(new Disc(3, 19, 2));
		discs.add(new Disc(4, 5, 0));
		discs.add(new Disc(5, 3, 0));
		discs.add(new Disc(6, 13, 5));
		discs.add(new Disc(7, 11, 0));
		return discs;
	}

	private boolean hasValidPositions(List<Disc> discs, int time) {
		for (Disc disc : discs) {
			if (!disc.hasRightPosition(time)) {
				return false;
			}
		}
		return true;
	}
}
