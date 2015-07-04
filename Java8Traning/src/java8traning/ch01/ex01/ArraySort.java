/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author akari
 */
public class ArraySort {    
    public boolean isSameThread(){
        String[] words = {"abc","abcd","ab","a"};
        List<Long> ids = new ArrayList<>();
        ids.add(Thread.currentThread().getId());
        Arrays.sort(words, (String f, String s) -> {
            ids.add(Thread.currentThread().getId());
            return Integer.compare(f.length(), s.length());
                });
        for (Long id : ids) if (!ids.get(0).equals(id)) return false;
        return true;
    }
}
