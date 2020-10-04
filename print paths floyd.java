public class NQueens {
	public static final int V = 4;
	public static final int INF = Integer.MAX_VALUE;
	
	public static void floydWarshall(int[][] graph) {
		int[][] dist = new int[V][V];
		int[][] path = new int[V][V];
		
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
				
				if(i == j) //diagonal
					path[i][j] = 0;
				else if(dist[i][j] != INF)
					path[i][j] = i;
				else
					path[i][j] = -1;
			}
		}
		
		for(int k = 0; k < V; k++) {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					if(dist[i][k] + dist[k][j] < dist[i][j] && dist[i][k] != INF && dist[k][j] != INF) {
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		
		printDistanceMatrix(dist, path);
	}
	
	public static void printPath(int[][] path, int start, int end) {
		if(path[start][end] == 0)
			return;
		
		printPath(path, start, path[start][end]);
		System.out.print(path[start][end] + " ");
	}
	
	public static void printDistanceMatrix(int[][] dist, int[][] path) {
		System.out.println("Distance(COST) matrix for all pairs of vertices: ");
		
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if(dist[i][j] == INF)
					System.out.print("INF");
				else
					System.out.print(" " + dist[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Shortest path for all pairs of vertices: ");
		
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if(i != j && path[i][j] != -1) {
					System.out.print("Shortest path from vertex " + i + " to " + j + " is ( " + i);
					printPath(path, i, j);
					System.out.println(" " + j + " )");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] adjacency_matrix = { {0, 3, INF, 7}, 
									 {8, 0, 2, INF}, 
									 {5, INF, 0, 1}, 
									 {2, INF, INF, 0} };
		
		floydWarshall(adjacency_matrix);
	}
}
