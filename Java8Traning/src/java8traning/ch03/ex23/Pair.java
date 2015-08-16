/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex23;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Created by akari on 2015/08/16.
 */
public class Pair<T> {
    private T first;
    private T second;

    private Pair(){
    }

    public Pair(T first, T second) {
        this();
        this.first = first;
        this.second = second;
    }

    public <R> Pair<R> map(Function<? super T,R> f) {
        return new Pair<>(f.apply(first), f.apply(second));
    }
}
