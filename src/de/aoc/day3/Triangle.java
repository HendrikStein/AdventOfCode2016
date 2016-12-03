package de.aoc.day3;

public class Triangle {
	private int a, b, c;

	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public boolean isValid() {
		return this.a + this.b > this.c && this.a + this.c > this.b && this.b + this.c > this.a;
	}
}
