package backtracking;

import java.util.ArrayList;
// if even length than subset should be of same size else only diff of one is allowed
public class TugOfWar {
	
	static int minDiff = Integer.MAX_VALUE;
	static String ans = " ";
	
	
	static void solve(int []arr, int i, int sum1, int sum2, ArrayList<Integer> set1,
			ArrayList<Integer> set2)
	{
		if(i == arr.length)
		{
			if(Math.abs(sum1 - sum2) < minDiff)
			{
				minDiff = Math.abs(sum1 - sum2);
				ans = set1 + " " +set2;
			}
			
			return;
		}
		
		if(set1.size() < (arr.length + 1)/2)
		{
			set1.add(arr[i]);
			solve(arr, i+1, sum1+arr[i], sum2, set1, set2);
			set1.remove(set1.size() - 1);
		}
		
		if(set2.size() < (arr.length + 1)/2)
		{
			set2.add(arr[i]);
			solve(arr, i+1, sum1, sum2+arr[i], set1, set2);
			set2.remove(set2.size() - 1);
		}
	}

	public static void main(String[] args) {
		int a[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
		solve(a, 0, 0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
		System.out.println(ans);
		minDiff = Integer.MAX_VALUE;
		ans = "";
		
		int a1[] = {23, 45, -34, 12, 00, 98, -99, 4, 189, -1, 4};
		solve(a1, 0, 0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
		System.out.println(ans);
		minDiff = 0;
		ans = "";
		

	}

}
