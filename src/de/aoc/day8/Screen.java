package de.aoc.day8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Screen {
	private String[][] display = new String[6][50];

	private BiFunction<String, Integer, String[][]> copyColumnFn = (columnValue, column) -> {
		for (int y = 0; y < columnValue.length(); y++) {
			this.display[y][column] = String.valueOf(columnValue.charAt(y));
		}
		return this.display;
	};

	private BiFunction<String, Integer, String[][]> copyRowFn = (rowValue, row) -> {
		for (int x = 0; x < rowValue.length(); x++) {
			this.display[row][x] = String.valueOf(rowValue.charAt(x));
		}
		return this.display;
	};

	public Screen() {
		this.initialize();
	}

	public void executeInstruction(InstructionChain chain) {
		this.createRect(chain.getWide(), chain.getTall());
		this.rotate(chain.getRotations());
	}

	private void rotate(RotationInstruction instruction) {
		if (instruction.getAxis().equals('y')) {
			this.rotateColumn(instruction);
		} else if (instruction.getAxis().equals('x')) {
			this.rotateRow(instruction);
		}
	}

	private void rotateRow(RotationInstruction instruction) {
		StringBuilder builder = new StringBuilder();
		for (int step = 0; step < instruction.getRotationStep(); step++) {
			builder.append(" ");
		}
		String row = this.getRow(instruction.getRotationEntry());
		String rotationRow = builder.toString() + row;
		// Copy new Column
		this.display = this.copyRowFn.apply(rotationRow.substring(0, row.length()), instruction.getRotationEntry());
		// Copy fallofPixels
		this.copyFallOffPixel(rotationRow.substring(row.length(), rotationRow.length()), row.length(),
				instruction.getRotationEntry(), this.copyRowFn);

	}

	private String getColumn(int column) {
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < this.display.length; x++) {
			builder.append(this.display[x][column]);
		}
		return builder.toString();
	}

	private String getRow(int row) {
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < this.display[row].length; x++) {
			builder.append(this.display[row][x]);
		}
		return builder.toString();
	}

	private void rotateColumn(RotationInstruction instruction) {
		StringBuilder builder = new StringBuilder();
		for (int step = 0; step < instruction.getRotationStep(); step++) {
			builder.append(" ");
		}
		String column = this.getColumn(instruction.getRotationEntry());
		String rotationColumn = builder.toString() + column;
		// Copy new Column
		this.display = this.copyColumnFn.apply(rotationColumn.substring(0, column.length()),
				instruction.getRotationEntry());
		// Copy fallofPixels
		this.copyFallOffPixel(rotationColumn.substring(column.length(), rotationColumn.length()), column.length(),
				instruction.getRotationEntry(), this.copyColumnFn);
	}

	private void copyFallOffPixel(String fallOffPixel, int length, int rotationEntry,
			BiFunction<String, Integer, String[][]> copyFn) {
		int rest = fallOffPixel.length() % length;
		if (rest > 0) {
			this.display = copyFn.apply(fallOffPixel.substring(fallOffPixel.length() - rest, fallOffPixel.length()),
					rotationEntry);
			if (fallOffPixel.length() > length) {
				this.display = copyFn.apply(
						fallOffPixel.substring(fallOffPixel.length() - (rest + length), fallOffPixel.length() - rest),
						rotationEntry);
			}
		} else {
			this.display = copyFn.apply(fallOffPixel.substring(fallOffPixel.length() - length, fallOffPixel.length()),
					rotationEntry);
		}
	}

	private void createRect(int wide, int tall) {
		for (int t = 0; t < tall; t++) {
			for (int w = 0; w < wide; w++) {
				this.display[t][w] = "#";
			}
		}
	}

	private void rotate(List<RotationInstruction> rotations) {
		for (RotationInstruction instruction : rotations) {
			this.rotate(instruction);
		}
	}

	private void initialize() {
		for (int x = 0; x < this.display.length; x++) {
			for (int y = 0; y < this.display[x].length; y++) {
				this.display[x][y] = " ";
			}
		}
	}

	public int countPixlesToLit() {
		int amount = 0;
		for (int x = 0; x < this.display.length; x++) {
			for (int y = 0; y < this.display[x].length; y++) {
				if (this.display[x][y].equals("#")) {
					amount++;
				}
			}
		}
		return amount;
	}

	public void display() {
		for (int y = 0; y < this.display.length; y++) {
			System.out.println(Arrays.toString(this.display[y]));
		}
		System.out.println("\n");
	}
}
