package hashing3;
//Given an array of size N. Let A and B be the minimum and maximum in the array respectively.
//Task is to find how many number should be added to the given array such that all the element in
//the range [A, B] occur at-least once in the array.
//
//Examples:
//
//Input : arr[] = {4, 5, 3, 8, 6}
//Output : 1
//Only 7 to be added in the list.
//
//Input : arr[] = {2, 1, 3}
//Output : 0
 
import java.util.HashSet; 

class ElementsMissinginRange 
{ 


	static int countNum(int arr[], int n) 
	{ 
		HashSet<Integer> s = new HashSet<>(); 
		int count = 0, 
		maxm = Integer.MIN_VALUE, 
		minm = Integer.MAX_VALUE;  
		for (int i = 0; i < n; i++) 
		{ 
			s.add(arr[i]); 
			if (arr[i] < minm) 
				minm = arr[i]; 
			if (arr[i] > maxm) 
				maxm = arr[i]; 
		} 

		for (int i = minm; i <= maxm; i++) 
			if (!s.contains(i)) 
				count++; 
		return count; 
	} 
 
	public static void main(String[] args) 
	{ 
		int arr[] = { 3, 5, 8, 6 }; 
		int n = arr.length; 
		System.out.println(countNum(arr, n)); 
	} 
} 
