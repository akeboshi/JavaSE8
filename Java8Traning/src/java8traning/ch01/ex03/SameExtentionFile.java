/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex03;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author akari
 */
public class SameExtentionFile {
    public static List<File> extFile = new ArrayList<>();

    public static List<File> getSameExtentionFiles(File file, String ext) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException();
        }
        List<File> files = Arrays.asList(file.listFiles());
        files.forEach((f) -> {
            if (f.getName().endsWith(ext)) extFile.add(f);
        });
        return extFile;
    }
}
