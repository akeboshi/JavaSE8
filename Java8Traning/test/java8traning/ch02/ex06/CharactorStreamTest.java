/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author akari
 */
public class CharactorStreamTest {

    @Test
    public void charactorStream() throws IOException {
        String s = "foobar";
        List<Character> lc = new ArrayList<>();
        CharactorStream.charactorStream("foobar").forEach(n -> lc.add(n));
        for (int i = 0 ; i < s.length() ; i++) assertEquals((Character)s.charAt(i),lc.get(i));
    }

}
