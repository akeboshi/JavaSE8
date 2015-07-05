/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex05;

import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class UnlimittedStream {
    public static void main(String[] args) {
        // 無限なので、終わらないはず
        new UnlimittedStream().getUnlimittedStream().count();
    }
    
    public Stream<Long> getUnlimittedStream () {
        return Stream.iterate(System.currentTimeMillis(), (LinearCongruentialGenerator::random));
    }
}

class LinearCongruentialGenerator {
    private static long a = 25214903917L;
    private static long c = 11;
    private static long m = (long) Math.pow(2, 48);
    
    public static long random (long x) {
        return (a * x + c) % m;
    }
    
}