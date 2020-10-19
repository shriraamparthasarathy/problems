package hashing;
//Given an integer array, print all distinct elements in array. The given array may contain 
//duplicates and the output should print every element only once. The given array is not sorted.
//Examples:
//
//Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
//Output: 12, 10, 9, 45, 2
//
//Input: arr[] = {1, 2, 3, 4, 5}
//Output: 1, 2, 3, 4, 5
//
//Input: arr[] = {1, 1, 1, 1, 1}
//Output: 1
import java.util.HashSet; 

class AllDistinctElements 
{ 
	static void printDistinct(int arr[]) 
	{ 
		HashSet<Integer> set = new HashSet<>(); 
		for (int i=0; i<arr.length; i++) 
		{ 
			if (!set.contains(arr[i])) 
			{ 
				set.add(arr[i]); 
				System.out.print(arr[i] + " "); 
			} 
		} 
	} 

	public static void main (String[] args) 
	{ 
		int arr[] = {10, 5, 3, 4, 3, 5, 6}; 
		printDistinct(arr); 
	} 
} 
//algo
//The idea is to traverse the given array from left to right and keep track of visited elements
//in a hash table. Following is the implementation of the idea.