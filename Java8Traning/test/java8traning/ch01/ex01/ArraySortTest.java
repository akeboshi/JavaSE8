/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex01;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akari
 */
public class ArraySortTest {
    
    /**
     * 同じスレッドならOK
     */
     @Test
     public void isSameThread() {
         ArraySort as = new ArraySort();
        String[] words = {"abc","abcd","ab","a"};
         boolean isSame = as.isSameThread(words);
         if (isSame)
             System.out.println("同一スレッドです");
         else
             System.out.println("別スレッドです");
         assertTrue(isSame);
     }
}
