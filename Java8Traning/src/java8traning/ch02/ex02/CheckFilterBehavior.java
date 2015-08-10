/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */
package java8traning.ch02.ex02;

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
public class CheckFilterBehavior {

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(
                Paths.get("alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        
        words.stream().filter(w -> {
            System.out.println("filter: " + w);
            return w.length() > 3;
                }
        ).limit(5).forEach(System.out::println);
    }
}
