/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex05;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

/**
 * Created by akari on 2015/09/06.
 */
public class BirthDayTest {
    @Test
    public void birthdayTest() throws IOException{
        assertTrue(10310 == PlzTellYourBirthday.livingDays(LocalDate.of(1987,6,24)));
    }
}