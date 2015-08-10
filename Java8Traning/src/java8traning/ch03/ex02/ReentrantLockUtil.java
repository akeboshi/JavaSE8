/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex02;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ReentrantLock を使用する場合には、次のイデオムでロックとアンロックをする 必要があります。
 *
 * myLock.lock();
 * try {
 *   なんらかの処理
 * } finally {
 * myLock.unlock();
 * }
 * 次のように呼び出すことができる withLock メソッドを提供しなさい。
 * withLock(myLock, () -> { なんらかの処理 })
 *
 * @author akari
 */
public class ReentrantLockUtil {
    private ReentrantLockUtil (){}

    public static void withLock (ReentrantLock myLock, Runnable r) throws IllegalArgumentException {
        Objects.requireNonNull(myLock);
        Objects.requireNonNull(r);

        if (myLock.isLocked())
            throw new IllegalArgumentException();

        myLock.lock();
        try {
            r.run();
        } finally {
            myLock.unlock();
        }
    }
}