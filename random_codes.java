public class NQueens {
	
	public static int factorial(int n) {
		if(n == 0)
			return 1; //base case is 0! = 1 by definition
		return n * factorial(n-1); // if n > 0 n! = n * (n-1)!
	}
	
	
	//recursive simple power method
	public static int power(int base, int power) {
		if(power == 0)
			return 1; //n ^ 0 is 1 always
		return base * power(base, power - 1);
	}
	
	//iterative version
	public static int powerIterative(int b, int p) {
		int result = 1;
		while(p > 1) {
			result *= b;
			p--;
		}
		return result;
	}
	
	//0 1 1 2 3 5 8 13 .....
	//calculate the nth fibo number
	public static int fibo(int n) {
		if(n <= 1)
			return n;
		return fibo(n-1) + fibo(n-2);
	}
	
	public static int sumOfDigits(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10; // get the ones digit and add it to the sum variable
			//divide by 10 to get the next number
			n /= 10;
		}
		
		return sum;
	}
	//only divisors of a prime number are 1 and itsself
	public static boolean isPrime(int n) {
		if(n <= 1)
			return false; // smallest prime is 2 and only even
		if(n <= 3)
			return true;
		
		if(n % 2 == 0 || n % 3 == 0)
			return false;
		
		
		//check in chunks of 5 and only up to sqrt(n) 
		for(int i = 5; i * i < n; i += 6) {
			if(n % i == 0 && n % (i + 2) == 0)
				return false;
		}
		return true;
	}
	
	public static int gcd(int a, int b) {
		if(a == 0)
			return b;
		return gcd(b % a, a);
	}
	
	public static int lcm(int a, int b) {
		return (a*b)/gcd(a, b);
	}
	
	public static void main(String[] args) {
		//basic recursive methods
		
		int n = 10;
		int result = factorial(n);
		
		System.out.println("Factorial of " + n + " is: " + result);
		
		int result2 = power(2, 8);
		System.out.println("2 ^ 8 = " + result2);
		
		int result3 = powerIterative(2, 8);
		System.out.println(result2);
		
		int x = 10;
		int result4 = fibo(x);
		
		System.out.println("the 10th fibo number is: " + result4);
		
		int y = 226;
		int result5 = sumOfDigits(y);
		
		System.out.println("The sum of the digits in the number " + y + " are = " + result5);
		
		//check if a number is prime efficiently
		int z = 11;
		boolean result6 = isPrime(z);
		
		System.out.println("The number, " + z + " is prime: " + result6);
		
		int result7 = gcd(32, 8);
		
		System.out.println("The gcd of 32 and 8 is: " + result7);
		
		int result8 = lcm(15, 20);
		System.out.println("The lcm of 15 and 20 is: " + result8);
	}
}
