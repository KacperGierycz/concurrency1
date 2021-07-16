package concurrency1;



class Counter implements Runnable {
	
	private int value = 0;
	
	public void increment() {
		try {
			Thread.sleep(20);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		value++;
	}
	
	public void decremnet() {value--;}
	
	public int getValue() {return value;}

	@Override
	public void run() {

		this.increment();
		System.out.println(Thread.currentThread().getName()+"increments: "+ this.getValue());
		this.decremnet();
		System.out.println(Thread.currentThread().getName()+"decrements: " + this.getValue());
		
	}
	
	
	
	
}



public class F_Synchronized { 
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		new Thread(counter, "One").start();
		new Thread(counter, "Two").start();
		new Thread(counter, "Three").start();
		new Thread(counter, "Four").start();
		
		
	}

}
