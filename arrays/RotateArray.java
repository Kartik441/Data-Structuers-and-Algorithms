package arrays;

public class RotateArray {
	
	static int[] reverseAlgorithm(int arr[],int k)
	{
		int n=arr.length;
		int i=0;
		int j=n-1-k;
		arr=ReverseArray.reverseArray(arr,i,j);
		arr=ReverseArray.reverseArray(arr, j+1, n-1);
		arr=ReverseArray.reverseArray(arr, 0, n-1);
		return arr;
	}
	
	static int[] jugglingAlgorithm(int arr[],int k)
	{
		int n=arr.length;
		int gcd=3;
		for(int i=0;i<gcd;i++)
		{
			int j=i+k;
			int temp=arr[i];
			while(i!=j)
			{
				arr[j]=temp+arr[j];
				temp=arr[j]-temp;
				arr[j]=arr[j]-temp;      //swapping temp and arr[j]
				j=(j+k)%n;
			}
			arr[i]=temp;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5,6,7,8,9};
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		arr=reverseAlgorithm(arr,3);
//		arr=jugglingAlgorithm(arr,3);
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		

	}

}
