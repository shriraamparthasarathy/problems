package arraySearching;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//Examples:

//Input: arr[]   = {2, 0, 2}
//Output: 2
class TrappingRainWater 
{
 static int findTrappedWater(int a[])
 {
     int lo=0,hi=a.length-1,res=0;
     int leftmax=0,rightmax=0;
     while(lo<=hi)
     {
         if(a[lo]<a[hi])
         {
             if(a[lo]>leftmax)
                 leftmax=a[lo];
             else
                 res+=leftmax-a[lo];
             lo++;    
         }
         else
         {
             if(a[hi]>rightmax)
                 rightmax=a[hi];
             else
                 res+=rightmax-a[hi];
             hi--;    
         }
     }
     return res;
 }
	public static void main (String[] args) 
	{
		int a[]={ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; 
		System.out.println("Amount of water trapped is :"+findTrappedWater(a));
	}
}
//This is an efficient solution to the above problem.

//Approach: In the previous solution, to find the highest bar on the left and right, array traversal is needed which reduces the efficiency of the solution. To make this efficient one must pre-compute the highest bar on the left and right of every bar in linear time. Then use these pre-computed values to find the amount of water in every array element.
//Algorithm:
//Create two array left and right of size n. create a variable max_ = INT_MIN.
//Run one loop from start to end. In each iteration update max_ as max_ = max(max_, arr[i]) and also assign left[i] = max_
//Update max_ = INT_MIN.
//Run another loop from end to start. In each iteration update max_ as max_ = max(max_, arr[i]) and also assign right[i] = max_
//Traverse the array from start to end.
//The amount of water that will be stored in this column is min(a,b) – array[i],(where a = left[i] and b = right[i]) add this value to total amount of water stored
//Print the total amount of water stored.
//Instead of maintaing two arrays of size n for storing left and right max of each element, 
//maintain two variables to store the maximum till that point. 
//Since water trapped at any element = min(max_left, max_right) – arr[i]. 
//Calculate water trapped on smaller element out of A[lo] and A[hi] first and move the pointers till lo doesn’t cross hi.