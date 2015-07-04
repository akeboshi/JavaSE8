/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex07;

/**
 *
 * @author akari
 */
public class AndThen {
	public static Runnable andThen (Runnable r1, Runnable r2) {
		return () -> {
			r1.run();
			r2.run();
		};
	}
}
