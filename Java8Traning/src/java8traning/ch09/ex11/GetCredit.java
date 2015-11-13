/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex11;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class GetCredit {

	public static void main(String[] args){
		getCredit();
	}


	public static void getCredit(){
		String regular = "[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}";
		ProcessBuilder builder = new ProcessBuilder("grep", "-r", regular, "/Users/akari/work/");
		builder.redirectOutput(Paths.get("/tmp/credit.txt").toFile());
		try {
			builder.start().waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}