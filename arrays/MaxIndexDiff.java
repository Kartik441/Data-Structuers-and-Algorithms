package arrays;

// Given an array find the max j - i such that arr[j] > arr[i]
// One method is to use hashing to store the indexes and than sort the array
// Its time complexity: O(nlogn)



public class MaxIndexDiff {
// This is O(n) solution
	
	static int maxIndexDiff(int a[])
	{
		int n = a.length;
		int i, j;
		
		int RMax[] = new int[n];
		int LMin[] = new int[n];
		
		for(i = 1;i<n;i++)
		{
			LMin[i] = Math.min(a[i], a[i-1]);
		}
		
		for(j=n-2;j>=0;j--)
		{
			RMax[j] = Math.max(a[j], a[j+1]);
		}
		
		// traverse both arrays from left to right to find optimal j-i 
		// This is similar to merge of mergeSort
		
		i = 0;
		j=0;
		int maxDiff = -1;
		while(j<n && i<n)
		{
			if(LMin[i] < RMax[j])
			{
				maxDiff = Math.max(maxDiff, j-i - 1);
				j = j+1;
			}
			else
			{
				i = i+1;
			}
		}
		return maxDiff ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		int a1[] = {1,33, 5, 23, 4, 54, 55};
		int a2[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		int a3[] = {6, 5, 4, 3, 2, 1};     // Not giving correct answer
		System.out.println(maxIndexDiff(a));

	}

}
