public class NQueens {
	public static int sumOfFactors(int n) {
		int sum = 0;
		String factors = "";
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				sum += i;
				factors += i + " ";
			}
		}
		System.out.println(factors);
		return sum;
	}
	
	public static void main(String[] args) {
		//print the sum of all the factors of n
		//e.g n = 6, sum = 1 + 2 + 3 + 6 = 12
		
		int n = 6;
		int result1 = sumOfFactors(n);
		
		System.out.println("The sum of all the factors in n: " + result1);
	}
}
