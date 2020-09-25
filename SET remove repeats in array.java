import java.util.Set;

public class NQueens {
	public static Integer[] removeRepeats(int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i: A) {
			set.add(i);
		}
		
		Integer[] unique = set.toArray(new Integer[0]);
		return unique;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 2, 3, 3, 3, 4, 5, 6, 6, 8};
		
		Integer[] B = removeRepeats(A);
		
		for(int i = 0; i < B.length; i++)
			System.out.print(B[i] + " ");
	}
}
