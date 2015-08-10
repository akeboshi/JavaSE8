/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex02;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author akari
 */
public class Directory {
    public static List<File> subDirs = new ArrayList<>();

    public static List<File> getSubDirectoriesByRamda(File file) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException();
        }
        List<File> files = Arrays.asList(file.listFiles());
        files.forEach((f) -> {
            if (f.isDirectory()) subDirs.add(f);
        });
        return subDirs;
    }
    
    public static void addSubDir(File f) {
        if (f.isDirectory()) subDirs.add(f);
    }

    public static List<File> getSubDirectoriesByMethodRef(File file) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException();
        }
        List<File> files = Arrays.asList(file.listFiles());
        files.forEach(Directory::addSubDir);
        return subDirs;
    }
}
