/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author akari
 */
public class ParallelCounter {

    public long parallelStreamCounter(List<String> words) {
        return words.parallelStream().filter(w -> w.length() > 3).count();
    }

    public int parallelCounterFor(List<String> words) {
        List<CountThread> t = new ArrayList<>();
        final List<String> fls = words;
        for (int i = 0; i < 10; i++) {
            int s = words.size() / 10 * i;
            int e = s + words.size() / 10;
            if (i == 9) e = words.size() ;
            final List<String> sWords = words.subList(s, e);
            t.add(new CountThread(3, sWords));
        }
        for (CountThread t1 : t) {
            t1.start();
        }
        for (CountThread t1 : t) {
            try {
                t1.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        int count = 0;
        for (CountThread t1 : t) count += t1.getCount();

        return count;
    }

}
