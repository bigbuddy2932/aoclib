package net.benjaneer.aoc.lib;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MapUtilTest {
	@Test
	public void sortValTest() {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		m.put(0, 6);
		m.put(1, 2);
		m.put(3, 767);
		m.put(4, 1);
		m.put(5, 6);
		m.put(6, 3);
		List<Map.Entry<Integer, Integer>> l = MapUtil.sortByValue(m);
		assertEquals(1, l.get(0).getValue().intValue());
		assertEquals(2, l.get(1).getValue().intValue());
		assertEquals(3, l.get(2).getValue().intValue());
		assertEquals(6, l.get(3).getValue().intValue());
		assertEquals(6, l.get(4).getValue().intValue());
		assertEquals(767, l.get(5).getValue().intValue());
	}
}
