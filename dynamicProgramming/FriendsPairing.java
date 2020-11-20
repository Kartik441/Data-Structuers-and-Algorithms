package dynamicProgramming;
// given n friends output the total number of ways in which they can be paired up
public class FriendsPairing {
	
	static void solve(int n)
	{
		int []dp = new int[n+1];
		dp[1] =1;
		dp[2] = 2;
		// if n-th person remains single than recur for f(n-1)
		//else it pairs with any of the remaining n-1 persons
		for(int i=3;i<=n;i++)
		{
			dp[n] = dp[n-1] + (n-1) * dp[n-2];
		}
		
		System.out.println(dp[n]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(3);

	}

}
