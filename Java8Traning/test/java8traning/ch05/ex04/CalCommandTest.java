/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch05.ex04;

import java8traning.ch05.ex03.NextAdjuster;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by akari on 2015/09/06.
 */
public class CalCommandTest {
    @Test
    public void calCommandTest() throws IOException{
        for (int i = 1800 ; i <2100 ; i++) {
            for (int j = 1 ; j <= 12 ; j++){
                String[] args = new String[3];
                args[0] = "cal";
                args[1] = Integer.toString(j);
                args[2] = Integer.toString(i);
                String expected = CalCommand.exec(args);
                String actual = CalCommand.cal(args);
                assertTrue(expected.equals(actual));

            }
        }
    }
}