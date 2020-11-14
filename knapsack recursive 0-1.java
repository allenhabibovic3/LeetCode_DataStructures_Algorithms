

public class NQueens {
	
	//recursive implementation of the 0/1 KNAPSACK programming problem
	
	public static int knapsack(int W, int[] wt, int[] val, int n) {
		
		//W = is the capacity of the bag where the sum of all the weights <= W
		//wt[] is the list of the items respective weights
		//val[] is the list of the items respective profits
		//n is the # of items
		
		//base case if # of items is 0 or if the total capacity(W) = 0, return 0
		
		if(n == 0 || W == 0)
			return 0;
		else if(W < wt[n-1])
			return knapsack(W, wt, val, n-1);
		else
			return Math.max(val[n-1] + knapsack(W - wt[n-1], wt, val, n - 1), knapsack(W, wt, val, n - 1));
	}
	
	public static void main(String[] args) {
		
		int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length;
        
        int max_profit = knapsack(W, wt, val, n);
        
        System.out.println("The maximum profit possible is: " + max_profit);
        
        //output for this instance of KNAPSACK 0/1 is $220
	}
}
