package concurrency1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class K_PrimeNumberWithSemaphores {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(3);
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n I can tall you the nth prime number. Enter n:");
			int n = sc.nextInt();
			if (n==0) break;
			Runnable r = new Runnable() {

				@Override
				public void run() {
					try {
						semaphore.acquire();
						System.out.println("Now calculationg for: "+ n);
						int number = PrimeNumberUtil.calculatePrime(n);
						System.out.println("\n Result: ");
						System.out.println("\n Value of "+ n + "th prime: "+ number);
					} catch (InterruptedException e) {
						System.out.println("Interupted while aquiring");
						e.printStackTrace();
					} finally {

					semaphore.release();
					}
				}
				
			};
			Thread t = new Thread(r);
			t.start();
		}

	}

}
