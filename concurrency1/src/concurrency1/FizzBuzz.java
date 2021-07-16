package concurrency1;

public class FizzBuzz {
	
	public static void main(String[] args) {
		fizzBuzz();
	
	}

	 public static void fizzBuzz() {
		 int n =15;
		    // Write your code here
		    int three=3;
		    int four=5;
		    
		 //   System.out.println("is it on?");
		    if (n==0){
		        System.out.println("NONE");;
		    }
		    
		    for (int i=1; i<=n;i++){
		        
		        if (i%three==0&&i%four==0){
		            System.out.println("FizzBuzz");
		        }
		        else{
		        if (i%three==0||i%four==0){
		        
		        if(i%three==0){
		                System.out.println("Fizz");
		        }
		        if(i%four==0){
		            System.out.println("Buzz"); 
		        }
		        }
		        else{
		            System.out.println(i);
		        
		        }
		        
		    }
		    
		    }

		}
	
}

