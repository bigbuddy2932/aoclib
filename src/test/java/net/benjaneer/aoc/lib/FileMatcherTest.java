package net.benjaneer.aoc.lib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

public class FileMatcherTest {
	private static final Pattern p1 = Pattern.compile("[\\s\\S]+");
	private static final Pattern p2 = Pattern.compile("[a-z]+-[0-9]+-[a-z]+");
	private static final Pattern p3 = Pattern.compile("[a-z]+");
	private static final String FILE = "./src/test/resources/fileMatcherTestData";
	private static final String CSV_FILE = "./src/test/resources/csvMatcherTestData";
	private static final String AOC_2016_DAY_07 = "./src/test/resources/aoc2016day07.txt";
	@Test
	public void fileReadTest() {
		assertEquals(5, FileMatcher.readInput(p1, FILE).size());
		assertEquals(3, FileMatcher.readInput(p2, FILE).size());
		assertEquals(2, FileMatcher.readInput(p3, FILE).size());
	}
	@Test
	public void fileReadNonexistantTest() {
		assertEquals(0, FileMatcher.readInput(p1, "iDoNotExist").size());
	}
	@Test
	public void fileReadCsvTest() {
		assertEquals(1, FileMatcher.readCsvInput(CSV_FILE).size());
		assertEquals(8, FileMatcher.readCsvInput(CSV_FILE).get(0).size());
		assertEquals(1, FileMatcher.readCsvInput(CSV_FILE, '.').size());
		assertEquals(4, FileMatcher.readCsvInput(CSV_FILE, '.').get(0).size());
	}
	@Test
	public void fileReadCsvMultilineTest() {
		List<List<String>> csv = FileMatcher.readCsvInput(AOC_2016_DAY_07, '[', ']');
		assertEquals(2000, csv.size());
		for(List<String> i : csv)
			assertEquals(1, i.size() % 2);
		assertEquals(3, csv.get(0).size());
		assertEquals(5, csv.get(1).size());
	}
	@Test
	public void fileReadCsvNonexistantTest() {
		assertNull(FileMatcher.readCsvInput("iDoNotExist"));
	}
}
