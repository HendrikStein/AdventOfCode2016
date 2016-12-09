package de.aoc.day8;

public class RotationInstruction {
	private int rotationEntry;
	private int rotationStep;
	private Character axis;

	public RotationInstruction(Character axis, int rotationEntry,
			int rotationStep) {
		this.rotationEntry = rotationEntry;
		this.rotationStep = rotationStep;
		this.axis = axis;
	}

	public int getRotationEntry() {
		return rotationEntry;
	}

	public int getRotationStep() {
		return rotationStep;
	}

	public Character getAxis() {
		return axis;
	}

	@Override
	public String toString() {
		return "RotationInstruction [rotationEntry=" + rotationEntry
				+ ", rotationStep=" + rotationStep + ", axis=" + axis + "]";
	}

}
