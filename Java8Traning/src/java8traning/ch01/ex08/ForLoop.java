/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author akari
 */
public class ForLoop {
	public static List<Runnable> newForLoop(String[] names) {
        List<Runnable> runners = new ArrayList<>();
        Arrays.asList(names).forEach((str) -> runners.add(() -> System.out.println(str)));
        return runners;
    }

    public static List<Runnable> forLoop(String[] names) {
        List<Runnable> runners = new ArrayList<>();
        for (String name: names)
        	runners.add(() -> System.out.println(name));
        return runners;
    }

    /**
     * for (int i = 0 ; i < names.length ; i++){
     * だと、実質エンクロージングスコープからキャプチャされる変数
     * が実質ファイナルでなくてはならないので、手間がかかる
     * @return
     */
    public static List<Runnable> oldForLoop(String[] names){
        List<Runnable> runners = new ArrayList<>();
        for (int i = 0 ; i < names.length ; i++){
        	final int j = i;
        	runners.add(() -> System.out.println(names[j]));
        }
        return runners;
    }

}
