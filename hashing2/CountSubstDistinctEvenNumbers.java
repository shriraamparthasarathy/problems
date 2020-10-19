package hashing2;

//Given a sequence of n numbers. The task is to count all the subsets of the given set which only
//have even numbers and all are distinct.
//Note: By the property of sets, if two subsets have the same set of elements then they are 
//considered as one. For example: [2, 4, 8] and [4, 2, 8] are considered to be the same.
//
//Examples:
//
//Input : {4, 2, 1, 9, 2, 6, 5, 3} 
//Output : 7
//The subsets are:
//[4], [2], [6], [4, 2], 
//[2, 6], [4, 6], [4, 2, 6]
//
//Input : {10, 3, 4, 2, 4, 20, 10, 6, 8, 14, 2, 6, 9}
//Output : 127
import java.util.HashSet; 

class CountSubstDistinctEvenNumbers 
{ 
	static int countSubsets(int arr[], int n) 
	{ 
		HashSet<Integer> hs=new HashSet<>();
		for(int i:arr)
			if(i%2==0)
				hs.add(i);
		int even =hs.size();
		return (int)(Math.pow(2, even)-1);
	} 

	public static void main(String[] args) 
	{ 
		int arr[] = {4, 2, 1, 9, 2, 6, 5, 3}; 
		int n = arr.length; 
		System.out.println("Number of subsets = "+ countSubsets(arr, n)); 
	} 
} 
//algo
//An efficient approach is to count number of distinct even numbers. Let this be ceven. 
//And then apply formula:
//
//2^ceven – 1
//This is similar to counting the number of subsets of a given set of n elements. 1 is 
//subtracted because the null set is not considered.