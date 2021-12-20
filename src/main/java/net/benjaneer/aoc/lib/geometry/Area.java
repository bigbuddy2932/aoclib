package net.benjaneer.aoc.lib.geometry;

import java.math.BigInteger;

public class Area implements Comparable<Area>, Cloneable  {
	public BigPoint a, b;
	public Area(Point a, Point b) {
		this.a = BigPoint.promote(a);
		this.b = BigPoint.promote(b);
	}
	public Area(BigPoint a, BigPoint b) {
		this.a = a;
		this.b = b;
	}
	public boolean containsPoint(Point p) {
		return containsPoint(BigPoint.promote(p));
	}
	public Area normalisePoints() {
		BigPoint negBound = a.clone(), posBound = b.clone();
		if(posBound.x.compareTo(negBound.x) == -1) {
			BigInteger s = negBound.x;
			negBound.x = posBound.x;
			posBound.x = s;
		}
		if(posBound.y.compareTo(negBound.y) == -1) {
			BigInteger s = negBound.y;
			negBound.y = posBound.y;
			posBound.y = s;
		}
		return new Area(negBound, posBound);
	}
	public boolean containsPoint(BigPoint p) {
		Area bounds = normalisePoints();
		return p.x.compareTo(bounds.a.x) != -1 && p.x.compareTo(bounds.b.x) != 1 &&
			   p.y.compareTo(bounds.a.y) != -1 && p.y.compareTo(bounds.b.y) != 1;
	}
	public Area clone() {
		return new Area(a.clone(), b.clone());
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Area) {
			Area compare = (Area) o;
			return compare.a.equals(this.a) && compare.b.equals(this.b);
		}
		return false;
	}
	@Override
	public int compareTo(Area i) {
		int o = this.a.compareTo(i.a);
		if(o == 0) {
			return this.b.compareTo(i.b);
		}
		return o;
	}
}
