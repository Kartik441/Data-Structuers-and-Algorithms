package arrays;

public class CountInversions {
	static int invCount = 0;
	static void count(int a[], int start, int end)
	{
		if(start < end)
		{
			int mid = (start + end)/2;
			
			count(a, start, mid);
			count(a, mid+1, end);
			
			merge(a, start, end);
		}
		
	}
	
	static void merge(int a[],int start, int end)
	{
		int mid = (start + end)/2;
		int temp[] = new int[a.length];
		
		int i = start;
		int j = mid+1;
		int k = start;
		
		while(i<=mid && j <=end)
		{
			if(a[i] < a[j])
			{
				temp[k] = a[i];
				i++;
				k++;
			}
			else
			{
				// this is the main point different from merge sort that gives answer
				if(a[i] > a[j])
				{
					invCount += (mid - i)+1;
				}
				temp[k] = a[j];
				j++;
				k++;
			}
		}
		
		while(i<=mid)
		{
			temp[k] = a[i];
			i++;
			k++;
		}
		while(j<=end)
		{
			temp[k] = a[j];
			j++;
			k++;
		}
		
		for(int s = start;s<=end;s++)
		{
			a[s] = temp[s];
		}
	}

	public static void main(String[] args) {
		int a[] = {8, 4, 2, 1};
		count(a, 0, a.length-1);
		System.out.println(invCount);
		invCount = 0;
		
		int a1[] = {3, 1, 2};
		count(a1, 0, a1.length-1);
		System.out.println(invCount);
		invCount = 0;
		
		int a2[] = {1, 9, 6, 4, 5};
		count(a2, 0, a2.length-1);
		System.out.println(invCount);
		invCount = 0;

	}

}
