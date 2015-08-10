/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex09;

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
public class CombArrayListTest {

	@Test
	public void combArrayListTest() throws IOException {
		List<ArrayList<Integer>> lali = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> ali = new ArrayList<>();
			for (Integer j = i * 10; j < (i + 1) * 10; j++) {
				ali.add(j);
			}
			lali.add(ali);
		}

		ArrayList<Integer> list1 = CombArrayList.compArrayList1(lali.stream());
		ArrayList<Integer> list2 = CombArrayList.compArrayList2(lali.stream());
		ArrayList<Integer> list3 = CombArrayList.compArrayList3(lali.stream());

		for (Integer i = 0; i < 100; i++)
			assertEquals(i, list1.get(i));
		for (Integer i = 0; i < 100; i++)
			assertEquals(i, list2.get(i));
		for (Integer i = 0; i < 100; i++)
			assertEquals(i, list3.get(i));
	}

}
