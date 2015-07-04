/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex04;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author akari
 */
public class SortDirFile {

    public static void getSortedFile (File[] files) {
        Arrays.sort(files,(File f,File s) -> {
        if (s.isDirectory() && f.isFile())
            return 1;
        else if (s.isFile() && f.isDirectory())
            return -1;
        else
            return f.compareTo(s);
        });
    }
}
