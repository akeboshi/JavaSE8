/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex12;

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
public class AtomicIntegerCountTest {

    @Test
    public void atomicIntegerCountTest() throws IOException {
    	ArrayList<String> als = new ArrayList<>();
    	int[] expected = new int[5];
    	int r;
		for (int j = 0; j < 1000; j++) {
			r = (int)(Math.random() * 5);
			switch(r){
			case 0:
				als.add("");
				expected[0]++;
				break;
			case 1:
				als.add(String.format("%d", j % 10));
				expected[1]++;
				break;
			case 2:
				als.add(String.format("%02d", j % 100));
				expected[2]++;
				break;
			case 3:
				als.add(String.format("%03d", j));
				expected[3]++;
				break;
			case 4:
				als.add(String.format("%04d", j));
				expected[4]++;
				break;
			default:
				fail();
			}
		}
		List<Integer> li = AtomicIntegerCount.count(als.stream());
		for (int j = 0; j < 5 ; j++)
			assertTrue(expected[j] == li.get(j));
    }

}
