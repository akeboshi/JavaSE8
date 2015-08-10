/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex03;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

/**
 * Created by akari on 2015/08/10.
 */
public class MyAssertTest {
    @Test
    public void testAssert(){
        AtomicBoolean tested = new AtomicBoolean();
        try {
            MyAssert.myAssert(() -> {
                tested.set(true);
                return false;
            });
        } catch (AssertionError e){
            assertTrue(tested.get());
            return;
        }
        fail();
    }
}