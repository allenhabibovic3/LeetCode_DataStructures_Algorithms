public class NQueens {
	//longest substring without repeating characters
	
	public static int length(String s) {
		int n = s.length();
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			boolean[] visited = new boolean[256];
			
			for(int j = i; j < n; j++) {
				if(visited[s.charAt(j)] == true)
					break;
				else {
					result = Math.max(result, j - i + 1);
					visited[s.charAt(j)] = true;
				}
			}
			
			visited[s.charAt(i)] = true;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeeks"; 
		int result = length(str);
		
		System.out.println(result);
	}
	
}
