/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author akari
 */
public class ArraySort {

    public boolean isSameThread(String[] words) {
        Set<Long> ids = new HashSet<>();
        ids.add(Thread.currentThread().getId());
        Arrays.sort(words, (f, s) -> {
            ids.add(Thread.currentThread().getId());
            return Integer.compare(f.length(), s.length());
        });
        
        if (ids.size() == 1) return true;
        
        return false;
    }
}
