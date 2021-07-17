package concurrency1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class H_PrimeNumbersWithThreadPool {
	

		public static void main(String[] args) {
			
			ScheduledExecutorService sheduledExecutor=Executors.newScheduledThreadPool(1);
			Runnable reporterRunnable= ()->{
				System.out.println("running raporter");
			};

			
			sheduledExecutor.scheduleAtFixedRate(reporterRunnable, 1, 5, TimeUnit.SECONDS);
			
			
			ExecutorService executorService=Executors.newFixedThreadPool(3);
		//	ExecutorService executorService=Executors.newCachedThredPool();
			

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
