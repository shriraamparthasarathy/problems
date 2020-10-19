package arraySearching;

//Given an array of integers, find any one combination of four elements in the array whose sum is equal to a given value X.
//For example,

//Input: array = {10, 2, 3, 4, 5, 9, 7, 8} 
//    X = 23 
//Output: 3 5 7 8
//Sum of output is equal to 23, 
//i.e. 3 + 5 + 7 + 8 = 23.

//Input: array = {1, 2, 3, 4, 5, 9, 7, 8}
//    X = 16 
//Output: 1 3 5 7
//Sum of output is equal to 16, 
//i.e. 1 + 3 + 5 + 7 = 16.

import java.util.Arrays;
import java.util.HashMap;

class FourSum 
{
 static class pair
 {
     int first;
     int second;
     pair(int first,int second)
     {
         this.first=first;
         this.second=second;
     }
 }
 
 static void findFourNosSumHash(int a[],int x)
 {
     HashMap<Integer,pair> hm=new HashMap<>();
     for(int i=0;i<a.length-1;i++)
     {
         for(int j=i+1;j<a.length;j++)
             hm.put(a[i]+a[j],new pair(i,j));
     }
     for(int i=0;i<a.length-1;i++)
     {
         for(int j=i+1;j<a.length;j++)
         {
             int sum=a[i]+a[j];
             if(hm.containsKey(x-sum))
             {
                 pair p=hm.get(x-sum);
                 if(p.first!=i&&p.first!=j&&p.second!=i&&p.second!=j)
                 {
                     System.out.println(a[i]+" "+a[j]+" "+a[p.first]+" "+a[p.second]);
                     return;
                 }    
             }
         }
     }
 }
 
 static void findFourNosSum(int a[],int x)
 {
     int n=a.length;
     Arrays.sort(a);
     for(int i=0;i<n-3;i++)
     {
        for(int j=i+1;j<n-2;j++)
        {
            int l=j+1,r=n-1;
             while(l<r)
             {
                 if(a[i]+a[j]+a[l]+a[r]==x)
                 {
                    System.out.println(a[i]+" "+a[j]+" "+a[l]+" "+a[r]);
                    l++;
                    r--;
                 }
                 else if(a[i]+a[j]+a[l]+a[r]<x)
                    l++;
                 else
                     r--;
             }    
        }
     }
 }
 
	public static void main (String[] args) 
	{
		int a[]={ 1, 4, 45, 6, 10, 12},x=21;
		findFourNosSum(a,x);// O(n^3) time O(1) space
		findFourNosSumHash(a,x);// O(n^2) time O(n) space
	}
}
//algo 1:
//1) Sort the input array.
//2) Fix the first element as A[i] where i is from 0 to n–3. After fixing the first element of quadruple, fix the second element as A[j] where j varies from i+1 to n-2. 
//Find remaining two elements in O(n) time,

//Hashing Based Solution[O(n2)]
//Approach:

//Store sums of all pairs in a hash table
//Traverse through all pairs again and search for X – (current pair sum) in the hash table.
//If a pair is found with the required sum, then make sure that all elements are distinct array elements and an element is not considered more than once.