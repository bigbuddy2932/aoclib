package net.benjaneer.aoc.lib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class SpecialMathTest {
	@Test
	public void factorEasyTest() {
		Map<Integer, Integer> result = SpecialMath.factors(1);
		assertEquals(1, result.size());
		assertTrue(result.containsKey(1));
		assertEquals(1, result.get(1).intValue());
		result = SpecialMath.factors(0);
		assertEquals(1, result.size());
		assertTrue(result.containsKey(0));
		assertEquals(1, result.get(0).intValue());
		result = SpecialMath.factors(2);
		assertEquals(1, result.size());
		assertTrue(result.containsKey(2));
		assertEquals(1, result.get(2).intValue());
	}
	@Test
	public void factorPrimeTest() {
		Map<Integer, Integer> result = SpecialMath.factors(11);
		assertEquals(1, result.size());
		assertTrue(result.containsKey(11));
		result = SpecialMath.factors(Integer.MAX_VALUE);
		assertEquals(1, result.size());
		assertTrue(result.containsKey(Integer.MAX_VALUE));
	}
	@Test
	public void factorMultiTest() {
		Map<Integer, Integer> result = SpecialMath.factors(12);
		assertEquals(2, result.size());
		assertTrue(result.containsKey(2));
		assertTrue(result.containsKey(3));
		assertEquals(2, result.get(2).intValue());
		assertEquals(1, result.get(3).intValue());result = SpecialMath.factors(100);
		assertEquals(2, result.size());
		assertTrue(result.containsKey(2));
		assertTrue(result.containsKey(5));
		assertEquals(2, result.get(2).intValue());
		assertEquals(2, result.get(5).intValue());
	}
	@Test
	public void gcdTest() {
		assertEquals(1, SpecialMath.gcd(1, 100));
		assertEquals(0, SpecialMath.gcd(1, 100, 0));
		assertEquals(2, SpecialMath.gcd(4, 6));
		assertEquals(6, SpecialMath.gcd(24, 30, 36));
		assertEquals(32, SpecialMath.gcd(128, 96));
		assertEquals(18, SpecialMath.gcd(36, 54, 90));
	}
	@Test
	public void fullHashTest() {
		assertEquals("E8816B51E183BA3584D8DBCFC1457DFFB4CD114EB3CD30735CC50BE9ABEF3DB0",
				SpecialMath.bytesToHex(SpecialMath.hash("abc3231929", "sha-256")));
		assertEquals("C9CFC9943801DAFC36B556AC26126A44FEC988AD",
				SpecialMath.bytesToHex(SpecialMath.hash("abc3231929", "sha-1")));
		assertEquals("00000155F8105DFF7F56EE10FA9B9ABD",
				SpecialMath.bytesToHex(SpecialMath.hash("abc3231929", "md5")));
		assertNull(SpecialMath.hash("abc3231929", "notAnAlgo"));
	}
}
