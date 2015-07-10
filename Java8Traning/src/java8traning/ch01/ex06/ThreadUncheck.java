/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex06;

/**
 *
 * @author akari
 */
public class ThreadUncheck {

    public static void main(String arg[]) {
        new ThreadUncheck().threadUncheck();
    }

    public void threadUncheck() {
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }

    public static Runnable uncheck(RunnableEx re) throws RuntimeException {
        return () -> {
            try {
                re.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
