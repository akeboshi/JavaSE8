/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex07;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author akari
 */
public class AndThenTest {
    @Test
    public void andThen() {
    	List<String> ls = new ArrayList<>();
       AndThen.andThen(() -> {
    	   ls.add("1");
        }, () -> {
        	ls.add("2");
        }).run();
       assertEquals(ls.get(0),"1");
       assertEquals(ls.get(1),"2");
    }
}
