package arrays;

public class MissingNumber {
	
	//list of n-1 integers ranging form 1 to n.No duplicates.Find missing no.
	static int missingNumber(int arr[])
	{
		int sum=0;
		int n=arr.length+1;
		int tsum=(n*(n+1))/2;
		for(int i:arr)
			sum+=i;
		return tsum-sum;
		
	}

	public static void main(String[] args) {
		int arr[]= {1,2,4,5,6,3,8,9};
		System.out.println(missingNumber(arr));

	}

}
//Another Method:Using XOR, which is faster