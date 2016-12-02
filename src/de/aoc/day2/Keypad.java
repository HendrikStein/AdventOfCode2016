package de.aoc.day2;

public class Keypad {

	private class Index {
		int x;
		int y;

		public Index(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	private Character[][] surface;
	private Index index;

	public Keypad(Character[][] surface, int startX, int startY){
		this.index = new Index(startY, startX);
		this.surface = surface;
	}
	
	public String enterInstructionChain(InstructionChain instructions) {

		for (Character instruction : instructions.getMoves()) {
			this.enter(instruction);
		}
		return this.surface[index.getY()][index.getX()].toString();
	}

	private void enter(Character instruction) {
		switch (instruction) {
		case 'U':
			this.moveUp(instruction);
			break;
		case 'D':
			this.moveDown(instruction);
			break;
		case 'L':
			this.moveLeft(instruction);
			break;
		case 'R':
			this.moveRight(instruction);
			break;
		default:
			break;
		}
	}

	private void moveUp(Character instruction) {
		int y = this.index.getY() - 1;

		if (y >= 0 && this.surface[y][index.getX()] != null) {
			this.index.setY(y);
		}
	}

	private void moveDown(Character instruction) {
		int y = this.index.getY() + 1;

		if (y < this.surface.length && this.surface[y][index.getX()] != null) {
			this.index.setY(y);
		}
	}

	private void moveRight(Character instruction) {
		int x = this.index.getX() + 1;

		if (x < this.surface.length && this.surface[this.index.getY()][x] != null) {
			this.index.setX(x);
		}
	}

	private void moveLeft(Character instriction) {
		int x = this.index.getX() -1 ;

		if (x >= 0 && this.surface[this.index.getY()][x] != null) {
			this.index.setX(x);
		}
	}
}
