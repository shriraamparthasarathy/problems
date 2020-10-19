package arraySearching;

/*package whatever //do not write package name here */

//given heights of consecutive buildings, find the maximum number of consecutive steps one can put forward such that he gain a increase in altitude while going from roof of one building to next adjacent one.

//Examples :

//Input : arr[] = {1, 2, 2, 3, 2}
//Output : 1
//Explanation :
//Maximum consecutive steps from 1 to 2 OR  2 to 3.

//Input : arr[] = {1, 2, 3, 4}
//Output : 3

class RoofTop 
{
 static int findMaxStep(int a[])
 {
     int count=0,res=0;
     for(int i=1;i<a.length;i++)
     {
         if(a[i]>a[i-1])
             count++;
         else
         {   
             res=Math.max(count,res);
             count=0;
         }    
     }
     return Math.max(count,res);
     
 }
	public static void main (String[] args) 
	{
		int a[]={1, 2, 3, 4};
		System.out.println("The max consecutive steps is "+findMaxStep(a));
	}
}
//algo
//initialize count = 0
//initialize maximum = 0
//  if arr[i]>a[i-1]
//then count increment
//  else
//maximum = max(maximum, count)

//at the end maximum=max(maximum, count)