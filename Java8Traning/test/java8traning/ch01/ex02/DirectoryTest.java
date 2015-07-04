/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex02;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akari
 */
public class DirectoryTest {
    @Test
    public void subDirsByramda() {
        File dir = new File("/tmp");
        List<File> subdirs = Directory.getSubDirectoriesByRamda(dir);
        if (subdirs.isEmpty()) fail ("no dirs");
        for (File f : subdirs) {
            if (!f.isDirectory()) {
                fail("have file: " + f.getName());
            }
        }
    }

    @Test
    public void subDirsByMethodRef() {
        File dir = new File("/tmp");
        List<File> subdirs = Directory.getSubDirectoriesByMethodRef(dir);
        if (subdirs.isEmpty()) fail ("no dirs");
        for (File f : subdirs) {
            if (!f.isDirectory()) {
                fail("have file: " + f.getName());
            }
        }
    }
}
