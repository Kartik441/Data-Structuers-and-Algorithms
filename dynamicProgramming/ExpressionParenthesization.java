package dynamicProgramming;

// return no of ways of parenthesization such that given expression gives the true output

public class ExpressionParenthesization {
	
	static int solve(String s, int i, int j, boolean isTrue)
	{
		if(i > j)
			return 0;
		if(i == j)
		{
			if(isTrue)
			{
				if(s.charAt(i) == 'T')
					return 1;
				else
					return 0;
			}
			else
			{
				if(s.charAt(i) == 'F')
					return 1;
				else
					return 0;
			}
		}
		
		int ans = 0;
		
		for(int k = i+1; k<=j-1; k+=2)   // k should always point at the operand
		{
			// ways to create true from left side
			int lt = solve(s, i, k-1, true);
			//similarly calculating others
			int lf = solve(s, i, k-1, false);
			int rt = solve(s, k+1, j, true);
			int rf = solve(s, k+1, j, false);
			
			if(s.charAt(k) == '&')
			{
				if(isTrue == true)
					ans = ans + lt * rt;
				else
					ans = ans + lf * rf + lf * rt + lt * rf;
			}
			
			else if(s.charAt(k) == '|')
			{
				if(isTrue == true)
					ans = ans + lt * rt + lt * rf + lf * rt;
				else
					ans = ans + lf * rf;
			}
			
			else if(s.charAt(k) == '^')
			{
				if(isTrue == true)
					ans = ans + lt * rf + lf * rt;
				else
					ans = ans + lf * rf + lt * rt; 
			}
			
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
//		String s = "T^F&T";
//		String s = "T^F|F";
		String s = "T|T&F^T";
		boolean isTrue = true;
		
		System.out.println(solve(s, 0, s.length()-1, isTrue));
		
		// This  question can also be given in the below  format
		// symbol[] = {T, T, F, T}
		// operator[] = {|, &, ^}

	}

}
