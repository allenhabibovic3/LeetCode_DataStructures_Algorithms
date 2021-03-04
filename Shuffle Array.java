import java.util.Arrays;
import java.util.Random;

public class NQueens {
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void shuffle(int[] A) {
		int n = A.length; 
		
		Random rand = new Random();
		for(int i = n - 1; i >= 1; i--) {
			int j = rand.nextInt(i + 1);
			swap(A, i, j);
		}
	}
	
	public static void main(String[] args) {
	
		int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		shuffle(A);
		
		System.out.println(Arrays.toString(A));
		
	}
}
