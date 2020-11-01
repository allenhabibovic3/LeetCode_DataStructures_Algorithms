import java.util.Vector;


//greedy method implemented with a Vector object from java.util.Vector
public class NQueens {
	public static void findMinCoins(int V) {
		
		int[] D = {25, 10, 5, 1};
		int n = D.length;
		
		Vector<Integer> res = new Vector<Integer>();
		
		for(int i = 0; i < n; i++) {
			while(V >= D[i]) {
				V -= D[i];
				res.add(D[i]);
			}
		}
		
		System.out.println("Minimum # of coins needed: " + res.size());
		
		for(int i = 0; i < res.size(); i++) {
			System.out.print(res.elementAt(i) + " ");
		}
	}
	
	public static void main(String[] args) {
		
		int V = 90;
		
		findMinCoins(V);
	}
}
