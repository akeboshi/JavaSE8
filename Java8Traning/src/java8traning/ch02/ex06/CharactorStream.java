/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class CharactorStream {
    static public Stream<Character> charactorStream (String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}

