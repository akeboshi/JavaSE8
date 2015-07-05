/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch02.ex09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author akari
 */
public class CombArrayListTest {

    @Test
    public void combArrayListTest() throws IOException {
        String[] st1 = {"foo","bar"};
        String[] st2 = {"aa","ii"};
        String[] st3 = {"java7","java8"};
        List<ArrayList<String>> lals = new ArrayList<>();
        lals.add(new ArrayList<>(Arrays.asList(st1)));
        lals.add(new ArrayList<>(Arrays.asList(st2)));
        lals.add(new ArrayList<>(Arrays.asList(st3)));
        
        ArrayList<String> al = CombArrayList.compArrayList1(lals.stream());
        al.stream().forEach(System.out::println);
    }

}
