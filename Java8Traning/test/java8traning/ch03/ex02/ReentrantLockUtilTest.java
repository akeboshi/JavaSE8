/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex02;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

import static org.junit.Assert.*;

/**
 *
 * @author akari
 */
public class ReentrantLockUtilTest {

    @Test
    public void testReentrantLockUtil() {
        ReentrantLock myLock = new ReentrantLock();
        AtomicBoolean tested = new AtomicBoolean();

        ReentrantLockUtil.withLock(myLock, () -> {
            assertTrue(myLock.isLocked());
            tested.set(true);
        });
        
        assertFalse(myLock.isLocked());
        assertTrue(tested.get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLocked() {
        ReentrantLock myLock = new ReentrantLock();
        myLock.lock();
        ReentrantLockUtil.withLock(myLock, () -> {
            fail();
        });
    }

}