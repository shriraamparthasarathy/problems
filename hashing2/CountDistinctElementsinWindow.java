package hashing2;
//Given an array of size n and an integer k, return the count of distinct numbers in all
//windows of size k.
//Example:
//
//Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
//       k = 4
//Output: 3 4 4 3
//
//Explanation:
//First window is {1, 2, 1, 3}, count of distinct numbers is 3
//Second window is {2, 1, 3, 4} count of distinct numbers is 4
//Third window is {1, 3, 4, 2} count of distinct numbers is 4
//Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
//
//Input: arr[] = {1, 2, 4, 4};
//       k = 2
//Output: 2 2 1
//
//Explanation:
//First window is {1, 2}, count of distinct numbers is 2
//First window is {2, 4}, count of distinct numbers is 2
//First window is {4, 4}, count of distinct numbers is 1
import java.util.HashMap; 
class CountDistinctElementsinWindow
{ 
	static void countDistinct(int arr[], int k) 
	{ 
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		for(int i=0;i<k;i++)
			hm.put(arr[i],hm.get(arr[i])!=null?hm.get(arr[i])+1:1);
		System.out.println(hm.size());
		for(int i=k;i<arr.length;i++)
		{
			if(hm.get(arr[i-k])==1)
				hm.remove(arr[i-k]);
			else
				hm.put(arr[i-k],hm.get(arr[i-k])-1);
			hm.put(arr[i],hm.get(arr[i])!=null?hm.get(arr[i])+1:1);
			System.out.println(hm.size());
		}
	} 
	public static void main(String arg[]) 
	{ 
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 }; 
		int k = 4; 
		countDistinct(arr, k); 
	} 
} 
//algo
//Create an empty hash map. Let the hash map be hM.
//Initialize the count of distinct element as dist_count to 0.
//Traverse through the first window and insert elements of the first window to hM. 
//The elements are used as key and their counts as the value in hM. Also, keep updating dist_count
//Print distinct count for the first window.
//Traverse through the remaining array (or other windows).
//Remove the first element of the previous window.
//If the removed element appeared only once, remove it from hM and decrease the distinct count,
//i.e. do “dist_count–“
//else (appeared multiple times in hM), then decrement its count in hM
//Add the current element (last element of the new window)
//If the added element is not present in hM, add it to hM and increase the distinct count, i.e.
//do “dist_count++”
//Else (the added element appeared multiple times), increment its count in hM