package bitAlgorithms;
//Write a function that, for a given no n, finds a number p which is greater than or equal to n and is a smallest power of 2.
//Examples :
//
//    Input : n = 5
//    Output: 8     
//
//    Input  : n = 17
//    Output : 32     
//
//    Input  : n = 32
//    Output : 32    
public class NextPowerOf2 
{
	static int findNextPowerof2(int n)
	{
		if((n&n-1)==0)
			return n;
		int p=1;
		while(p<n)
			p<<=1;
		return p;
	}
	public static void main(String args[])
	{
		int n=5;
		System.out.println("The next power of "+n+" is "+findNextPowerof2(n));
	}
}
//algo: time complexity O(lgn)
//we shift the result one by one in a loop.