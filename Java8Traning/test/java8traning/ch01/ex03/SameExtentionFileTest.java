/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex03;

import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akari
 */
public class SameExtentionFileTest {
    @Test
    public void subDirsByramda() {
        File dir = new File("/tmp");
        String ext = "txt";
        List<File> subdirs = SameExtentionFile.getSameExtentionFiles(dir, ext);
        if (subdirs.isEmpty()) fail ("no dirs");
        for (File f : subdirs) {
            if (f.isDirectory()) {
                fail("have directory: " + f.getName());
            } else if (!f.getName().endsWith(ext)) {
                fail("ext error");
            }
        }
    }
}
