package hashing3;
//Given an array of n integers. Count total number of sub-array having total distinct elements 
//same as that of total distinct elements of original array.
//
//Examples:
//
//Input  : arr[] = {2, 1, 3, 2, 3}
//Output : 5
//Total distinct elements in array is 3
//Total sub-arrays that satisfy the condition 
//are:  Subarray from index 0 to 2
//      Subarray from index 0 to 3
//      Subarray from index 0 to 4
//      Subarray from index 1 to 3
//      Subarray from index 1 to 4
//
//Input  : arr[] = {2, 4, 5, 2, 1}
//Output : 2
//
//Input  : arr[] = {2, 4, 4, 2, 4}
//Output : 9
import java.util.HashMap; 

class CountDistinctSubarrayswithK 
{ 
	
	static int countDistictSubarray(int arr[], int n) 
	{  
		@SuppressWarnings("serial")
		HashMap<Integer, Integer> vis = new HashMap<Integer,Integer>(){ 
			@Override
			public Integer get(Object key) { 
				if(!containsKey(key)) 
					return 0; 
				return super.get(key); 
			} 
		}; 
		
		for (int i = 0; i < n; ++i) 
			vis.put(arr[i], 1); 
		int k = vis.size(); 
		vis.clear(); 
	 
		int ans = 0, right = 0, window = 0; 
		for (int left = 0; left < n; ++left) 
		{ 
			while (right < n && window < k) 
			{ 
				vis.put(arr[right], vis.get(arr[right]) + 1); 
	
				if (vis.get(arr[right])== 1) 
					++window; 
	
				++right; 
			} 

			if (window == k) 
				ans += (n - right + 1); 
			vis.put(arr[left], vis.get(arr[left]) - 1); 
			if (vis.get(arr[left]) == 0) 
					--window; 
		} 
		return ans; 
	} 
	public static void main(String args[]) 
	{ 
		int arr[] = {2, 1, 3, 2, 3}; 

		System.out.println(countDistictSubarray(arr, arr.length)); 
	} 
} 
//algo
//An efficient approach is to use sliding window to count all distinct elements in one iteration.
//
//Find the number of distinct elements in the entire array. Let this number be k <= N. Initialize
//Left = 0, Right = 0 and window = 0.
//Increment right until the number of distinct elements in range [Left=0, Right] equal to
//k(or window size would not equal to k), let this right be R1. Now since the sub-array [Left = 0,
//R1] has k distinct elements, so all the sub-arrays starting at Left = 0 and ending after R1 will 
//also have k distinct elements. Thus add N-R1+1 to the answer because [Left.. R1], [Left.. R1+1],
//[Left.. R1+2] … [Left.. N-1] contains all the distinct numbers.
//Now keeping R1 same, increment left. Decrease the frequency of the previous element i.e., arr[0],
//and if its frequency becomes 0, decrease the window size. Now, the sub-array is [Left = 1, Right =
//R1].
//Repeat the same process from step 2 for other values of Left and Right till Left < N.