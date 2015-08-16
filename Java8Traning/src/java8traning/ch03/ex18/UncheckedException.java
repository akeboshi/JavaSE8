/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex18;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by akari on 2015/08/16.
 */
public class UncheckedException {

    public static <T, R> Function<T, R> uncheckd(ThrowableFunction<T, R> t) {
        return (t1) -> {
            try {
                return t.apply(t1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
