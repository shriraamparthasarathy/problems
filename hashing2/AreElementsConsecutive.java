package hashing2;
//Given an unsorted array of distinct numbers, write a function that returns true if array
//consists of consecutive numbers.
//Examples :
//
//Input : arr[] = {5, 4, 2, 1, 3}
//Output : Yes
//
//Input : arr[] = {2, 1, 0, -3, -1, -2}
//Output : Yes
class AreElementsConsecutive
{ 
	static Boolean areConsecutives(int arr[], int n) 
	{  
		int first_term = Integer.MAX_VALUE; 
		for (int j = 0; j < n; j++) 
		{ 
			if(arr[j] < first_term) 
			first_term = arr[j]; 
		} 
		int ap_sum = (n * (2 * first_term + (n - 1) * 1)) / 2; 
		int arr_sum = 0; 
		for (int i = 0; i < n; i++) 
			arr_sum += arr[i]; 
		return ap_sum == arr_sum; 
	} 
	
	public static void main(String[] args) 
	{ 
		int arr[] = { 2, 1, 0, -3, -1, -2 }; 
		int n = arr.length; 
		Boolean result = areConsecutives(arr, n); 
		if(result == true) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
}  
//algo
//a method with time complexity of O(n) and using O(1) space will be discussed which will 
//handle the case of negative also. An important assumption here is elements are distinct.
//
//Find the sum of the array.
//If given array elements are consecutive that means they are in AP. So, find min element i.e.
//first term of AP then calculate ap_sum = n/2 * [2a +(n-1)*d] where d = 1. So, 
//ap_sum = n/2 * [2a +(n-1)]
//Compare both sums. Print Yes if equal, else No.