//if the number of rows is odd then subtract away the a[mid][mid] once from the total sum of the primary and seconday diagonals

public class NQueens {
	
	public static int diagonalSum(int[][] mat) {
        if(mat.length == 1 && mat[0].length == 1){
            return mat[0][0];
        }
        int leftSum = 0, rightSum = 0;
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(i == j)
                    leftSum += mat[i][j];
                if(i == mat.length - 1 - j)
                	rightSum += mat[i][j];
            }
        }
        
        
        
        int totalSum = leftSum + rightSum;
        if(mat.length % 2 == 1) {
            int mid = (int) Math.ceil(mat.length/2);
            totalSum -= mat[mid][mid];
        }
        
        
        return totalSum;
    }
	
	public static void main(String[] args) {
		
		int[][] x = {{1,2,3, 1}, {4,5,6, 1}, {7,8,9, 1}, {1,1,1,1}};
		
		
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < x[i].length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
		int sum = diagonalSum(x);
		System.out.println("The sum of the diagonals is: " + sum);
		
	}
}
