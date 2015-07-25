/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch03.ex01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java8traning.ch03.ex01.MyLogger;

import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author akari
 */
public class MyLoggerTest {

    @Test
    public void myLoggerTest() throws IOException {
        MyLogger logger = new MyLogger();
           List<String> ls = new ArrayList<>();
           ls.add("wowowo");
           ls.add("wo");
           ls.add("foo");
           ls.add("four");
           logger.setLevel(Level.ALL);
           ls.stream().forEach(str -> logger.logIf(Level.INFO, () ->  str.length() > 3, () -> str));
    }

}
