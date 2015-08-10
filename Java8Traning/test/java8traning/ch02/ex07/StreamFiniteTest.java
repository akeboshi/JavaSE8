/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author akari
 */
public class StreamFiniteTest {

    @Test
    public void streamFiniteTest() throws IOException {
        Stream<Double> randoms_limmited = Stream.generate(Math::random).limit(100);
        Stream<Double> randoms_unlimmited = Stream.generate(Math::random);
        Stream<String> string_limitted = Stream.of("foo","bar");
        
        // limitする前のストリームが無限だと見られる？ 
        //assertEquals(true, StreamFinite.charactorStream(randoms_limmited));
        assertFalse(StreamFinite.charactorStream(randoms_unlimmited));
        assertTrue (StreamFinite.charactorStream(string_limitted));
    }

}
