package net.benjaneer.aoc.lib.geometry;

public class Point implements Comparable<Point>, Cloneable  {
	public int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object o) {
		if(o instanceof Point) {
			Point c = (Point) o;
			return c.x == x && c.y == y;
		}
		return false;
	}
	public int hashCode() {
		int o = 37;
		for(int i = 0; i < 3; i++) {
			o *= Integer.toString(x).hashCode() * Integer.toString(y).hashCode();
		}
		return o;
	}
	public int manhattanDist() {
		return Math.abs(x) + Math.abs(y);
	}
	public int compareTo(Point c) {
		if(x == c.x) {
			return y < c.y ? -1 : y == c.y ? 0 : 1;
		}
		return x < c.x ? -1 : 1;
	}
	public Point clone() {
		return new Point(x, y);
	}
}
