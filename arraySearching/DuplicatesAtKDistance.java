package arraySearching;

//Given an unsorted array that may contain duplicates. 
//Write a function that returns true if array contains duplicates within k distance.
//Examples:

//Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
//Output: false
//All duplicates are more than k distance away.

//Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
//Output: true
//1 is repeated at distance 3.

//Input: k = 3, arr[] = {1, 2, 3, 4, 5}
//Output: false

//Input: k = 3, arr[] = {1, 2, 3, 4, 4}
//Output: true

import java.util.HashSet;
class DuplicatesAtKDistance 
{
 static boolean checkDuplicates(int a[],int x)
 {
     HashSet<Integer> hs=new HashSet<>();
     for(int i=0;i<a.length;i++)
     {
         if(hs.contains(a[i]))
             return true;
         hs.add(a[i]);
         if(i>=x)
         hs.remove(i-x);
     }
     return false;
 }
	public static void main (String[] args) 
	{
		int a[]={10, 5, 3, 4, 3, 5, 6},x=3;
		if(checkDuplicates(a,x))
		    System.out.println("Duplicates present!");
		else
		    System.out.println("No duplicates");
	}
}

//algo: time complexiy O(n) space O(x)
//We can solve this problem in O(n) time using Hashing.
//The idea is to one by add elements to hash. 
//We also remove elements which are at more than k distance from current element. 
//Following is detailed algorithm.

//1) Create an empty hashtable.
//2) Traverse all elements from left from right. Let the current element be arr[i]
//a) If current element arr[i] is present in hashtable, then return true.
//b) Else add arr[i] to hash and remove arr[i-k] from hash if i is greater than or equal to k

