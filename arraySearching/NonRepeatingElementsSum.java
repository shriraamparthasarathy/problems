package arraySearching;

//Given an integer array with repeated elements, the task is to find sum of all distinct elements in array.

//Examples:

//Input  : arr[] = {12, 10, 9, 45, 2, 10, 10, 45,10};
//Output : 78
//Here we take 12, 10, 9, 45, 2 for sum
//because it's distinct elements 

//Input : arr[] = {1, 10, 9, 4, 2, 10, 10, 45 , 4};
//Output : 71

import java.util.HashSet;
class NonRepeatingElementsSum 
{
 static int findDistinctSum(int a[])
 {
     HashSet<Integer> hs=new HashSet<>();
     int sum=0;
     for(int i=0;i<a.length;i++)
     {
         if(!hs.contains(a[i]))
         {
             hs.add(a[i]);
             sum+=a[i];
         }
     }
     return sum;
 }
	public static void main (String[] args)
	{
		int a[]= {1, 2, 3, 1, 1, 4, 5, 6}; 
		System.out.println("The sum of distinct elements is : "+findDistinctSum(a));
	}
}
//algo Time complexity O(n) space o(n)
