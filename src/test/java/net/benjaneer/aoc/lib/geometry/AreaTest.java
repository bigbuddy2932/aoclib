package net.benjaneer.aoc.lib.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AreaTest {
	@Test
	public void containTest() {
		BigPoint a = new BigPoint(43, -458);
		BigPoint b = new BigPoint(46, -452);
		Area t = new Area(a, b);
		assertTrue(t.containsPoint(a));
		assertTrue(t.containsPoint(b));
		assertTrue(t.containsPoint(new Point(44, -457)));
		assertFalse(t.containsPoint(new Point(300, -457)));
		assertFalse(t.containsPoint(new Point(44, 457)));
		assertFalse(t.containsPoint(new Point(0, 0)));
	}
	@Test
	public void normalizeTest() {
		Area t = new Area(new BigPoint(43, -452), new BigPoint(46, -458));
		assertNotEquals(t, t.normalisePoints());
		assertEquals(new Area(new BigPoint(43, -458), new BigPoint(46, -452)),
				t.normalisePoints());
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void equalTest() {
		Area t = new Area(new BigPoint(43, -452), new BigPoint(46, -458));
		assertFalse(t.equals(new Area(new BigPoint(0, 0), new BigPoint(1, 1))));
		assertTrue(t.equals(new Area(new BigPoint(43, -452), new BigPoint(46, -458))));
		assertFalse(t.equals("incorrect type"));
		Area tw = t.clone();
		assertFalse(tw == t);
		assertTrue(tw.equals(t));
	}
}
