package concurrency1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class J_PrimeNumberWithCallable {

		public static void main(String[] args) throws InterruptedException, ExecutionException {

			
			List<Future<Integer>> futures= new ArrayList();
			ExecutorService executorService= Executors.newCachedThreadPool();
	
			
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
			futures.add(primeNumberFeauture);
			}
			Iterator<Future<Integer>> iterator= futures.iterator();
			
			while(iterator.hasNext()) {
				Future<Integer> f =iterator.next();
				if(f.isDone()) {
					System.out.println(f.get());
				//	futures.remove(f);
				}
			
			}

			

		}

	

}
