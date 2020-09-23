public class NQueens {
	//create a new character array of the string and sort it
	//if they are the equivalent then they are permutations of one another
	
	public static String sort(String x) {
		char[] c = x.toCharArray();
		java.util.Arrays.sort(c);
		return new String(c);
	}
	
	public static boolean isPermutation(String x, String y) {
		if(x.length() != y.length())
			return false; //if they differ in length return false automatically
		return sort(x).equals(sort(y));
	}
	
	public static void main(String[] args) {
		String x = "allen";
		String y = "nelal";
		
		boolean result = isPermutation(x, y);
		
		System.out.println("Are the strings a permutation(reordering) of one another: " + result);
	}
}
