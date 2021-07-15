package concurrency1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E_PrimeNumberWithConcurencyJoining {
	
	public static void main(String[] args) {
		
	List<Thread> threads= new ArrayList<>();
	
	Runnable statusReporter = new Runnable(){
		
		@Override
		public void run() {
		
			try {
				while(true) {
			
				Thread.sleep(5000);
				printThreads(threads);
					}	
			} catch (InterruptedException e) {
				System.out.println("Status report thread interupted.Ending "
						+ "status update");
			}
		}


	};
	
	Thread reporterThread = new Thread(statusReporter);
	reporterThread.start();
	
	


	//	int number;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n I can tall you the nth prime number. Enter n:");
			int n = sc.nextInt();
			if (n==0) {
				reporterThread.interrupt();
				try {
					System.out.println("Waiting for all threads to finish...");
					waitingForThreads(threads);
					System.out.println("Done with the application. "
					+ threads.size()+ "pr ");
				}catch(InterruptedException e) {
					System.out.println("\n Got interupted when waiting for threads. Quiting");
				}
				
				
				break;
			}
			
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
	
	private static void waitingForThreads(List<Thread> threads) throws InterruptedException{
		
		for (Thread thread : threads) {
			// if (!thread.getState().equals(Thread.State.TERMINATED)){
			thread.join();
			// }
			
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
