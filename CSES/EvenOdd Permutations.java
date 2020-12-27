import java.util.Scanner;
public class NQueens {

/*
A permutation of integers 1,2,…,n is called beautiful if there are no adjacent elements whose difference is 1.

Given n, construct a beautiful permutation if such a permutation exists.

Input

The only input line contains an integer n.

Output

Print a beautiful permutation of integers 1,2,…,n. If there are several solutions, you may print any of them. If there are no solutions, print "NO SOLUTION".

Constraints
1≤n≤106
Example 1

Input:
5

Output:
4 2 5 3 1

Example 2

Input:
3

Output:
NO SOLUTION

*/
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		if(n <= 3) {
			System.out.println("No Solution");
		}
		
		
		if(n % 2 == 0) {
			for(int i = n; i > 0; i -= 2) {
				System.out.print(i + " ");
			}
			for(int i = n-1; i >= 1; i -= 2) {
				System.out.print(i + " ");
			}
		}else {
			//odd first decrementing
			for(int i = n-1; i >= 1; i -= 2) {
				System.out.print(i + " ");
			}
			for(int i = n; i > 0; i -= 2) {
				System.out.print(i + " ");
			}
		}
	}
}
