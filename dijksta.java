//dijkstra greedy algorithms for shortest path between start and end node
//O(|V|^2)

public class NQueens {
	public static final int V = 9;
	
	public static int minDistance(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE, min_idx = -1;
		
		for(int i = 0; i < V; i++) {
			if(dist[i] < min && sptSet[i] == false) {
				min = dist[i];
				min_idx = i;
			}
		}
		
		return min_idx;
	}
	
	public static void printDistance(int[] dist) {
		System.out.println("The distance from vertex 0 to all the other nodes: ");
		System.out.println("VERTEX \t DISTANCE");
		
		for(int i = 0; i < V; i++) {
			System.out.println(i + "\t" + dist[i]);
		}
	}
	
	public static void dijkstra(int[][] graph, int source) {
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];
		
		
		//initially set all the distance to infinity as a tentative value
		//no nodes have been visited so far
		for(int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		//source node has a distance of 0 from itself
		dist[source] = 0;
		
		for(int c = 0; c < V - 1; c++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true; //visited
			for(int v = 0; v < V; v++) {
				if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}
		
		printDistance(dist);
	}
	
	public static void main(String[] args) {
		
		//adjacency matrix representing weights between node i -> node j 
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
            
            //start vertix is 0
            dijkstra(graph, 0);
	}
}
