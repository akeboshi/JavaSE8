/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex19;

/**
 * <U> U reduce(U identity,
 * BiFunction<U, ? super T, U> accumulator,
 * BinaryOperator<U> combiner)
 * のBiFunction<U, ? super T, U> の第二引数の ? super T は消費される引数であるため、
 * Tの親クラスであるものであるなら、引数として許される。
 * 第一引数のUは、返り値でもあるため、? super Uや ? extends Uは使えない
 * Created by akari on 2015/08/16.
 */
public class ReduceAnswer {
}
