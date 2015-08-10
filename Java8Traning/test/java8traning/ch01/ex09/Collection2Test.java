/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex09;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


/**
 *
 * @author akari
 */
public class Collection2Test {
    @Test
    public void collection2() {
       final String[] names = { "Peter", "Paul", "Mary", "Aruga", "isao" };
       ArraysList2<String> al2 = new ArraysList2<>();
       al2.addAll(Arrays.asList(names));
       List<String> list = new ArrayList<>();
       al2.forEachIf2((str) -> list.add(str), (str) -> str.length() > 4);
       assertEquals("Peter", list.get(0));
       assertEquals("Aruga", list.get(1));
       list.clear();
       al2.forEachIf((str) -> list.add(str), (str) -> str.length() > 4);
       assertEquals("Peter", list.get(0));
       assertEquals("Aruga", list.get(1));
    }

}
