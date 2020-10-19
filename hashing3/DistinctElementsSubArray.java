package hashing3;
//Given an array, the task is to calculate the sum of lengths of contiguous subarrays having
//all elements distinct.
//
//Examples:
//
//Input :  arr[] = {1, 2, 3}
//Output : 10
//{1, 2, 3} is a subarray of length 3 with 
//distinct elements. Total length of length
//three = 3.
//{1, 2}, {2, 3} are 2 subarray of length 2 
//with distinct elements. Total length of 
//lengths two = 2 + 2 = 4
//{1}, {2}, {3} are 3 subarrays of length 1
//with distinct element. Total lengths of 
//length one = 1 + 1 + 1 = 3
//Sum of lengths = 3 + 4 + 3 = 10
//
//Input :  arr[] = {1, 2, 1}
//Output : 7
//
//Input :  arr[] = {1, 2, 3, 4}
//Output : 20
import java.util.HashSet; 

class DistinctElementsSubArray 
{ 

	public static int sumoflength(int[] arr, int n) 
	{ 

		HashSet<Integer> s = new HashSet<>(); 
		int j = 0, ans = 0;  
		for (int i = 0; i < n; i++) 
		{ 
			while (j < n && !s.contains(arr[j])) 
			{ 
				s.add(arr[j]); 
				j++; 
				System.out.println(s.toString());
			} 

			ans += ((j - i) * (j - i + 1)) / 2; 
			System.out.println(s.toString()+"\n"+ans);

			s.remove(arr[i]); 
		} 

		return ans; 
	} 

	public static void main(String[] args) 
	{ 
		int[] arr = { 1, 2, 1}; 
		int n = arr.length; 

		System.out.println(sumoflength(arr, n)); 
	} 
} 
//algo
//An efficient solution is based on the fact that if we know all elements in a subarray 
//arr[i..j] are distinct, sum of all lengths of distinct element subarrays in this sub array
//is ((j-i+1)*(j-i+2))/2. How? the possible lengths of subarrays are 1, 2, 3,……, j – i +1. So,
//		the sum will be ((j – i +1)*(j – i +2))/2.
//
//
//
//
//We first find largest subarray (with distinct elements) starting from first element. We
//count sum of lengths in this subarray using above formula. For finding next subarray of the 
//distinct element, we increment starting point, i and ending point, j unless (i+1, j) are distinct.
//If not possible, then we increment i again and move forward the same way.