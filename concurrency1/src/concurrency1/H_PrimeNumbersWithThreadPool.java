package concurrency1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class H_PrimeNumbersWithThreadPool {
	

		public static void main(String[] args) {
			
			ExecutorService executorService=Executors.newFixedThreadPool(3);

			int number;
			
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n I can tall you the nth prime number. Enter n:");
				int n = sc.nextInt();
				if (n==0) break;
				Runnable r = new Runnable() {

					@Override
					public void run() {
						int number = PrimeNumberUtil.calculatePrime(n);
						System.out.println("\n Result: ");
						System.out.println("\n Value of "+ n + "th prime: "+ number);
					}
					
				};
				executorService.execute(r);
		
			}

		}

	
}
