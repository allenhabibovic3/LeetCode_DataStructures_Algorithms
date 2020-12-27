import java.util.Scanner;
public class NQueens {
  
  /*
  You are given an array of n integers. You want to modify the array so that it is increasing, i.e., every element is at least as large as the previous element.

On each turn, you may increase the value of any element by one. What is the minimum number of turns required?

Input

The first input line contains an integer n: the size of the array.

Then, the second line contains n integers x1,x2,…,xn: the contents of the array.

Output

Print the minimum number of turns.

Constraints
1≤n≤2⋅105
1≤xi≤109
Example

Input:
5
3 2 5 1 7

Output:
5
  
  */

	public static void main(String[] args) {
		
		boolean isSorted = true;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] nums = new int[n];
		
		int max = 0;
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			int x;
			x = in.nextInt();
			max = Math.max(x, max);
			result += max-x;
		}
		
		System.out.println(result);
	}
}
