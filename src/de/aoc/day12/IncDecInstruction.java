package de.aoc.day12;

public class IncDecInstruction extends BaseInstruction {
	private String targetRegister;

	public IncDecInstruction(String command, String targetRegister) {
		super(command);
		this.targetRegister = targetRegister;
	}

	public String getTargetRegister() {
		return targetRegister;
	}

	public void setTargetRegister(String targetRegister) {
		this.targetRegister = targetRegister;
	}

	@Override
	public String toString() {
		return "IncDecInstruction [targetRegister=" + targetRegister
				+ ", command=" + command + "]";
	}
}
