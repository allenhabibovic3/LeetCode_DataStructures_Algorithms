public class NQueens {
	public static double standardDeviation(double[] data) {
		//first compute the mean -> sum(data)/n
		int n = data.length;
		double sum = 0.0;
		
		for(int i = 0; i < n; i++) {
			sum += data[i];
		}
		
		double mean = sum/n;
		
		//sum the square difference
		
		double squareDifferenceSum = 0.0;
		
		for(int i = 0; i < n; i++) {
			squareDifferenceSum += Math.pow((data[i] - mean), 2);
		}
		
		squareDifferenceSum /= n-1;
		return Math.sqrt(squareDifferenceSum);
	}
	
	public static void main(String[] args) {
		//standard deviation -> quantitative measure for how spread our data is from the mean(avg)
		//Sample standard deviation = sqrt(1/(n-1) * SUM(xi - mean)^2)
		
		double[] data = {2.3, 2.1, 2.2, 2.0, 1.0, 8.3, 4.3, 3.3};
		double sd = standardDeviation(data);
		
		System.out.println("The standard deviation for the data is: " + sd);
	}
}
