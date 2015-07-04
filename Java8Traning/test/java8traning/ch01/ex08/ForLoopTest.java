/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex08;


import java.util.List;

import org.junit.Test;


/**
 *
 * @author akari
 */
public class ForLoopTest {
    @Test
    public void forLoop() {
        final String[] names = { "Peter", "Paul", "Mary" };

        List<Runnable> lr1 = ForLoop.forLoop(names);
        List<Runnable> lr2 = ForLoop.oldForLoop(names);
        List<Runnable> lr3 = ForLoop.newForLoop(names);

        lr1.forEach(Runnable::run);
        lr2.forEach(Runnable::run);
        lr3.forEach(Runnable::run);
    }

}
