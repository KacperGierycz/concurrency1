package concurrency1;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class M_PrimeNumberWithCompletableFuture {

	
	public static void main(String[] args) {
		
		ExecutorService executorService= Executors.newFixedThreadPool(2);
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n I can tall you the nth prime number. Enter n:");
			int n = sc.nextInt();
			if (n==0) break;

		//	CompletableFuture.supplyAsync(()->PrimeNumberUtil.calculatePrime(n))
			CompletableFuture.supplyAsync(()->PrimeNumberUtil.calculatePrime(n), executorService)
			//.thenAccept((Integer retValue)->System.out.println(retValue));
			.thenAccept(System.out::println);
			
		}

	}

}
