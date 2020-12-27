import java.util.Scanner;
public class NQueens {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		for(int i = 1; i <= n; i++) {
			int a1 = i*i;
			int a2 = (a1*(a1-1))/2;
			
			if(i > 2) {
				a2 -= 4*(i-1)*(i-2);
			}
			System.out.println(a2);
		}
		
		
	}
}
