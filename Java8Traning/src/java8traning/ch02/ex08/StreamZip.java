/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex08;

import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * ぐぐったら出てきたコード。
 * 自分でもう少し考える。
 * @author akari
 */
public class StreamZip {
    public static <T> Stream<T> zip (Stream<T> first, Stream<T> second) {
        Iterator<T> iterator = new Iterator<T>() {
        private Iterator<T> even = first.iterator();
        private Iterator<T> odd  = second.iterator();
        private boolean isEven = true;

        public T next() {
            T result = isEven ? even.next() : odd.next();
            isEven = !isEven;
            return result;
        }
        public boolean hasNext() {
            return isEven ? even.hasNext() : odd.hasNext();
        }
    };
        Spliterator<T> spliterator =
        Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);
    return StreamSupport.stream(spliterator, false);
    }
}



