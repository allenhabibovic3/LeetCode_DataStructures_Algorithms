import java.util.Arrays;

public class NQueens {
	
	public static int N = 8;
	
	public static boolean isPromising(char[][] B, int r, int c) {
		
		int i, j;
		
    //check column
		for(i = 0; i < r; i++)
			if(B[i][c] == 'Q')
				return false;
		
    //check main diagonal
		for(i = r, j = c; i >= 0 && j >= 0; i--, j--)
			if(B[i][j] == 'Q')
				return false;
		//check other diagonal
		for(i = r, j = c; i >= 0 && j < N; i--, j++)
			if(B[i][j] == 'Q')
				return false;
		
		return true;
	}
	
	public static void solveNQ(char[][] board, int r) {
		
		if(r == N) {
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(" " + board[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println();
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isPromising(board, r, i)) {
				board[r][i] = 'Q';
				solveNQ(board, r+1);
				board[r][i] = '-';
			}
		}
	}
	
	public static void main(String[] args) {
		char[][] B = new char[N][N];
		
		for(int i = 0; i < N; i++)
			Arrays.fill(B[i], '-');
		
		NQueens NQ = new NQueens();
		NQ.solveNQ(B, 0);
	}
}
