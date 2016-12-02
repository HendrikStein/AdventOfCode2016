package de.aoc.day1;

public class Instruction {
	private Character direction;
	private int blocks;

	public Instruction() {
	}

	public Instruction(Character dir, int blocks) {
		this.direction = dir;
		this.blocks = blocks;
	}

	public Character getDirection() {
		return direction;
	}

	public int getBlocks() {
		return blocks;
	}
}
