package de.aoc.day1;

import java.util.ArrayList;
import java.util.List;

public class Point {
	private int x = 0;
	private int y = 0;
	private Orientation orientation = Orientation.NORTH;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
	}

	public List<Point> incrementXBy(int value) {
		List<Point> steps = new ArrayList<>();
		if (Integer.signum(value) == -1) {
			this.orientation = Orientation.WEST;
		} else if (Integer.signum(value) == 1) {
			this.orientation = Orientation.EAST;
		}
		for (int i = this.x; i <= value; i++) {
			steps.add(new Point(i, this.y));
		}
		this.x += value;
		return steps;
	}

	public List<Point> incrementYBy(int value) {
		List<Point> steps = new ArrayList<>();
		if (Integer.signum(value) == -1) {
			this.orientation = Orientation.SOUTH;
		} else if (Integer.signum(value) == 1) {
			this.orientation = Orientation.NORTH;
		}
		for (int i = this.y; i <= value; i++) {
			steps.add(new Point(this.x, i));
		}
		this.y += value;
		return steps;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + " " + (x + y) + " blocks away "
				+ " with orientation " + orientation + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
