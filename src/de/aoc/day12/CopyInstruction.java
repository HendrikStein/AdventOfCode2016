package de.aoc.day12;

public class CopyInstruction extends BaseInstruction {
	private String targetRegister;
	private String copyFromRegister;
	private int value;

	public CopyInstruction(String command, int value, String targetRegister) {
		super(command);
		this.targetRegister = targetRegister;
		this.value = value;
	}

	public CopyInstruction(String command, String targetRegister,
			String copyFromRegister) {
		super(command);
		this.targetRegister = targetRegister;
		this.copyFromRegister = copyFromRegister;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getTargetRegister() {
		return targetRegister;
	}

	public void setTargetRegister(String targetRegister) {
		this.targetRegister = targetRegister;
	}

	public String getCopyFromRegister() {
		return copyFromRegister;
	}

	public void setCopyFromRegister(String copyFromRegister) {
		this.copyFromRegister = copyFromRegister;
	}

	@Override
	public String toString() {
		return "CopyInstruction [targetRegister=" + targetRegister
				+ ", copyFromRegister=" + copyFromRegister + ", value=" + value
				+ ", command=" + command + "]";
	}
}
