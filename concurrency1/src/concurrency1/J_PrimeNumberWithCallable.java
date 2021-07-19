package concurrency1;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class J_PrimeNumberWithCallable {

		public static void main(String[] args) throws InterruptedException, ExecutionException {

			ExecutorService executorService= Executors.newCachedThreadPool();
			int number;
			
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n I can tall you the nth prime number. Enter n:");
				int n = sc.nextInt();
				if (n==0) break;
				
				Callable <Integer> c =new Callable<Integer>() {

					@Override
					public Integer call() throws Exception {
						return PrimeNumberUtil.calculatePrime(n);
					}
					
					
				};

			Future<Integer> primeNumberFeauture=executorService.submit(c);
			System.out.println( n+ " th prime number is: " + primeNumberFeauture.get());
				

			}

		}

	

}
