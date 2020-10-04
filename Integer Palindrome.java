public class NQueens {
	public static boolean isPalindrome(int n) {
		if (n < 0)
			return false;
		
		String x = n + "";
		int high = x.length() - 1;
		
		for(int i = 0; i < x.length(); i++) {
			if(x.charAt(i) != x.charAt(high)) {
				return false;
			}
			high--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int n = 1;
		
		boolean result1 = isPalindrome(n);
		
		System.out.println(result1);
	}
}
