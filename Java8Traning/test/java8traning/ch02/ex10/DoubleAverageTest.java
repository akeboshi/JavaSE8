/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author akari
 */
public class DoubleAverageTest {

    @Test
    public void doubleAverageTest() throws IOException {
        Stream<Double> sd = IntStream.range(1, 100).asDoubleStream().boxed();
        double d = DoubleAverage.doubleAverage(sd.parallel());
        assertEquals(50.0, d, 0.001);
    }

}
