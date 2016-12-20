package de.aoc.day19;

/**
 * 
 * https://de.wikipedia.org/wiki/Josephus-Problem
 *
 */
public class Runner {
	public static void main(String[] args) {
		Runner runner = new Runner();
		System.out.println(runner.passPresentsPart1(3004953));
		System.out.println(runner.passPresentsPart2(3004953));
	}

	private int passPresentsPart2(int n) {

		Double lowerExponent = Math.floor(Math.log(n) / Math.log(3));
		Double upperExponent = lowerExponent + 1;

		Double lower = Math.pow(3, lowerExponent);
		Double upper = Math.pow(3, upperExponent);
		int ans;
		if (n == lower.intValue()) {
			ans = n;
		} else if (n <= lower.intValue() * 2) {
			ans = n - lower.intValue();
		} else {
			ans = upper.intValue() - (upper.intValue() - n) * 2;
		}
		return ans;
	}

	private int passPresentsPart1(int n) {
		if (n == 1) {
			return 1;
		}

		else if ((n % 2) == 0) {
			return 2 * passPresentsPart1(n / 2) - 1;
		}

		else if ((n % 2) == 1) {
			return 2 * passPresentsPart1((n - 1) / 2) + 1;
		}
		return 0;
	}

}
