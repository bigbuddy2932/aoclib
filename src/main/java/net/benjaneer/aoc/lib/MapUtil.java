package net.benjaneer.aoc.lib;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil {
	public static <T> void incrementMap(T o, Map<T, Integer> m) {
		if(m.containsKey(o))
			m.put(o, m.get(o) + 1);
		else
			m.put(o, 1);
	}
	public static <T> void incrementBigMap(T o, Map<T, BigInteger> m) {
		if(m.containsKey(o))
			m.put(o, m.get(o).add(BigInteger.ONE));
		else
			m.put(o, BigInteger.ONE);
	}
	public static <T> List<Map.Entry<T, Integer>> sortByValue(Map<T, Integer> m){
		List<Map.Entry<T, Integer>> o = new ArrayList<Map.Entry<T, Integer>>();
		for(Map.Entry<T, Integer> e : m.entrySet()) {
			boolean ins = false;
			for(int i = 0; i < o.size(); i++) {
				if(o.get(i).getValue() > e.getValue()) {
					o.add(i, e);
					ins = true;
					break;
				}
			}
			if(!ins) {
				o.add(e);
			}
		}
		return o;
	}
	public static <T> List<Map.Entry<T, BigInteger>> sortByBigValue(Map<T, BigInteger> m){
		List<Map.Entry<T, BigInteger>> o = new ArrayList<Map.Entry<T, BigInteger>>();
		for(Map.Entry<T, BigInteger> e : m.entrySet()) {
			boolean ins = false;
			for(int i = 0; i < o.size(); i++) {
				if(o.get(i).getValue().compareTo(e.getValue()) == 1) {
					o.add(i, e);
					ins = true;
					break;
				}
			}
			if(!ins) {
				o.add(e);
			}
		}
		return o;
	}
}
