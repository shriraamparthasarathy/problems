package arraySearching;

//We are given an array of m-elements, we need to find n smallest elements from the array but they must be in the same order as they are in given array.

//Examples:

//Input : arr[] = {4, 2, 6, 1, 5}, 
//      n = 3
//Output : 4 2 1
//Explanation : 
//1, 2 and 4 are 3 smallest numbers and
//4 2 1 is their order in given array.

//Input : arr[] = {4, 12, 16, 21, 25},
//      n = 3
//Output : 4 12 16
//Explanation : 
//4, 12 and 16 are 3 smallest numbers and 
//4 12 16 is their order in given array.

import java.util.Arrays;
class FirstKSmallestElements 
{
 static boolean binarySearch(int copy[],int l,int r,int x)
 {
     while(l<=r)
     {
         int m=l+(r-l)/2;
         if(copy[m]==x)
             return true;
         else if(x>copy[m])
             l=m+1;
         else
             r=m-1;
     }
     return false;
 }
 static void findFirstKSmallestElements(int a[],int n)
 {
     int copy[]=Arrays.copyOf(a,a.length);
     Arrays.sort(copy);
     for(int i=0;i<a.length;i++)
     {
         if(binarySearch(copy,0,n-1,a[i]))
             System.out.print(a[i]+" ");
     }
 }
	public static void main (String[] args) 
	{
		int a[]={ 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 },x=5;
		findFirstKSmallestElements(a,x);
	}
}
//algo: time complexity O(nlogn) space O(n)

//Make a copy of original array and then sort copy array. 
//After sorting the copy array, save all n smallest numbers. 
//Further for each element in original array, check whether it is in n-smallest number or 
//not if it present in n-smallest array then print it otherwise move forward.

//Make copy_arr[]
//sort(copy_arr)
//For all elements in arr[] - 
//Find arr[i] in n-smallest element of copy_arr
//If found then print the element