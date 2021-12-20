package net.benjaneer.aoc.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMatcher {
	public static List<Matcher> readInput(final Pattern p, final String file){
		ArrayList<Matcher> ms = new ArrayList<Matcher>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))){
			String line; 
			while ((line = br.readLine()) != null) {
				Matcher m = p.matcher(line);
				if(m.matches())
					ms.add(m);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return ms;
	}
	public static List<List<String>> readCsvInput(final String file){
		return readCsvInput(file, ',');
	}
	public static List<List<String>> readCsvInput(final String file, final Character... seperator){
		List<List<String>> o = new ArrayList<List<String>>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))){
			String line;
			while ((line = br.readLine()) != null) {
				List<String> sepLine = new ArrayList<String>();
				String a = "";
				for(Character c : line.toCharArray()) {
					if(GeneralUtil.arrContains(c, seperator)) {
						sepLine.add(a);
						a = "";
					}
					else
						a += c;
				}
				sepLine.add(a);
				o.add(sepLine);
			}
			return o;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
