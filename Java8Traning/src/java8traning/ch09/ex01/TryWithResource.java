/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex01;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryWithResource {
	public static void main (String[] args){
		Scanner in = null;
		try{
			in = new Scanner(Paths.get("/usr/share/dict/words"));
		} catch (IOException e){
			System.out.println(e);
		}

		PrintWriter out = null;
		try {
			out = new PrintWriter("/usr/share/dict/out.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			try {
				in.close();
			} catch (IllegalStateException e1){
				System.out.println(e1);
			}
		}

		try {
			while (in.hasNext()){
				out.println(in.next().toLowerCase());
			}
		} catch (IllegalStateException e){
			System.out.println(e);
		}

		try {
			in.close();
		} catch (IllegalStateException e){
			System.out.println(e);
		}

		try {
			out.close();
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
	}

}