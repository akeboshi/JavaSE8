/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by akari on 2015/08/16.
 */
public class StaticMap {
    public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
        List<U> result = new ArrayList<>();

        list.stream().forEach((l) -> result.add(f.apply(l)));

        return result;
    }
}
