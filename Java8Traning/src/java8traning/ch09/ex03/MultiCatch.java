/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex03;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.Scanner;

public class MultiCatch {
	public static void main(String[] args){
		try{
			process(false);
		} catch (FileNotFoundException|UnknownHostException e){
			System.out.println(e);
		}
		try {
			process(true);
		} catch (FileNotFoundException|UnknownHostException e){
			System.out.println(e);
		}
	}

	public static void process(boolean fnfe) throws FileNotFoundException,UnknownHostException {
		try {
			if(fnfe)
				throw new FileNotFoundException();
			else
				throw new UnknownHostException();
		} catch (FileNotFoundException | UnknownHostException ex) {
			System.out.println(ex);
			throw ex;
		}
	}
}