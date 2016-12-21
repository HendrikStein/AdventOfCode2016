package de.aoc.day21;

import java.util.ArrayList;
import java.util.List;

public class Scrambler {

	List<String> input;
	String stringToScramble;

	public Scrambler(String stringToScramble, List<String> input) {
		this.input = input;
		this.stringToScramble = stringToScramble;
	}

	private List<String> reverseInstructions() {
		List<String> reverseInput = new ArrayList<>(this.input.size());
		for (int i = this.input.size() - 1; i >= 0; i--) {
			reverseInput.add(this.input.get(i));
		}
		return reverseInput;
	}

	public String unscramble() {
		this.input = this.reverseInstructions();
		this.input.forEach(instruction -> {
			if (instruction.contains("swap") && instruction.contains("position")) {
				this.swapPosition(instruction);
			} else if (instruction.contains("swap") && instruction.contains("letter")) {
				this.swapLetter(instruction);
			} else if (instruction.contains("rotate") && instruction.contains("based")) {
				this.rotatePositionUnscramble(instruction);
			} else if (instruction.contains("rotate")) {
				this.rotateDirection(instruction, false);
			} else if (instruction.contains("reverse")) {
				this.reversePosition(instruction);
			} else if (instruction.contains("move")) {
				this.movePosition(instruction, false);
			} else {
				System.out.println("Unknown instruction");
			}
		});
		return this.stringToScramble;
	}

	public String scramble() {
		this.input.forEach(instruction -> {
			if (instruction.contains("swap") && instruction.contains("position")) {
				this.swapPosition(instruction);
			} else if (instruction.contains("swap") && instruction.contains("letter")) {
				this.swapLetter(instruction);
			} else if (instruction.contains("rotate") && instruction.contains("based")) {
				this.stringToScramble = this.rotatePosition(instruction, this.stringToScramble);
			} else if (instruction.contains("rotate")) {
				this.rotateDirection(instruction, true);
			} else if (instruction.contains("reverse")) {
				this.reversePosition(instruction);
			} else if (instruction.contains("move")) {
				this.movePosition(instruction, true);
			} else {
				System.out.println("Unknown instruction");
			}
		});
		return this.stringToScramble;
	}

	private void swapPosition(String instruction) {
		String[] parts = instruction.split(" ");
		int index1 = Integer.parseInt(parts[2]);
		int index2 = Integer.parseInt(parts[5]);
		this.stringToScramble = this.swapIndex(index1, index2);
	}

	private String swapIndex(int i1, int i2) {
		StringBuilder builder = new StringBuilder(this.stringToScramble);
		Character value1 = this.stringToScramble.charAt(i1);
		Character value2 = this.stringToScramble.charAt(i2);
		builder.setCharAt(i2, value1);
		builder.setCharAt(i1, value2);
		return builder.toString();
	}

	private void swapLetter(String instruction) {
		String[] parts = instruction.split(" ");
		String letter1 = parts[2];
		String letter2 = parts[5];
		this.stringToScramble = this.swapIndex(this.stringToScramble.indexOf(letter1),
				this.stringToScramble.indexOf(letter2));
	}

	private void rotateDirection(String instruction, boolean scramble) {
		String[] parts = instruction.split(" ");
		int steps = Integer.parseInt(parts[2]);
		String dir = parts[1];

		if (!scramble && dir.equals("right")) {
			dir = "left";
		} else if (!scramble && dir.equals("left")) {
			dir = "right";
		}

		if (dir.equals("right")) {
			this.stringToScramble = this.rotateRight(steps, this.stringToScramble);
		} else {
			this.stringToScramble = this.rotateLeft(steps, this.stringToScramble);
		}
	}

	private String rotateLeft(int steps, String stringToScramble) {
		String rotatedString = stringToScramble;
		for (int i = 0; i < steps; i++) {
			rotatedString = stringToScramble.substring(1, stringToScramble.length());
			rotatedString += stringToScramble.charAt(0);
			stringToScramble = rotatedString;
		}
		return stringToScramble;
	}

	private String rotateRight(int steps, String stringToScramble) {
		String rotatedString = stringToScramble;
		for (int i = 0; i < steps; i++) {
			rotatedString = stringToScramble.charAt(stringToScramble.length() - 1)
					+ stringToScramble.substring(0, stringToScramble.length() - 1);
			stringToScramble = rotatedString;
		}
		return stringToScramble;
	}

	private String rotatePosition(String instruction, String stringToScramble) {
		String[] parts = instruction.split(" ");
		String letter = parts[6];
		int rotationSteps = 0;
		rotationSteps = 1 + stringToScramble.indexOf(letter);
		if (stringToScramble.indexOf(letter) >= 4) {
			rotationSteps++;
		}
		return this.rotateRight(rotationSteps, stringToScramble);
	}

	private void rotatePositionUnscramble(String instruction) {
		for (int i = 0; i < this.stringToScramble.length(); i++) {
			String leftRotatedString = this.rotateLeft(i, this.stringToScramble);
			if (this.stringToScramble.equals(this.rotatePosition(instruction, leftRotatedString))) {
				this.stringToScramble = leftRotatedString;
				break;
			}
		}
	}

	private void reversePosition(String instruction) {
		String[] parts = instruction.split(" ");
		int index1 = Integer.parseInt(parts[2]);
		int index2 = Integer.parseInt(parts[4]);
		StringBuilder builder = new StringBuilder();
		if (index1 > 0) {
			builder.append(this.stringToScramble.substring(0, index1));
		}

		for (int i = index2; i >= index1; i--) {
			builder.append(this.stringToScramble.charAt(i));
		}

		if (index2 < this.stringToScramble.length() - 1) {
			builder.append(this.stringToScramble.substring(index2 + 1, this.stringToScramble.length()));
		}
		this.stringToScramble = builder.toString();
	}

	private void movePosition(String instruction, boolean scramble) {
		StringBuilder builder = new StringBuilder();
		String[] parts = instruction.split(" ");
		int from = Integer.parseInt(parts[2]);
		int to = Integer.parseInt(parts[5]);
		if (!scramble) {
			from = Integer.parseInt(parts[5]);
			to = Integer.parseInt(parts[2]);
		}
		for (int i = 0; i < this.stringToScramble.length(); i++) {
			if (i == from) {
				continue;
			}
			if (from < to) {
				builder.append(this.stringToScramble.charAt(i));
			}
			if (i == to) {
				builder.append(this.stringToScramble.charAt(from));
			}
			if (from > to) {
				builder.append(this.stringToScramble.charAt(i));
			}

		}
		this.stringToScramble = builder.toString();
	}
}
