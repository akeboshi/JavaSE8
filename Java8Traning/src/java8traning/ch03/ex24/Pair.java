/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex24;

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
/* つくろうとすると
    public <R> Pair<R> flatMap(Function<? super T, ? extends Pair<? extends R>> mapper) {
        Pair<? extends R> p1 = mapper.apply(first);
        Pair<? extends R> p2 = mapper.apply(second);
        ・・・ここからどうするか不明。２つのPairから1つのPairを作る性質があれば、作成可能。
       (public static <T> Pair<T> sum(Pair<T> p1, Pair<T> p2)みたいなのがあれば)
    };
    */
}
