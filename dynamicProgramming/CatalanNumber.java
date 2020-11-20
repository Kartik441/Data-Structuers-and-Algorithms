package dynamicProgramming;

public class CatalanNumber {
// catalan number can be used to give number of binary search tree possible with n nodes
// same code can be used
	static void solve(int n)
	{
		int []dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<dp.length;i++)
		{
			for(int j = 0;j<i;j++)
			{
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		
		System.out.println(dp[n]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(5);

	}

}
