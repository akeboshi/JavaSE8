/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch09.ex07;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;

public class GetPage {
	public static void main(String[] args){
		getPage("http://www.google.co.jp/");
	}

	public static void getPage(String path) {
		try {
			URL url = new URL(path);
			Files.copy(url.openStream(),Paths.get("/tmp/page.txt"), StandardCopyOption.REPLACE_EXISTING);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}