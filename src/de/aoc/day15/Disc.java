package de.aoc.day15;

public class Disc {
	private int number;
	private int amountOfPositions;
	private int currentPosition;
	private int currentTime;

	public Disc(int number, int amountOfPositions, int currentPosition) {
		this.number = number;
		this.amountOfPositions = amountOfPositions;
		this.currentPosition = currentPosition;
		this.currentTime = 0;
	}

	public boolean hasRightPosition(int time) {
		int sum = time + this.number + this.currentPosition;
		if (sum % this.amountOfPositions == 0) {
			return true;
		}
		return false;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	// public boolean hasRightPosition(int time) {
	// int sum = this.currentPosition + time + this.number;
	// if (sum % this.amountOfPositions == 1) {
	// return true;
	// }
	// return false;
	// }

}
