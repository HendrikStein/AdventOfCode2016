package de.aoc.day8;

import java.util.ArrayList;
import java.util.List;

public class InstructionChain {
	int wide;
	int tall;
	List<RotationInstruction> rotations = new ArrayList<>();

	public InstructionChain(int wide, int tall) {
		this.wide = wide;
		this.tall = tall;
	}

	public void addRotationInstruction(Character axis, int rotationEntry,
			int rotationStep) {
		this.rotations.add(new RotationInstruction(axis, rotationEntry,
				rotationStep));
	}

	public int getWide() {
		return wide;
	}

	public int getTall() {
		return tall;
	}

	public List<RotationInstruction> getRotations() {
		return rotations;
	}
	
}
