/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex03;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by akari on 2015/09/06.
 */
public class NextAdjusterTest {
    @Test
    public void getNextWeekDayTest(){
        List<LocalDate> list = new ArrayList<>();
        List<LocalDate> expected = new ArrayList<>();

        for (int i = 1 ; i <= 7 ; i ++ ) list.add(LocalDate.of(2015, 9, i).with(NextAdjuster.next(w -> w.getDayOfWeek().getValue() < 6)));
        expected.add(LocalDate.of(2015, 9, 2));
        expected.add(LocalDate.of(2015, 9, 3));
        expected.add(LocalDate.of(2015, 9, 4));
        expected.add(LocalDate.of(2015, 9, 7));
        expected.add(LocalDate.of(2015, 9, 7));
        expected.add(LocalDate.of(2015, 9, 7));
        expected.add(LocalDate.of(2015, 9, 8));

        for (int i = 0 ; i < 7 ; i++) {
            System.out.println(list.get(i) + " " + expected.get(i));
            assertTrue(list.get(i).equals(expected.get(i)));
        }
    }
}