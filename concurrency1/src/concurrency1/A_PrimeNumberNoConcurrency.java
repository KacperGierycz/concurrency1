package concurrency1;

import java.util.Scanner;

public class A_PrimeNumberNoConcurrency {

	public static void main(String[] args) {

		int number;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n I can tall you the nth prime number. Enter n:");
			int n = sc.nextInt();
			if (n==0) break;
			number = PrimeNumberUtil.calculatePrime(n);
			System.out.println("\n Value of "+ n+ "th prime "+ number);
			
		}

	}

}
