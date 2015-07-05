/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex03;

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
public class CheckParallelStreamBehavior {

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(
                Paths.get("warAndPease.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        long count = 0;
        long s,t;
        
        s = System.nanoTime();
        for (int i = 0 ; i < 100 ; i++)
            count = words.stream().filter(w -> w.length() > 5 ).count();
        t = System.nanoTime();
        long unparallel = t - s;
        
        s = System.nanoTime();
        for (int i = 0 ; i < 100 ; i++)
            count = words.parallelStream().filter(w -> w.length() > 5 ).count();
        t = System.nanoTime();
        long parallel = t - s;
        
        System.out.println("unparallel :" + unparallel);
        System.out.println("parallel :" + parallel);
        System.out.println("unparallel - parallel :" + (unparallel - parallel));
    }
}
