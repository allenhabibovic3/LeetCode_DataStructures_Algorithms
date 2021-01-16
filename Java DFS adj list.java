package chapter07;
import java.util.*; //includes the LinkedList object, which we will make a list of lists to represent graph G
//adjancey list representation
//time complexity: O(|V| + |E|), Space complexity: O(|V|) -> due to storing the visited boolean array

public class Graph {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	public Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void DFSUtil(int s, boolean[] visited) {
		
		visited[s] = true;
		System.out.print(s + " ");
		
		Iterator<Integer> i = adj[s].listIterator();
		
		while(i.hasNext()) {
			int n = i.next();
			
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	public void DFS(int s) {
		boolean[] visited = new boolean[V];
		DFSUtil(s, visited);
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        g.DFS(2);
	}
}
