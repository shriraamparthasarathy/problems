package hashing2;
//Given an arr[] containing n integers and a positive integer k. The problem is to find the length 
//of the longest subarray with sum of the elements divisible by the given value k.
//
//Examples:
//
//Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
//Output : 4
//The subarray is {7, 6, 1, 4} with sum 18,
//which is divisible by 3.
//
//Input : arr[] = {-2, 2, -5, 12, -11, -1, 7}
//Output : 5
import java.util.HashMap; 

class SubArraySumDivbyK
{ 

	static int longSubarrWthSumDivByK(int arr[], int n, int k) 
	{ 
		
		HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>(); 
		
		int mod_arr[]= new int[n]; 
		int max = 0; 
		int curr_sum = 0; 
		
		for (int i = 0; i < n; i++) 
		{ 
			curr_sum += arr[i]; 
			mod_arr[i] = ((curr_sum % k) + k) % k;	 
		} 
		
		for (int i = 0; i < n; i++) 
		{ 

			if (mod_arr[i] == 0) 
				max = i + 1; 
	
			else if (hm.containsKey(mod_arr[i]) == false) 
				hm.put(mod_arr[i] , i); 
				
			else
				max=Math.max(max,i-hm.get(mod_arr[i]));	 
		} 

		return max; 
	}	 
	
	public static void main (String[] args) 
	{ 
		int arr[] = {2, 7, 6, 1, 4, 5}; 
		int n = arr.length; 
		int k = 3; 
		
		System.out.println("Length = "+ 
							longSubarrWthSumDivByK(arr, n, k)); 
		
	} 
} 
//algo
//Create an array mod_arr[] where mod_arr[i] stores (sum(arr[0]+arr[1]..+arr[i]) % k). 
//Create a hash table having tuple as (ele, idx), where ele represents an element of mod_arr[] 
//		and idx represents the element�s index of first occurrence in mod_arr[]. Now, traverse
//		mod_arr[] from i = 0 to n and follow the steps given below.
//
//If mod_arr[i] == 0, then update maxLen = (i + 1).
//Else if mod_arr[i] is not present in the hash table, then create tuple (mod_arr[i], i) in the
//hash table.
//Else, get the value associated with mod_arr[i] in the hash table. Let this be idx.
//If maxLen < (i � idx), then update maxLen = (i � idx).
//Finally return maxLen.
