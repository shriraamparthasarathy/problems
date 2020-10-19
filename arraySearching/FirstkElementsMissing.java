package arraySearching;

//Given an array of size n and a number k, we need to print first k natural numbers that are not there in given array.

//Examples:

//Input : [2 3 4] 
//       k = 3
//Output : [1 5 6]

//Input  : [-2 -3 4] 
//        k = 2
//Output : [1 2]

import java.util.Arrays;
class FirstkElementsMissing 
{
 static void findkNaturalElements(int a[],int k)
 {
     int count=0,i=0;
     Arrays.sort(a);
     while(i<a.length&&a[i]<=0)
         i++;
     int cur=1;    
     while(count<k&&i<a.length)
     {
         if(a[i]!=cur)
         {    
             System.out.print(cur+" ");
             count++;
         }
         else
             i++;
         cur++;    
     }
     while(count<k)
     {
         System.out.print(cur+" ");
         cur++;
         count++;
     }
 }
	public static void main (String[] args)
	{
		int a[]={ 2, 3, 4 },k=3; 
		findkNaturalElements(a,k);
	}
}
//algo Time complexity O(nlogn * k) cspace 1
//1) Sort the given array.
//2) After sorting, we find position of first positive number in array.
//3) Now we traverse the array and keep printing elements in gaps between two consecutive array elements.
//4) If gaps don’t cover k missing numbers, we print numbers greater than the largest array element.