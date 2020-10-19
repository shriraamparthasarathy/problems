package hashing2;
//Given an array of integers, find the length of the longest sub-array with sum equals to 0.
//Examples :
//
//Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
//Output: 5
//Explanation: The longest sub-array with 
//elements summing up-to 0 is {-2, 2, -8, 1, 7}
//
//Input: arr[] = {1, 2, 3}
//Output: 0
//Explanation:There is no subarray with 0 sum
//
//Input:  arr[] = {1, 0, 3}
//Output:  1
//Explanation: The longest sub-array with 
//elements summing up-to 0 is {0}
import java.util.HashMap; 

class LenofLongestSubArrayWithsumZero
{ 


	static int maxLen(int arr[]) 
	{ 
		
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 

		int sum = 0; 
		int max_len = 0; 

		for (int i = 0; i < arr.length; i++) 
		{ 
			sum+=arr[i];
			if(arr[i]==0&&max_len==0)
				max_len=1;
			if(sum==0)
				max_len=i+1;
			if(hM.containsKey(sum))
				max_len=Math.max(max_len, i-hM.get(sum));
			else
				hM.put(sum,i);
		} 

		return max_len; 
	} 

	public static void main(String arg[]) 
	{ 
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
		System.out.println("Length of the longest 0 sum subarray is "+ maxLen(arr)); 
	} 
} 
//algo
//
//The sum-index pair will be stored in a hash-map. A Hash map allows insertion and deletion of 
//key-value pair in constant time. Therefore, the time complexity remains unaffected. So,
//if the same value appears twice in the array, it will be guaranteed that the particular array
//will be a zero-sum sub-array.
//
//Mathematical Proof:
//prefix(i) = arr[0] + arr[1] +…+ arr[i]
//prefix(j) = arr[0] + arr[1] +…+ arr[j], j>i
//ifprefix(i) == prefix(j) then prefix(j) – prefix(i) = 0 that means arr[i+1] + .. + arr[j] = 0, 
//So a sub-array has zero sum , and the length of that sub-array is j-i+1
//
//
//Create a extra space, an array of length n (prefix), a variable (sum) , length (max_len) and
//a hash map (hm) to store sum-index pair as a key-value pair
//Move along the input array from starting to the end
//For every index update the value of sum = sum + array[i]
//Check for every index, if the current sum is present in the hash map or not
//If present update the value of max_len to maximum of difference of two indices (current index
//		and index in the hash-map) and max_len
//Else Put the value (sum) in the hash map, with the index as a key-value pair.
//Print the maximum length (max_len)