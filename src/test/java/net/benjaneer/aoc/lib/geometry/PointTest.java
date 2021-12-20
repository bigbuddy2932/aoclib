package net.benjaneer.aoc.lib.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.Test;

import net.benjaneer.aoc.lib.geometry.BigPoint;
import net.benjaneer.aoc.lib.geometry.Point;

public class PointTest {
	@Test
	public void dataTest() {
		Point p = new Point(43, -453);
		assertEquals(43, p.x);
		assertEquals(-453, p.y);
		BigPoint bp = new BigPoint(43, -453);
		assertEquals(new BigInteger("43"), bp.x);
		assertEquals(new BigInteger("-453"), bp.y);
	}
	@Test
	public void treeSetTest() {
		TreeSet<Point> ts = new TreeSet<Point>();
		ts.add(new Point(-5, 1));
		ts.add(new Point(0, 0));
		ts.add(new Point(Integer.MAX_VALUE, 1));
		ts.add(new Point(0, 4));
		ts.add(new Point(0, 0));
		assertEquals(4, ts.size());
		assertTrue(ts.contains(new Point(0, 4)));
		assertFalse(ts.contains(new Point(-1, 4)));
		ts.add(new Point(0, -56));
		ts.add(new Point(0, 66));
		ts.add(new Point(-1, 4));
		ts.remove(new Point(0, 4));
		assertEquals(6, ts.size());
		assertFalse(ts.contains(new Point(0, 4)));
		assertTrue(ts.contains(new Point(-1, 4)));
		
		TreeSet<BigPoint> bts = new TreeSet<BigPoint>();
		bts.add(new BigPoint(-5, 1));
		bts.add(new BigPoint(0, 0));
		bts.add(new BigPoint(Integer.MAX_VALUE, 1));
		bts.add(new BigPoint(0, 4));
		bts.add(new BigPoint(0, 0));
		assertEquals(4, bts.size());
		assertTrue(bts.contains(new BigPoint(0, 4)));
		assertFalse(bts.contains(new BigPoint(-1, 4)));
		bts.add(new BigPoint(0, -56));
		bts.add(new BigPoint(0, 66));
		bts.add(new BigPoint(-1, 4));
		bts.remove(new BigPoint(0, 4));
		assertEquals(6, bts.size());
		assertFalse(bts.contains(new BigPoint(0, 4)));
		assertTrue(bts.contains(new BigPoint(-1, 4)));
	}
	@Test
	public void hashSetTest() {
		HashSet<Point> ts = new HashSet<Point>();
		ts.add(new Point(-5, 1));
		ts.add(new Point(0, 0));
		ts.add(new Point(Integer.MAX_VALUE, 1));
		ts.add(new Point(0, 4));
		ts.add(new Point(0, 0));
		assertEquals(4, ts.size());
		assertTrue(ts.contains(new Point(0, 4)));
		assertFalse(ts.contains(new Point(-1, 4)));
		ts.add(new Point(0, -56));
		ts.add(new Point(0, 66));
		ts.add(new Point(-1, 4));
		ts.remove(new Point(0, 4));
		assertEquals(6, ts.size());
		assertFalse(ts.contains(new Point(0, 4)));
		assertTrue(ts.contains(new Point(-1, 4)));
		
		HashSet<BigPoint> bts = new HashSet<BigPoint>();
		bts.add(new BigPoint(-5, 1));
		bts.add(new BigPoint(0, 0));
		bts.add(new BigPoint(Integer.MAX_VALUE, 1));
		bts.add(new BigPoint(0, 4));
		bts.add(new BigPoint(0, 0));
		assertEquals(4, bts.size());
		assertTrue(bts.contains(new BigPoint(0, 4)));
		assertFalse(bts.contains(new BigPoint(-1, 4)));
		bts.add(new BigPoint(0, -56));
		bts.add(new BigPoint(0, 66));
		bts.add(new BigPoint(-1, 4));
		bts.remove(new BigPoint(0, 4));
		assertEquals(6, bts.size());
		assertFalse(bts.contains(new BigPoint(0, 4)));
		assertTrue(bts.contains(new BigPoint(-1, 4)));
	}
	@Test
	public void cloneTest() {
		Point p1 = new Point(4, 85);
		Point p2 = p1.clone();
		assertEquals(p1, p2);
		p2.x = 5;
		assertNotEquals(p1, p2);
		assertEquals(4, p1.x);
		assertEquals(85, p1.y);
		assertEquals(5, p2.x);
		assertEquals(85, p2.y);
		
		BigPoint bp1 = new BigPoint(new BigInteger("4"), new BigInteger("85"));
		BigPoint bp2 = bp1.clone();
		assertEquals(bp1, bp2);
		bp2.x = new BigInteger("5");
		assertNotEquals(bp1, bp2);
		assertEquals(new BigInteger("4"), bp1.x);
		assertEquals(new BigInteger("85"), bp1.y);
		assertEquals(new BigInteger("5"), bp2.x);
		assertEquals(new BigInteger("85"), bp2.y);
	}
	@Test
	public void manhattanTest() {
		assertEquals(89, new Point(4, -85).manhattanDist());
		assertEquals(new BigInteger("89"), new BigPoint(4, -85).manhattanDist());
	}
	@SuppressWarnings("unlikely-arg-type")//part of the point of the test
	@Test
	public void equalityTest() {
		assertFalse(new Point(0, 0).equals(""));
		assertFalse(new BigPoint(0, 0).equals(""));
		assertFalse(new Point(0, 0).equals(new Point(1, 0)));
		assertFalse(new Point(0, 0).equals(new Point(0, 1)));
		assertTrue(new Point(0, 0).equals(new Point(0, 0)));
		assertFalse(new BigPoint(0, 0).equals(new BigPoint(1, 0)));
		assertFalse(new BigPoint(0, 0).equals(new BigPoint(0, 1)));
		assertTrue(new BigPoint(0, 0).equals(new BigPoint(0, 0)));
	}
}
