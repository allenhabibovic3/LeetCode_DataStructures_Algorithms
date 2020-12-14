public static void firstAndLastPos(int[] a, int x) {
		//sort a
		//java.util.Arrays.sort(a); best performance sorting
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == x) {
				System.out.println("\nfirst occurence at index: " + i);
				break;
			}
		}
		
		for(int j = a.length - 1; j > 0; j--) {
			if(a[j] == x) {
				System.out.println("last occurence at index: " + j);
				break;
			}
		}
	}
