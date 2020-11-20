package dynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
	
	static int t[][] = new int[10000][10000];
	
	static int MCMrec(int []arr, int i, int j)
	{
		if(i >= j)
			return 0;
		
		if(t[i][j]!=-1)
			return t[i][j];
		
		int mn = Integer.MAX_VALUE;
		
		for(int k = i; k<= j-1 ; k++)
		{
			int tempAns = MCMrec(arr, i, k) + MCMrec(arr, k+1, j) +
					arr[i-1] * arr[k] * arr[j];
			if(tempAns < mn)
				mn = tempAns;
			
		}
		
		return t[i][j] = mn;
	}
	
	static void MCM(int[] mat)
	{
		int n = mat.length;
		// actually there are n-1 matrices
		// so dp size will be n-1
		int dp[][] = new int[mat.length-1][mat.length-1];
		n = dp.length;
		for(int g=0;g<n;g++)
		{
			for(int i=0, j=g;j<n;i++, j++)
			{
				if(g == 0)
					dp[i][j] = 0;
				else if(g == 1)
					dp[i][j] = mat[i] * mat[j] * mat[j+1];
				else
				{
					int min = Integer.MIN_VALUE;
					for(int k=i;k<j;k++)
					{
						// i, k ->left half; k+1, j->right half
						int lc = dp[i][k];
						int rc = dp[k+1][j];
						
						int mc = mat[i] * mat[k+1] * mat[j+1];
						
						int cost = lc + rc + mc;
						if(cost < min)
							min = cost;
					}
					dp[i][j] = min;
				}
			}
		}
		
		System.out.println(dp[0][n-1]);
	}

	public static void main(String[] args) {
//		int arr[] = {40, 20, 30, 10, 30};
//		
//		int arr1[] = {10, 20, 30, 40, 30};
		int arr2[] = {10, 20, 30};
		
		for(int a[] : t)
			Arrays.fill(a, -1);
		System.out.println(MCMrec(arr2, 1, arr2.length - 1));
		
		MCM(arr2);

	}
}
