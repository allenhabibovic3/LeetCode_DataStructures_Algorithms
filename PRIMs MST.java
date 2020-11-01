//prims algorithm to find the MST(minimum spanning tree)
//time complexity for prims: O(n^2) where n = # of vertices
// # of unique minimum spanning trees = (|E|C|V|-1) - # of cycles in G


public class NQueens {
	public static final int V = 5;
	
	public static int minKey(int[] key, boolean[] visited) {
		int min = Integer.MAX_VALUE, min_idx = -1;
		
		for(int i = 0; i < V; i++) {
			if(visited[i] == false && key[i] < min) {
				min = key[i];
				min_idx = i;
			}
		}
		
		return min_idx;
	}
	
	public static void printEdges(int[] MST, int[][] g) {
		System.out.println("Edge \t Cost");
		
		for(int i = 1; i < V; i++) {
			System.out.println(MST[i] + " - " + i + "\t" + g[i][MST[i]]);
		}
	}
	
	public static void primMST(int[][] g) {
		int[] key = new int[V];
		int[] MST = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		key[0] = 0;
		MST[0] = -1;
		
		
		for(int c = 0; c < V - 1; c++) {
			int u = minKey(key, visited);
			visited[u] = true;
			
			for(int v = 0; v < V; v++) {
				if(g[u][v] != 0 && visited[v] == false && g[u][v] < key[v]) {
					MST[v] = u;
					key[v] = g[u][v];
				}
			}
		}
		
		printEdges(MST, g);
	}
	
	public static void main(String[] args) {
		
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
		
		primMST(graph);
	}
}
