package dynamicProgramming;
//Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
//Examples:
//
//Input: n = 3
//Output: 4
//Explantion:
//Below are the four ways
// 1 step + 1 step + 1 step
// 1 step + 2 step
// 2 step + 1 step
// 3 step
//
//Input: n = 4
//Output: 7
//Explantion:
//Below are the four ways
// 1 step + 1 step + 1 step + 1 step
// 1 step + 2 step + 1 step
// 2 step + 1 step + 1 step 
// 1 step + 1 step + 2 step
// 2 step + 2 step
// 3 step + 1 step
// 1 step + 3 step

class DpTribonacci 
{ 
	
	static int printCountDP(int dist) 
	{ 
		int[] count = new int[dist+1]; 

		// Initialize base values. There is one way to 
		// cover 0 and 1 distances and two ways to 
		// cover 2 distance 
		count[0] = 1; 
		count[1] = 1; 
		count[2] = 2; 

		// Fill the count array in bottom up manner 
		for (int i=3; i<=dist; i++) 
			count[i] = count[i-1] + count[i-2] + count[i-3]; 

		return count[dist]; 
	} 
	
	// driver program 
	public static void main (String[] args) 
	{ 
		int dist = 4; 
		System.out.println(printCountDP(dist)); 
	} 
} 
//algo
//Create an array of size n + 1 and initilize the first 3 variables with 1, 1, 2. The base cases.
//Run a loop from 3 to n.
//For each index i, computer value of ith position as dp[i] = dp[i-1] + dp[i-2] + dp[i-3].
//Print the value of dp[n], as the Count of number of ways to cover a distance.