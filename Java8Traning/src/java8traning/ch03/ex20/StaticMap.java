/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by akari on 2015/08/16.
 */
public class StaticMap {
    public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
        return list.stream().map(f::apply).collect(Collectors.toList());
    }
}
