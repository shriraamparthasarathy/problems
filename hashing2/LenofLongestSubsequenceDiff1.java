package hashing2;
//Given an array of n size, the task is to find the longest subsequence such that difference
//between adjacents is one.
//
//Examples:
//
//Input :  arr[] = {10, 9, 4, 5, 4, 8, 6}
//Output :  3
//As longest subsequences with difference 1 are, "10, 9, 8", 
//"4, 5, 4" and "4, 5, 6"
//
//Input :  arr[] = {1, 2, 3, 2, 3, 7, 2, 1}
//Output :  7
//As longest consecutive sequence is "1, 2, 3, 2, 3, 2, 1"
import java.util.HashMap;
class LenofLongestSubsequenceDiff1 
{ 
	
	public static void incSubSeq(int[] arr) 
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			int prev = 0;
			if (map.get(arr[i] - 1) != null) 
				prev = map.get(arr[i] - 1);
			int next = 0;
			if (map.get(arr[i] + 1) != null) 
				next = map.get(arr[i] + 1);
			int k = Math.max(prev, next);
			map.put(arr[i], k + 1);
			if (k + 1 > max)
				max = k + 1;
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 3, 2 };
		incSubSeq(arr);
		int arr1[] = { 10, 9, 4, 5, 4, 8, 6 };
		incSubSeq(arr1);
		int arr2[] = { 1, 2, 3, 2, 3, 7, 2, 1 };
		incSubSeq(arr2);
		int arr3[] = { 4, 2, 7, 11, 8 };
		incSubSeq(arr3);

	}
} 
