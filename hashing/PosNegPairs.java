package hashing;
//Given an array of distinct integers, print all the pairs having positive value and
//negative value of a number that exists in the array. We need to print pairs in order of 
//their occurrences. A pair whose any element appears first should be printed first.
//
//Examples:
//
//Input  :  arr[] = { 1, -3, 2, 3, 6, -1 }
//Output : -1 1 -3 3
//
//Input  :  arr[] = { 4, 8, 9, -4, 1, -1, -8, -9 }
//Output : -1 1 -4 4 -8 8 -9 9
import java.util.HashMap; 

class PosNegPairs 
{ 

 
static void printPairs(int arr[], int n) 
{ 
	HashMap<Integer, Integer> cnt = new HashMap<>(); 
	for (int i = 0; i < n; i++) 
	{ 

		if (cnt.containsKey(Math.abs(arr[i]))) 
			cnt.put(Math.abs(arr[i]), 1); 
 
		else
		{ 
			cnt.put(Math.abs(arr[i]), 0); 
		} 
	} 



	for (HashMap.Entry<Integer,Integer> entry:cnt.entrySet()) 
	{
		if(entry.getValue()==1)
			System.out.print("-" + entry.getKey() + 
					" " + entry.getKey() + " "); 
	}
} 

public static void main(String[] args) 
{ 
	int arr[] = { 4, 8, 9, -4, 1, -1, -8, -9 }; 
	int n = arr.length; 
	printPairs(arr, n); 
} 
} 
//algo 
//The idea is to use hashing. Traverse the given array, increase the count at 
//absolute value of hash table. If count becomes 2, store its absolute value in another vector.
//And finally sort the vector. If the size of the vector is 0, print “0”, else for each term in
//vector print first its negative value and the the positive value.