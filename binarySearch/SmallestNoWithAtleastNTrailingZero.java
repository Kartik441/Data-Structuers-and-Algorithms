package binarySearch;

public class SmallestNoWithAtleastNTrailingZero {
// No of zeroes is equal to number of 5s in prime factors of x!
// Trailing 0s in x! = Count of 5s prime factors of x!
//                   = floor(x/5) + floor(x/25) + floor(x/125)
	
	static int number(int n)
	{
		if(n == 1)
			return 5;
		
		int start = 0;
		int end = 5*n;
		int ans = 0;
		// binary search
		while(start <= end )
		{
			int mid = start + (end - start)/2;
			
			if(isValid(mid, n)) // in search space we can only have less or equal zeroes
			{
				end = mid - 1;
				ans = mid;
			}
			else
				start = mid + 1;
			
		}
		return ans;
	}
	
	static boolean isValid(int ans, int n)
	{
		int temp = ans;
		int count =0;
		int f = 5;
		
		while(f<=temp)
		{
			count += temp/f;
			f = f*5;
		}
	
		if(count >= n)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		System.out.println(number(5));
		// for 5 it will give 25 but five zeroes are actually not present in any factorial
		

	}

}
