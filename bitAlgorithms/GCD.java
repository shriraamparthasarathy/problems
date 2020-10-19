package bitAlgorithms;

public class GCD 
{
	static int findGCD(int a,int b)
	{
		if(b==0&&a==b)
			return a;
		if(a==0)
			return b;
		if(b==0)
			return a;
		if(((a&1)>0)&&((b&1)>0))
			return 2*findGCD(a>>1,b>>1);
		if(((a&1)>0)&&((b&1)==0))
			return findGCD(a>>1,b);
		if(((a&1)==0)&&((b&1)>0))
			return findGCD(a,b>>1);
		
		return (a>b)?findGCD(a-b,b):findGCD(a,b-a);
	}
	public static void main(String args[])
	{
		int a=42,b=56;
		System.out.println("GCD is: "+findGCD(a,b));
	}
}
//algo euclids
//Below are some important observations. The idea is to use bitwise operators. We can find x/2 using x>>1. We can check whether x is odd or even using x&1.
//
//gcd(a, b) = 2*gcd(a/2, b/2) if both a and b are even.
//gcd(a, b) = gcd(a/2, b) if a is even and b is odd.
//gcd(a, b) = gcd(a, b/2) if a is odd and b is even.