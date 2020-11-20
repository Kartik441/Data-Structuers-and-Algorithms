package arrays;

import java.util.Arrays;

public class MathsUtil {
	
	
	// sieve of erato sthenes
	static boolean[] prime(int n)
	{
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2;i*i <=n ;i++)
		{
			for(int j = 2*i ;j<=n ;j+=i)
			{
				isPrime[j] = false; 
			}
			
		}
		return isPrime;
	}
	
	// Euclids hypothesis
	// gcd(a,b) = gcd(a-b, b)  =>  till one of them  is 0 and other is answer
	// gcd(a,b) = gcd(b, a%b), a%b!=0
	static int gcd(int a, int b)
	{
		if(b == 0)
			return a;
		else
			return gcd(b, a%b);
			
	}
	
	// power function: O(log n)
	
	static int fastPow(int a, int b)
	{
		int res = 1;
		while(b>0)
		{
			if((b&1) == 1)
			{
				res = res*a;
			}
			a = a*a;
//			b = b/2;
			b = b >> 1;   // right shift by 1 divide by 2
			// left shift by 1 multiply by 2
			
		}
		return res;
	}
	
	// fast power using modulo 
	//(a*b)%n = (a%n * b%n)%n
	
	static long fastPowModulo(long a, long b, long n)
	{
		long res = 1;
		while(b>0)
		{
			if((b&1) == 1)
			{
//				res = (res %n * a%n)%n;
				res = (res * a%n)%n;
			}
			a = (a%n *a%n)%n;
//			b = b/2;
			b = b >> 1;   // right shift by 1 divide by 2
			// left shift by 1 multiply by 2
			
		}
		return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isPrime[] = prime(20);
		for(boolean a: isPrime)
		{
			System.out.println(a);
		}
		
		System.out.println(gcd(24, 72));
		System.out.println(fastPowModulo(3978432, 5, 1000000007));

	}

}
