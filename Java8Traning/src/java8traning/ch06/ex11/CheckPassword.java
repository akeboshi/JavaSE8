/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch06.ex11;

import java.io.Console;
import java.net.PasswordAuthentication;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CheckPassword {
	public static void main(String[] args){
		Console console = System.console();
		CompletableFuture<PasswordAuthentication> cf = repeat(() ->{
			PasswordAuthentication pa = new PasswordAuthentication(
					console.readLine("id:"),
					console.readPassword("password:")
			);
			return pa;
		},(pa) ->{
			try {
				Thread.sleep(1000);
			} catch (Exception e){
				System.out.println(e);
			}
			String pass = new String(pa.getPassword());
			return pass.equals("secret");
		});
		try {
			System.out.println("success! your password is " + new String(cf.get().getPassword()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static <T> CompletableFuture<T> repeat(
			Supplier<T> action, Predicate<T> until){
		return CompletableFuture.supplyAsync(action).thenComposeAsync
				(w -> until.test(w) ? CompletableFuture.completedFuture(w) : repeat(action, until));
	}
}