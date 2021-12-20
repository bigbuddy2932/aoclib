package net.benjaneer.aoc.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GeneralUtil {
	public static <T> boolean arrContains(T search, T[] arr) {
		for(T i : arr)
			if(i.equals(search))
				return true;
		return false;
	}
	public static boolean arrContains(char search, char[] arr) {
		for(char i : arr)
			if(i == search)
				return true;
		return false;
	}
	public static List<String> dupe(List<String> in){
		List<String> o = new ArrayList<String>();
		for(String i : in) {
			o.add(i);
		}
		return o;
	}
	public static Set<String> dupe(Set<String> in){
		Set<String> o = new TreeSet<String>();
		for(String i : in) {
			o.add(i);
		}
		return o;
	}
}
