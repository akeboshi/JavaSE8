/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex07;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author akari
 */
public class StreamFinite {
    static public <T> boolean charactorStream (Stream<T> stream) {
        return stream.spliterator().estimateSize() != Long.MAX_VALUE;
        //return stream.spliterator().getExactSizeIfKnown() != -1;
    }
}

