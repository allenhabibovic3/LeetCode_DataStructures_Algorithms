public class NQueens {
	
	static int numCheckedNodes = 0;
	static int[] vIndex;
	
	public static void hamiltonian(boolean[][] W, int i, int n) {
		int j;
    	numCheckedNodes++;
    	if(isPromising(W, i, n)) {
    		if(i == (n-1)) {
    			System.out.print("Solution: ");
    			for(int k = 0; k < n; k++)
    				System.out.print(vIndex[k] + " ");
    			System.out.println();
    		}else {
    			for(j = 2; j <= n; j++) {
    				vIndex[i+1] = j;
    				hamiltonian(W, i+1, n);
    			}
    		}
    	}
	}
	
	public static boolean isPromising(boolean[][] W, int i, int n) {
		boolean result;
        int index;
        
        if((i == (n - 1)) && (!W[vIndex[n-1]][vIndex[0]]))
        	result = false;
        else if((i > 0) && (!W[vIndex[i-1]][vIndex[i]]))
        	result = false;
        else {
        	
        	result = true;
        	
        	index = 1;
        	
        	while(index < i && result) {
        		if(vIndex[i] == vIndex[index]) {
        			result = false;
        		}
        		index++;
        	}
        }
        return result;
	}
	
	public static void main(String[] args) {
		int n = 8; //number of nodes in g
		boolean[][] W = {
                {false, false, false, false, false, false, false, false, false},
                {false, true, true, true, false, false, false, false, true},
                {false, true, true, true, false, false, false, true, true},
                {false, true, true, true, true, false, true, false, false},
                {false, false, false, true, true, true, false, false, false},
                {false, false, false, false, true, true, true, false, false},
                {false, false, false, true, false, true, true, true, false},
                {false, true, true, false, false, false, false, true, true},
                {false, true, true, false, false, false, false, true, true},
                };
		
		vIndex = new int[n];
        vIndex[0] = 1; 
        
        
		hamiltonian(W, 0, n);
		
		System.out.println("Number of checked nodes: " + numCheckedNodes);
	}
}
