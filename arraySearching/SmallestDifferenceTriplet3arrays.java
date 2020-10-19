package arraySearching;

//Three arrays of same size are given. Find a triplet such that maximum – minimum in that triplet is minimum of all the triplets. A triplet should be selected in a way such that it should have one number from each of the three given arrays.

//If there are 2 or more smallest difference triplets, then the one with the smallest sum of its elements should be displayed.

//Examples :

//Input : arr1[] = {5, 2, 8}
//  arr2[] = {10, 7, 12}
//  arr3[] = {9, 14, 6}
//Output :  7, 6, 5

//Input : arr1[] = {15, 12, 18, 9}
//  arr2[] = {10, 17, 13, 8}
//  arr3[] = {14, 16, 11, 5}
//Output : 11, 10, 9
//Note:The elements of the triplet are displayed in non-decreasing order.

import java.util.Arrays;
class SmallestDifferenceTriplet3arrays
{ 
 static int maximum(int x,int y,int z)
 {
     if(x>y&&x>z)
         return x;
     else if(y>z)
         return y;
     else
         return z;
 }
 static int minimum(int x,int y,int z)
 {
     if(x<y&&x<z)
         return x;
     else if(y<z)
         return y;
     else
         return z;
 }
 static void findTriplet(int a1[],int a2[],int a3[])
 {
     Arrays.sort(a1);
     Arrays.sort(a2);
     Arrays.sort(a3);
     int max,min,sum,diff=Integer.MAX_VALUE;
     int res_max=0,res_mid=0,res_min=0;
     int i=0,j=0,k=0,n=a1.length;
     while(i<n&&j<n&&k<n)
     {
         sum=a1[i]+a2[j]+a3[k];
         max=maximum(a1[i],a2[j],a3[k]);
         min=minimum(a1[i],a2[j],a3[k]);
         if(min==a1[i])
             i++;
         else if(min==a2[j])
             j++;
         else
             k++;
         if(diff>max-min)
         {
             res_max=max;
             res_min=min;
             res_mid=sum-(max+min);
             diff=max-min;
         }
     }
     System.out.println(res_max+" "+res_mid+" "+res_min);
 }

	public static void main(String[] args) 
	{ 
		int a1[] = {5, 2, 8}; 
     int a2[] = {10, 7, 12}; 
     int a3[] = {9, 14, 6}; 
     findTriplet(a1,a2,a3);
	} 
}

//algo:time complexity O(nlogn), space complexit O(1)

//Sort the 3 arrays in non-decreasing order.
//Start three pointers from left most elements of three arrays.
//Now find min and max and calculate max-min from these three elements.
//Now increment pointer of minimum element’s array.
//Repeat steps 2, 3, 4, for the new set of pointers until any one pointer reaches to its end.
