public class NQueens {
	
	public static int longestIncreasingSubSequence(int[] arr) {
		
		int[] len = new int[arr.length];
		int[] sequence = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			len[i] = 1;
			sequence[i] = i;
		}
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					if(len[j] + 1 > len[i]) {
						len[i] = len[j] + 1;
						sequence[i] = j;
					}
				}
			}
		}
		
		//find the max index in len array
		
		int maxIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(len[i] > len[maxIndex])
				maxIndex = i;
		}
		
		//print the actual sequence
		int temp = maxIndex;
		int curr = maxIndex;
		
		do {
			temp = curr;
			System.out.print(arr[temp] + " ");
			curr = sequence[temp];
		}while(temp != curr);
		System.out.println();
		//solution is at len[maxIndex];
		return len[maxIndex];
	}
	
	public static void main(String[] args) {
		
		int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
		int len = longestIncreasingSubSequence(arr);
		
		System.out.print("The length of the longest common subsequence of the given array is: " + len);
		
	}
}
