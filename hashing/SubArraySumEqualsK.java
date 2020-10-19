package hashing;
//Given an unsorted array of integers, find the number of subarrays having sum 
//exactly equal to a given number k.
//
//Examples:
//
//Input : arr[] = {10, 2, -2, -20, 10}, 
//        k = -10
//Output : 3
//Subarrays: arr[0...3], arr[1...4], arr[3..4]
//have sum exactly equal to -10.
//
//Input : arr[] = {9, 4, 20, 3, 10, 5},
//            k = 33
//Output : 2
//Subarrays : arr[0...2], arr[2...4] have sum
//exactly equal to 33.
import java.util.HashMap; 

public class SubArraySumEqualsK
{ 

	static int findSubarraySum(int arr[], int n, int sum) 
	{
		HashMap<Integer, Integer> prevSum = new HashMap<>(); 

		int res = 0; 


		int currsum = 0; 

		for (int i = 0; i < n; i++)
		{ 
			currsum+=arr[i];
			if(currsum==res)
				res++;
			if(prevSum.containsKey(currsum-sum))
				res+=prevSum.get(currsum-sum);
			Integer count=prevSum.get(currsum);
			if(count==null)
				prevSum.put(currsum,1);
			else
				prevSum.put(currsum,count+1);
		} 

		return res; 
	} 

	public static void main(String[] args) 
	{ 

		int arr[] = { 10, 2, -2, -20, 10 }; 
		int sum = -10; 
		int n = arr.length; 
		System.out.println(findSubarraySum(arr, n, sum)); 
	} 
} 
//algo
//An efficient solution is while traversing the array, store sum so far in currsum. 
//Also maintain count of different values of currsum in a map. If value of currsum is equal 
//to desired sum at any instance increment count of subarrays by one. The value of currsum exceeds 
//desired sum by currsum – sum. If this value is removed from currsum then desired sum can be
//obtained. From the map find number of subarrays previously found having sum equal to currsum-sum. 
//Excluding all those subarrays from current subarray, gives new subarrays having desired sum.
//So increase count by the number of such subarrays. Note that when currsum is equal to desired 
//sum then also check number of subarrays previously having sum equal to 0. Excluding those
//subarrays from current subarray gives new subarrays having desired sum. Increase count by the 
//number of subarrays having sum 0 in that case.