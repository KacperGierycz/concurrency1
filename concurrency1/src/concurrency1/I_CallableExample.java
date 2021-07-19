package concurrency1;

public class I_CallableExample {

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed from runnable");				
			}
			
			
		};

		
	}

}
