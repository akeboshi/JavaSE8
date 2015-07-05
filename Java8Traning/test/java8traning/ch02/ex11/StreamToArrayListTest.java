/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author akari
 */
public class StreamToArrayListTest {

    @Test
    public void doubleAverageTest() throws IOException {
    	ArrayList<Integer> ali = new ArrayList<>();
    	int expected = 0;
		for (Integer j = 0; j < 100; j++) {
			ali.add(j);
			expected += j;
		}
		int result = StreamToArrayList.stream2ArrayList(ali.stream(), 100).stream()
				.reduce((x,y)-> x+y).get();
		assertTrue(result == expected);
    }

}
