/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex09;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Created by akari on 2015/08/11.
 */
public class LexicographicComparatorTest {
    @Test
    public void equalsTest(){
        Comparator cmp = LexicographicComparator.lexicographicComparator("bar", "hoge");
        assertTrue(cmp.compare(new Foo("bar","hoge"), new Foo("bar","hoge")) == 0);
    }

    public class Foo{
        private String bar = "test";
        public String hoge;

        public Foo (String bar, String hoge){
            this.bar = bar;
            this.hoge = hoge;
        }

    }

}