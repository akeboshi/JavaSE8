/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex04;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class GetIntStream {

    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        // int[]型
        Stream.of(values).forEach(v -> System.out.println(v.getClass().getCanonicalName()));
        IntStream.of(values).forEach(v -> System.out.println(v));
    }
}
