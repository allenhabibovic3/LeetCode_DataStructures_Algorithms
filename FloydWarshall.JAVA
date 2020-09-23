public class NQueens {
	public static final int INF = Integer.MAX_VALUE;
	public static final int V = 4;
	
	public static void floydWarshall(int[][] graph) {
		//create a distance matrix same size, and initially copy over all elements from passed in graph
		
		int[][] dist = new int[V][V];
		
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}
		
		//use k as an intermediate matrix, if dist going thru k is less than going thru i -> j directly update
		
		for(int k = 0; k < V; k++) {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					if(dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j]; //check for integer overflow for intermediate traversal
				}
			}
		}
		
		printDistanceMatrix(dist);
	}
	
	public static void printDistanceMatrix(int[][] dist) {
		System.out.println("DISTANCE MATRIX FOR ALL PAIRS OF VERTICES: ");
		
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if(dist[i][j] == INF) {
					System.out.print("INF ");
				}else {
					System.out.print(dist[i][j] + "   ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		//graph is an adjacency matrix, INF represents no edge between (i, j)
		//running time is O(|V|^3)
		//returns a distance matrix representing the shortest distance between all pairs of vertices
		int graph[][] = { {0,   5,  INF, 10}, 
                {INF, 0,   3, INF}, 
                {INF, INF, 0,   1}, 
                {INF, INF, INF, 0} 
              }; 
		
		floydWarshall(graph);
	}
}
