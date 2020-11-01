public class NQueens {
	
	//store the number of vertices in a global constant
	public static final int V = 9;
	
	public static int minDist(int[] dist, boolean[] visited) {
		
		int min = Integer.MAX_VALUE, min_idx = -1;
		
		for(int i = 0; i < V; i++) {
			if(visited[i] == false && dist[i] < min) {
				min = dist[i];
				min_idx = i;
			}
		}
		
		return min_idx;
	}
	
	
	public static void printDistance(int[] dist) {
		System.out.println("Vertex \t Distance");
		
		for(int i = 0; i < V; i++) {
			System.out.println(i + "\t" + dist[i]);
		}
	}
	//dijkstra single source shortest path algorithm, time complexity is |V|^2 
	//greedy method, optimization problem min path from source vertex to all other vertices in our graph G = (V, E)
	
	public static void dijkstra(int[][] g, int src) {
		
		int[] dist = new int[V]; //keep track of the min. distances
		boolean[] visited = new boolean[V]; //visited adjacent neighbors
		
		for(int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE; //assign a tentative INFINITY value for e
			visited[i] = false; //initially no vertex has been visited
		}
		
		dist[src] = 0; //the distance from source to source is 0
		
		
		//loop for other V - 1 vertices
		for(int c = 0; c < V - 1; c++) {
			//intermediate vertex u is the vertex adjacent to curr vertex with min. weight
			
			int u = minDist(dist, visited);
			visited[u] = true;
			
			for(int v = 0; v < V; v++) {
				if(g[u][v] != 0 && visited[v] == false && dist[u] != Integer.MAX_VALUE && dist[u] + g[u][v] < dist[v])
					dist[v] = dist[u] + g[u][v]; //set this as min.
			}
		}
		
		printDistance(dist);
	}
	
	public static void main(String[] args) {
		
		//our graph stored in a weight adjacency matrix
		
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
            
            
        //call to our main function
        dijkstra(graph, 0); //our source node is the 0th vertex in the graph
	}
}
