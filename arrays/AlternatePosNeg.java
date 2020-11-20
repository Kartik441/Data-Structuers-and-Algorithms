package arrays;
// Variation of this could be to maintain order while arranging
public class AlternatePosNeg {
	
	static int[] alternateUnordered(int []arr)
	{
		int i=0;
		int j=arr.length-1;
		
		while(i<=j)
		{
			while(i<arr.length &&arr[i]<0)
				i++;
			while(j>=0 && arr[j]>0)
				j--;
			
			// swapping values at i and j
			if(i<=j) {      // This condition is important
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[]= {-1,3,5,-6,245,-56,78,45,-23,-58,27,-7,8};
		arr=alternateUnordered(arr);
		for(int i:arr)
			System.out.print(i+" ");


	}

}
