package arrays;


// product[i] is equal to product of every element instead of arr[i] without using division
// we can use two arrays for storing left and right product
public class ProductPuzzle {
	
	// Epsilon value to maintain precision
	
	static final double EPS = 1e-9;
	
	static void solve(int a[])
	{
		int n = a.length;
		double sum = 0;
		for(int i=0;i<n;i++)
		{
			sum+=Math.log10(a[i]);
		}
		
		// antilog to find original product value
		for(int i = 0;i<n;i++)
		{
			System.out.print((int) (EPS + Math.pow(10, sum - Math.log10(a[i]))) + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10, 3, 5, 6, 2};
		solve(a);

	}

}
