/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex10;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class DoubleAverage {
    public static void main(String[] args) {
        System.out.println(doubleAverage(Stream.of((Double)2.0,(Double) 3.0)));
    }
    public static double doubleAverage (Stream<Double> stream) {
        Counter c = new Counter();
        Optional<Double> sum = stream.reduce((x,y) ->{
            c.plus();
            return x + y;
                });
        return sum.get()/c.getCount();
    }
}

class Counter {
    Long count = 1L;  
    public long getCount() {
            return count;
    }  
    public synchronized void plus() {
        count++;
    }
}

