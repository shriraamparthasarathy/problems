package dynamicProgramming;
//You are given n pairs of numbers. In every pair, the first number is always smaller than
//the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs 
//can be formed in this fashion. Find the longest chain which can be formed from a given set 
//of pairs.
//Source: Amazon Interview | Set 2
//
//For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, then
//the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40},
//	{50, 90}}
public class DpMaxLenOfChainPairs
{
	static class Pair
	{ 
		int a; 
		int b; 
		
		Pair(int a, int b) 
		{ 
			this.a = a; 
			this.b = b; 
		} 
	};	
	static int maxChainLength(Pair arr[], int n) 
	{ 
		int i, j, max = 0; 
		int mcl[] = new int[n]; 
		for ( i = 0; i < n; i++ ) 
			mcl[i] = 1; 
		for ( i = 1; i < n; i++ ) 
			for ( j = 0; j < i; j++ ) 
				if ( arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1) 
					mcl[i] = mcl[j] + 1; 
		for ( i = 0; i < n; i++ ) 
			if ( max < mcl[i] ) 
				max = mcl[i]; 
		return max; 
	} 
	public static void main(String[] args) 
	{ 
		Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 25), 
								 new Pair (27, 40), new Pair(50, 60)}; 
		System.out.println("Length of maximum size chain is " + maxChainLength(arr, arr.length)); 
	} 
}
//algo
//This problem is a variation of standard Longest Increasing Subsequence problem. Following is a
//simple two step process.
//1) Sort given pairs in increasing order of first (or smaller) element. Why do not need sorting?
//		Consider the example {{6, 8}, {3, 4}} to understand the need of sorting. If we proceed to
//		second step without sorting, we get output as 1. But the correct output is 2.
//2) Now run a modified LIS process where we compare the second element of already finalized LIS with
//the first element of new LIS being constructed.

//program steps
//new Pair(5,24), new Pair(15, 25), new Pair (27, 40), new Pair(50, 60)
//a     b
//5    24	0
//15  25	1
//27  40	2
//50  60	3
//
//1 1 1 1
//0 1 2 3
//i=1
//j=0
//1 1 1 1
//0 1 2 3
//i=2
//j=0
//1 1 2 1
//0 1 2 3
//j=1
//1 1 2 1
//0 1 2 3
//i=3
//j=0
//1 1 2 2
//0 1 2 3
//j=1
//1 1 2 2
//0 1 2 3
//j=2
//1 1 2 3
//0 1 2 3