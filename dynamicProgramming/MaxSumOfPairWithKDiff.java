package dynamicProgramming;
import java.util.Arrays;
//First we sort the given array in increasing order. Once array is sorted, we traverse the array.
//For every element, we try to pair it with its previous element first. Why do we prefer previous
//element? Let arr[i] can be paired with arr[i-1] and arr[i-2] (i.e. arr[i] – arr[i-1] < K and 
//		arr[i]-arr[i-2] < K). Since the array is sorted, value of arr[i-1] would be more than 
//		arr[i-2]. Also, we need to pair with difference less than k, it means if arr[i-2] can
//		be paired, then arr[i-1] can also be paired in a sorted array.
//Now observing the above facts, we can formulate our dynamic programming solution as below,
//Let dp[i] denotes the maximum disjoint pair sum we can achieve using first i elements of the array.
//Assume currently we are at i’th position, then there are two possibilities for us.
//
//  Pair up i with (i-1)th element, i.e. 
//      dp[i] = dp[i-2] + arr[i] + arr[i-1]
//  Don't pair up, i.e. 
//      dp[i] = dp[i-1] 
class MaxSumOfPairWithKDiff
{ 
	
	static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
	{ 
		
		// Sort input array in ascending order. 
		Arrays.sort(arr); 
	
		// dp[i] denotes the maximum disjoint pair sum 
		// we can achieve using first i elements 
		int dp[] = new int[N]; 
	
		// if no element then dp value will be 0 
		dp[0] = 0; 
	
		for (int i = 1; i < N; i++) 
		{ 
			// first give previous value to dp[i] i.e. 
			// no pairing with (i-1)th element 
			dp[i] = dp[i-1]; 
	
			// if current and previous element can form a pair 
			if (arr[i] - arr[i-1] < K) 
			{ 
				
				// update dp[i] by choosing maximum between 
				// pairing and not pairing 
				if (i >= 2) 
					dp[i] = Math.max(dp[i], dp[i-2] + arr[i] + 
													arr[i-1]); 
				else
					dp[i] = Math.max(dp[i], arr[i] + arr[i-1]); 
			} 
		} 
	
		// last index will have the result 
		return dp[N - 1]; 
	} 

	// Driver code to test above methods 
	public static void main (String[] args) { 
		
		int arr[] = {3, 5, 10, 15, 17, 12, 9}; 
		int N = arr.length; 
		int K = 4; 
		
		System.out.println ( maxSumPairWithDifferenceLessThanK( 
													arr, N, K)); 
		
	} 
} 
