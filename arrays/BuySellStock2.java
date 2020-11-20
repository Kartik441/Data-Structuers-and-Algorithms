package arrays;

public class BuySellStock2 {
	
	// buy and sell stock if infinite transactions are allowed
	
	static int maxProfit(int price[])
	{
		int n = price.length;
		
		int sd=0;
		int bd=0;
		int profit = 0;
		
		for(int i=0; i<n-1;i++)
		{
//			if(price[i+1] >= price[i])
//			{
//				sd++;
//			}
//			else
//			{
//				profit += price[sd] - price[bd];
//				bd = sd = i;
//			}
			
			if(price[i+1] < price[i])
			{
				profit += price[sd] - price[bd];
				bd++;
				sd++;
			}
			else
			{
				sd++;
			}
		}
		// after loop collect one more last stroke
		profit += price[sd] - price[bd];
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[] = {3, 1, 2, 3};
		System.out.println(maxProfit(price));

	}

}
