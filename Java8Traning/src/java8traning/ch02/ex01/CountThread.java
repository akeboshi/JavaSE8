/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */
package java8traning.ch02.ex01;

import java.util.List;

/**
 *
 * @author akari
 */
public class CountThread extends Thread{
    private int count = 0;
    private int length;
    private List<String> words;
    
    private CountThread(){}
    
    public CountThread (int length, List<String> words){
        this.length = length;
        this.words = words;
    }

    @Override
    public void run() {
        for (String w : words) if (w.length() > length) count ++;
    }
    
    public int getCount() {
        return this.count;
    }
}
