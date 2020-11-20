package binarySearch;

public class RotiPrataSpoj {
	
	static int  minTime(int rank[], int par)
	{
		int n = rank.length;
		int start = 0;
		int end = -1;
		int maxR = 0;
		for(int i:rank)
		{
			maxR = Math.max(i,maxR);
		}
		int ans = -1;
		end = maxR * ((par*(par+1))/2);
		
		while(start <= end)
		{
			int mid = start +(end - start)/2;
			
			if(isPossible(rank, par, mid))
			{
				ans = mid;
				end = mid - 1;
			}
			else
				start = mid+1;
		}
		return ans;
	}
	
	static boolean isPossible(int rank[], int par, int ans)
	{
		int parMade = 0;
		int time = 0;
		for(int i=0;i<rank.length;i++)
		{
			int count = 1;
			time = 0;
			//System.out.println(parMade);
			while(time < ans)
			{
				if(time + count*rank[i] <= ans)
				{
					time += count * rank[i];
					parMade++;
					count++;
					if(parMade >= par)
						return true;
				}
				else
					break;         // go for the next cook
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int rank[] = { 1, 2, 3, 4};
		System.out.println(minTime(rank, 10));
		int rank1[] = {1};
		System.out.println(minTime(rank1, 8));
		int rank2[]= {1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(minTime(rank2, 8));
		

	}

}
