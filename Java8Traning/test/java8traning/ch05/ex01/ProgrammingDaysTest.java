/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex01;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by akari on 2015/09/06.
 */
public class ProgrammingDaysTest {
    @Test
    public void getProgrammingDayTest() {
        // normal year
        LocalDate expected2015 = getProgrammingDayByPlusDays(2015);
        // leap year
        LocalDate expected2016 = getProgrammingDayByPlusDays(2016);
        assertTrue(expected2015.equals(ProgrammingDays.get(2015)));
        assertTrue(expected2016.equals(ProgrammingDays.get(2016)));
    }

    private LocalDate getProgrammingDayByPlusDays(int year) {
        return LocalDate.of(year, 1, 1).plusDays(255);
    }
}