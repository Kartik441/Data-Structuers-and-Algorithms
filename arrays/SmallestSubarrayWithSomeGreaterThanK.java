package arrays;

public class SmallestSubarrayWithSomeGreaterThanK {
	
	static void solve(int a[],int k)
	{
		int n = a.length;
		int sum = 0;
		int size = Integer.MAX_VALUE;
		int i=0;
		int j=0;
		while(i < n && i <= j && j<n)
		{
	
			if(sum <= k)
			{
				sum += a[j];
				j++;
				if(sum >= k)
					size = Math.min(size, (j-i));
			}
			else          // it can be our answer
			{
				// here j will 
				
				size = Math.min(size, (j - i));
				sum -= a[i];
				i++;
			}
		}
		if(size == Integer.MAX_VALUE)
			System.out.println("Not Possible");
		else
			System.out.println(size);
	}

	public static void main(String[] args) {
		int a[] = {1, 4, 45, 6, 0, 19}; 
		solve(a, 51);
		
		int a1[] = {1, 10, 5, 2, 7};
		solve(a1, 9);
		
		int a2[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		solve(a2, 280);
		
		int a3[] = {1, 2, 4};
		solve(a3, 8);
		
		int a4[] = {0, 2, 4, 5, 3};
		solve(a4, 11);
		

	}

}
