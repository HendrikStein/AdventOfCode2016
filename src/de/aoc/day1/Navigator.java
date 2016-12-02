package de.aoc.day1;

import java.util.ArrayList;
import java.util.List;

public class Navigator {

	private List<Instruction> instructions;
	private Point currentPoint = new Point();
	private List<Point> steps = new ArrayList<>();

	public Navigator(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public Point navigate() {
		this.instructions.forEach(this::move);
		return this.currentPoint;
	}

	public void move(Instruction instruction) {
		switch (this.getOrientationToMove(instruction)) {
		case NORTH:
			this.moveNorth(instruction.getBlocks());
			break;
		case SOUTH:
			this.moveSouth(instruction.getBlocks());
			break;
		case WEST:
			this.moveWest(instruction.getBlocks());
			break;
		case EAST:
			this.moveEast(instruction.getBlocks());
			break;
		default:
			System.out.println("I am lost with " + instruction.toString());
		}
	}

	private Orientation getOrientationToMove(Instruction instruction) {
		switch (currentPoint.getOrientation()) {
		case NORTH:
			return instruction.getDirection() == 'R' ? Orientation.EAST
					: Orientation.WEST;
		case SOUTH:
			return instruction.getDirection() == 'R' ? Orientation.WEST
					: Orientation.EAST;
		case WEST:
			return instruction.getDirection() == 'R' ? Orientation.NORTH
					: Orientation.SOUTH;
		case EAST:
			return instruction.getDirection() == 'R' ? Orientation.SOUTH
					: Orientation.NORTH;
		}
		return null;
	}

	private void moveNorth(int blocks) {
		this.intersect(this.currentPoint.incrementYBy(blocks));
	}

	private void moveSouth(int blocks) {
		blocks *= -1;
		this.intersect(this.currentPoint.incrementYBy(blocks));
	}

	private void moveWest(int blocks) {
		blocks *= -1;
		this.intersect(this.currentPoint.incrementXBy(blocks));
	}

	private void moveEast(int blocks) {
		this.intersect(this.currentPoint.incrementXBy(blocks));
	}

	private void intersect(List<Point> steps) {
		for (Point p : this.steps) {
			for (Point newP : steps) {
				if (newP.equals(p)) {
					System.out.println("Intersection at " + newP.toString());
				}
			}
		}
		this.steps.addAll(steps);
	}
}
