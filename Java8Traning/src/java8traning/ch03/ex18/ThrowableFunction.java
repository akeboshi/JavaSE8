/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex18;

/**
 * Created by akari on 2015/08/16.
 */
@FunctionalInterface
public interface ThrowableFunction<T, U> {
    public U apply (T t) throws Exception;
}
