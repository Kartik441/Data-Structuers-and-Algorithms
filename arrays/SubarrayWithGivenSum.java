package arrays;
// this can be done using hashing as well (it will handle negative numbers as well)
// here is using two pointer algorithm (sliding window) 
public class SubarrayWithGivenSum {

	
	static void solve(int a[], int sum)
	{
		int n = a.length;
		
		int i=0, j=0;
		int st = -1, end = -1, currSum = 0;
		
		while(j<n && currSum + a[j] <= sum)
		{
			currSum += a[j];
			j++;
		}
		
		if(currSum == sum)
		{
			System.out.println(i+1 + " "+j);
			return;
		}
		while(j<n)
		{
			currSum += a[j];
			while(currSum > sum)
			{
				currSum -= a[i];
				i++;
			}
			if(currSum == sum)
			{
				st = i+1;
				end = j+1;
				break;
			}
			j++;
		}
		System.out.println(st+" "+end);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 3, 7, 5};
		solve(a, 12);
		int a1[] = {1, 2, 3, 8};
		solve(a1, 5);

	}

}
