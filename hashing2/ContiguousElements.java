package hashing2;
//Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous 
//integers else print “No”.
//
//Examples:
//
//Input : arr[] = {5, 2, 3, 6, 4, 4, 6, 6}
//Output : Yes
//The elements form a contiguous set of integers
//which is {2, 3, 4, 5, 6}.
//
//Input : arr[] = {10, 14, 10, 12, 12, 13, 15}
//Output : No

import java.util.HashSet; 

class ContiguousElements
{ 
	// Function to check whether the array 
	// contains a set of contiguous integers 
	static Boolean areElementsContiguous(int arr[], int n) 
	{ 
 
		HashSet<Integer> us = new HashSet<Integer>(); 
		
		for (int i = 0; i < n; i++) 
			us.add(arr[i]); 

		int count = 1; 
		int curr_ele = arr[0] - 1; 
		while(us.contains(curr_ele))
		{
			count++;
			curr_ele--;
		}
		curr_ele=arr[0]+1;
		while(us.contains(curr_ele))
		{
			count++;
			curr_ele++;
		}
		return (count == (us.size())); 
	} 


	public static void main(String[] args) 
	{ 
		int arr[] = { 5, 2, 3, 6, 4, 4, 6, 6 }; 
		int n = arr.length; 
		
		if (areElementsContiguous(arr, n)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 
//algo
//Insert all the elements in the hash table. Now pick the first element and keep on incrementing
//in its value by 1 till you find a value not present in the hash table. Again pick the first
//element and keep on decrementing in its value by 1 till you find a value not present in the 
//hash table. Get the count of elements (obtained by this process) which are present in the hash
//table. If the count equals hash size print “Yes” else “No”.