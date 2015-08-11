package java8traning.ch03.ex07;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ComparatorGeneratorTest {

	@Test
	public void testDefaultCompare() {
		String[] actual = {" aaa","bbb"," Ccc"};
		String[] expected = {" Ccc"," aaa","bbb"};
		Arrays.sort(actual,ComparatorGenerator.generate(false, false, false));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}

	@Test
	public void testReverseCompare() {
		String[] actual = {" aaa","bbb"," Ccc"};
		String[] expected = {"bbb"," aaa"," Ccc"};
		Arrays.sort(actual,ComparatorGenerator.generate(true, false, false));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}

	@Test
	public void testIgnoreCaseCompare() {
		String[] actual = {" aaa","bbb"," Ccc"};
		String[] expected = {" aaa"," Ccc","bbb"};
		Arrays.sort(actual,ComparatorGenerator.generate(false, true, false));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}

	@Test
	public void testIgnoreSpaceCompare() {
		String[] actual = {" aaa","bbb"," Ccc"};
		String[] expected = {" Ccc"," aaa","bbb"};
		Arrays.sort(actual,ComparatorGenerator.generate(false, false, true));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}

	@Test
	public void testAllCompare() {
		String[] actual = {" aaa","bbb"," Ccc"};
		String[] expected = {" Ccc","bbb"," aaa"};
		Arrays.sort(actual,ComparatorGenerator.generate(true, true, true));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}

}
