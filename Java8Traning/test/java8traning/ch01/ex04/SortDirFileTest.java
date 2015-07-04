/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akari
 */
public class SortDirFileTest {
    @Test
    public void sortDirFile() {
        File dir = new File("/tmp");
        File[] files = dir.listFiles();
        List<File> lf = Arrays.asList(files);
        Collections.shuffle(lf);
        SortDirFile.getSortedFile(lf.toArray(files));
        if (files.length == 0) fail ("no dirs");

        boolean modeChanged = false;

        for (int i = 1; i < lf.size(); i++) {
            File prev = lf.get(i-1);
            File next = lf.get(i);

            if (prev.isDirectory() == next.isDirectory()) {
                if (prev.getName().compareTo(next.getName()) > 0) {
                    fail("Not Sorted" + prev.getName() + " " + next.getName());
                }
                continue;
            }

            if (modeChanged) {
                fail("Directory Mode changed twice");
            }

            assertTrue(prev.isDirectory());
            modeChanged = true;
        }
    }
}
