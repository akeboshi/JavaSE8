#! /usr/local/bin/jjs

var JString = Java.type('java.lang.String')
var JStandardCharasets = Java.type('java.nio.charset.StandardCharsets')
var JFiles = Java.type('java.nio.file.Files')
var JFile = Java.type('java.io.File')
var JArrays = Java.type('java.util.Arrays')

var file = new JFile('/Users/akari/IdeaProjects/JavaSE8/Java8Traning/WarAndPease.txt')
var contents = new JString(JFiles.readAllBytes(file.toPath()),JStandardCharasets.UTF_8)
var words = JArrays.asList(contents.split(/\W+/))

words.stream().distinct().filter(function(w) {return w.length() > 12}).sorted().forEach(function(w) {print(w)})

