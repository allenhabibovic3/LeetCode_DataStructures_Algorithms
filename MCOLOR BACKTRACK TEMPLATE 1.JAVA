public class NQueens {
	
	static int[] vColor;
	static int m;
	static int n;
	static int[][] W;
	
	public static void mColor(int[][] W, int i, int[] vColor, int m, int n) {
		int color;
		
		if(isPromising(W, vColor, i)) {
			if(i == n) {
				for(int k = 1; k <= n; k++)
					System.out.print(vColor[k] + " ");
				System.out.println();
			}else {
				for(color = 1; color <= m; color++) {
					vColor[i+1] = color;
					mColor(W, i+1, vColor, m, n);
				}
			}
		}
	}
	
	public static boolean isPromising(int[][] W, int[] vColor, int i) {
		
		int j;
		boolean result;
		
		result = true;
		j = 1;
		
		while(j < i && result) {
			if(W[i][j] == 1 && vColor[i] == vColor[j])
				result = false;
			j++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		n = 6;
		vColor = new int[n+1];
		int[][] G =
			{		{0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 1, 1, 0, 1, 1},
					 {0, 1, 0, 1, 1, 0, 1},
					 {0, 1, 1, 0, 1, 1, 0},
					 {0, 0, 1, 1, 0, 1, 1},
					 {0, 1, 0, 1, 1, 0, 1},
					 {0, 1, 1, 0, 1, 1, 0}};

		W = G;
		m = 3;
		vColor[0] = 0;
		mColor(W, 0, vColor, m, n);
	}
}
