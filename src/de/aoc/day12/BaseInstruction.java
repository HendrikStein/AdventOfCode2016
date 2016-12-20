package de.aoc.day12;

public class BaseInstruction {
	String command;
	
	
	public BaseInstruction(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "BaseInstruction [command=" + command + "]";
	}
}
