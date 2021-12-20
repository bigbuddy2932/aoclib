package net.benjaneer.aoc.lib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SpecialMath {
	public static int gcd(int... in) {
		for(int i : in) {
			if(i == 0) {
				return 0;
			}
		}
		Map<Integer, Integer> factors = factors(in[0]);
		for(int i = 1; i < in.length; i++) {
			Map<Integer, Integer> newFactors = new TreeMap<Integer, Integer>();
			for(Entry<Integer, Integer> j : factors(in[i]).entrySet()) {
				if(factors.containsKey(j.getKey())) {
					newFactors.put(j.getKey(), Math.min(j.getValue(), factors.get(j.getKey())));
				}
			}
			factors = newFactors;
		}
		int o = 1;
		for(Entry<Integer, Integer> i : factors.entrySet()) {
			for(int j = 0; j < i.getValue(); j++) {
				o *= i.getKey();
			}
		}
		return o;
	}
	public static Map<Integer, Integer> factors(int i){
		Map<Integer, Integer> o = new TreeMap<Integer, Integer>();
		if(i == 1 || i == 0) {
			o.put(i, 1);
			return o;
		}
		int bi = i;
		int max = (int) Math.sqrt(i);
		for(int f = 2; f <= max; f++) {
			if(i % f == 0) {
				MapUtil.incrementMap(f, o);
				i /= f;
				f--;
			}
		}
		if(i == bi) {
			MapUtil.incrementMap(i, o);
			i = 1;
		}
		return o;
	}
	public static byte[] hash(String i, String algo) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(algo.toUpperCase());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		return md.digest(i.getBytes());
	}
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
}
