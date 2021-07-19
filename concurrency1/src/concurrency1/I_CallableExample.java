package concurrency1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class I_CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed from runnable");				
			}			
		};

		Callable<String> c= new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("Printed from callable");
				Thread.sleep(2000);
				return "Value from callable";
			}
		};
		
		ExecutorService executorService= Executors.newFixedThreadPool(1);
	 	Future<String> fut= executorService.submit(c);
		String retfut=fut.get();
		System.out.println(retfut);
		
	}

}
