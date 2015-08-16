/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex16;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

/**
 * Created by akari on 2015/08/15.
 */
public class OrderAsyncTest {
    @Test
    public void nonThrowTest(){
        AtomicBoolean firstDone = new AtomicBoolean();
        AtomicBoolean secondDone = new AtomicBoolean();
        OrderAsync.doInOrderAsync(() -> {
            firstDone.set(true);
            return true;
        },(s, t) -> {
            if (t == null)
                secondDone.set(s);

        });
        try {
            firstDone.wait(1,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Todo これだけだとダメだね。非同期処理を待たせないとだめ
        if (!firstDone.get() || !secondDone.get()) fail();
    }

}