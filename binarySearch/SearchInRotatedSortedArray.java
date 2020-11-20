package binarySearch;

public class SearchInRotatedSortedArray {
	
	// beware of using = sign correctly for passing all test cases
	
	static int search(int a[], int x)
	{
		int i = 0;
		int j = a.length - 1;
		int ans = -1;
		while(i <= j)
		{
			int mid = i + (j-i)/2;
			
			if(a[mid] == x)
			{
				ans = mid;
				break;
			}
			
			else if(a[i] <= a[mid])         // if left side is sorted array
			{
				if(x <= a[mid] && x >= a[i])     
				{
					j = mid - 1;
				}
				
				else
				{
					i = mid + 1;
				}
			}
			
			else          // if right side is sorted array
			{
				if(x >= a[mid] && x <= a[j])
				{
					i = mid + 1;
				}
				else
				{
					j = mid - 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		
		System.out.println(search(a, 1));
		

	}

}
