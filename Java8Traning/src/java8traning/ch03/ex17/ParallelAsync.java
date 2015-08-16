/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex17;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by akari on 2015/08/16.
 */
public class ParallelAsync {
    public static void doInParallelAsync(Runnable first, Runnable second,
                      Consumer<Throwable> handler) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);
        Objects.requireNonNull(handler);

        Thread t1 = new Thread(() -> {
            try {
                first.run();
            } catch (Throwable e) {
                handler.accept(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                second.run();
            } catch (Throwable e) {
                handler.accept(e);
            }
        });

        t1.start();
        t2.start();
    }
}
