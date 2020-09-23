//shift all the zeros in the array to the end of the array

public class PROBLEM {
  public static void moveZerosToEnd(int[] a) {
    int n = a.length;
    int zeroCount = 0;
    
    for(int i = 0; i < n; i++) {
      if(a[i] != 0)
        a[zeroCount++] = a[i];
    }
    
    while(zeroCount < n)
      a[zeroCount++] = 0;
  }

  public static void main(String[] args) {
    int[] a = {2,0,0,3,4,5,0};
    
    System.out.println("Before shift:");
    for(int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
      
    moveZerosToEnd(a);
    System.out.println("\nMove zeros to end:");
    for(int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
  }
}
