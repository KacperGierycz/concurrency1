package concurrency1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class D_PrimeNumberWithConcurrencyHoldingThreads {
	
	public static void main(String[] args) {
	
	List<Thread> threads= new ArrayList<>();
	
	Runnable statusReporter = () ->{
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printThreads(threads);
		}
	};
	
	Thread reporterThreads = new Thread(statusReporter);
	reporterThreads.setDaemon(true);
	reporterThreads.start();
	
	


	//	int number;
		
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
			Thread t = new Thread(r);
			threads.add(t);
			t.start();
		}

	}
	
	private static void printThreads(List<Thread> threads) {
		System.out.print("\n Thread status: ");
		threads.forEach(thread ->{
			System.out.print(thread.getState() + " ");
		});
		System.out.println("");
		
		
	}
	
}
