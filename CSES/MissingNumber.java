import java.util.Scanner;
public class NQueens {
	/*
	 * You are given all numbers between 1,2,…,n except one. Your task is to find the missing number.

Input

The first input line contains an integer n.

The second line contains n−1 numbers. Each number is distinct and between 1 and n (inclusive).

Output

Print the missing number.

Constraints
2≤n≤2⋅105
Example

Input:
5
2 3 1 5

Output:
4
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] nums = new int[n-1];
		int ourSum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
			ourSum += nums[i];
		}
		
		int sumOfFirstN = (n*(n+1))/2;
		
		int missingNum = sumOfFirstN - ourSum;
		
		System.out.println(missingNum);
	}
}
