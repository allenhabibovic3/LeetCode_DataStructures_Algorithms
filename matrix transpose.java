public class NQueens {
	public static int[][] transpose(int[][] a) {
		int[][] b = new int[a[0].length][a.length];
		//a = 3x2
		//b = 2x3
		for(int i = 0; i < a[0].length; i++) {
			int k = 0;
			for(int j = 0; j < a.length; j++) {
				b[i][j] = a[j][i];
			}
		}
		
		return b;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2}, {3,4}, {5,6}};
		int[][] a_transposed = transpose(a);
		
		for(int i = 0; i < a_transposed.length; i++) {
			for(int j = 0; j < a_transposed[i].length; j++) {
				System.out.print(a_transposed[i][j] + " ");
			}
			System.out.println();
		}
	}
}
