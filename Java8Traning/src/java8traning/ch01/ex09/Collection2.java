/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex09;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author akari
 */
public interface Collection2<T> extends Collection<T>{
	default void forEachIf(Consumer<? super T> action, Predicate<T> filter){
		Objects.requireNonNull(action);
		Objects.requireNonNull(filter);
		stream().filter(filter).forEach(action);
	}

	default void forEachIf2(Consumer<? super T> action, Predicate<T> filter){
		Objects.requireNonNull(action);
		Objects.requireNonNull(filter);
		// A
		// for (T t : this) if (filter.test(t)) action.accept(t);
		// B
		forEach((t) -> {
			if (filter.test(t)) action.accept(t);
		});
	}
}
