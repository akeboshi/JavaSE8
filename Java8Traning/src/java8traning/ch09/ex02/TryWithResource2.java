/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex02;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResource2 {
	public static void main (String[] args){
		try {
			manyThrows(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void manyThrows (String[] args) throws Exception{
		Scanner in = null;
		Exception exeption = null;
		try{
			in = new Scanner(Paths.get("/usr/share/dict/words"));
		} catch (IOException e){
			if (exeption == null)
				exeption = e;
			System.out.println(e);
			throw exeption;
		}

		PrintWriter out = null;
		try {
			out = new PrintWriter("/usr/share/dict/out.txt");
		} catch (FileNotFoundException e) {
			if (exeption == null)
				exeption = e;
			else
				exeption.addSuppressed(e);
			System.out.println(e);
			try {
				in.close();
			} catch (IllegalStateException e1){
				if (exeption == null)
					exeption = e1;
				else
					exeption.addSuppressed(e1);
				System.out.println(e1);
				throw exeption;
			}
			throw exeption;
		}

		try {
			while (in.hasNext()){
				out.println(in.next().toLowerCase());
			}
		} catch (IllegalStateException e){
			if (exeption == null)
				exeption = e;
			System.out.println(e);
			throw exeption;
		}

		try {
			in.close();
		} catch (IllegalStateException e){
			if (exeption == null)
				exeption = e;
			System.out.println(e);
			throw exeption;
		}

		try {
			out.close();
		} catch (IllegalStateException e) {
			if (exeption == null)
				exeption = e;
			System.out.println(e);
			throw exeption;
		}
	}

}