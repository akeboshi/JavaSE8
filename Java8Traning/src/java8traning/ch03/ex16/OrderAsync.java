/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by akari on 2015/08/15.
 */
public class OrderAsync {
    public static <T> void doInOrderAsync(
            Supplier<T> first,
            BiConsumer<T, Throwable> second
    ) {
        Thread t = new Thread() {
            public void run() {
                T result = null;
                try {
                    result = first.get();
                    second.accept(result, null);
                } catch (Throwable t) {
                    second.accept(result, t);
                }
            }
        };
        t.start();
    }
}
