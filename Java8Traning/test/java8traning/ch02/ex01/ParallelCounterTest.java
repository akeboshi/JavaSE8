/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *
 * @author akari
 */
public class ParallelCounterTest {

    @Test
    public void parallelCounter() throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        int count = 0;
        for (String s : words) {
            if (s.length() > 3) {
                count++;
            }
        }
        ParallelCounter pc = new ParallelCounter();

        assertEquals(pc.parallelCounterFor(words), count);

    }

}
