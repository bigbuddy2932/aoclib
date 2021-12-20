package net.benjaneer.aoc.lib.geometry;

import java.math.BigInteger;

public class BigPoint implements Comparable<BigPoint>, Cloneable {
	public BigInteger x, y;
	public BigPoint(int x, int y) {
		this.x = new BigInteger(Integer.toString(x));
		this.y = new BigInteger(Integer.toString(y));
	}
	public BigPoint(BigInteger x, BigInteger y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object o) {
		if(o instanceof BigPoint) {
			BigPoint c = (BigPoint) o;
			return c.x.equals(x) && c.y.equals(y);
		}
		return false;
	}
	//Probably best to avoid using hash-objects on this class, collisions are just too likely
	public int hashCode() {
		int o = 37;
		for(int i = 0; i < 3; i++)
			o *= x.toString().hashCode() * y.toString().hashCode();
		return o;
	}
	public BigInteger manhattanDist() {
		return x.abs().add(y.abs());
	}
	public int compareTo(BigPoint c) {
		if(x.equals(c.x)) {
			return y.compareTo(c.y);
		}
		return x.compareTo(c.x);
	}
	public BigPoint clone() {
		return new BigPoint(new BigInteger(x.toString()), new BigInteger(y.toString()));
	}
	public static BigPoint promote(Point p) {
		return new BigPoint(new BigInteger(p.x + ""), new BigInteger(p.y + ""));
	}
}
