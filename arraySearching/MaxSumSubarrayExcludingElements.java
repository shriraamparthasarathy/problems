package arraySearching;

//Input : A = {1, 7, -10, 6, 2}, B = {5, 6, 7, 1}
//Output : 2
//Explanation Since the Maximum Sum Subarray of A is not allowed to have any element that is present in array B.
//The Maximum Sum Subarray satisfying this is {2} as the only allowed subarrays are:{-10} and {2}. The Maximum Sum Subarray being {2} which sums to 2
//
//Input : A = {3, 4, 5, -4, 6}, B = {1, 8, 5}
//Output : 7
//
//Explanation
//The Maximum Sum Subarray satisfying this is {3, 4} as the only allowed subarrays are {3}, {4}, {3, 4}, {-4}, {6}, {-4, 6}. The Maximum Sum subarray being {3, 4} which sums to 7
import java.util.Arrays;
class MaxSumSubarrayExcludingElements
{
    static boolean isPresent(int b[],int x)
    {
        int l=0,r=b.length-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(x==b[m])
                return true;
            if(x<b[m])
                r=m-1;
            else if(x>b[m])
                l=m+1;
        }
        return false;
    }
    static int findMaxSumSubarray(int a[],int b[])
    {
        int maxsum=Integer.MIN_VALUE,cur=0;
        for(int i=0;i<a.length;i++)
        {
            if(isPresent(b,a[i]))
            {
                cur=0;
                continue;
            }
            cur=Math.max(a[i],cur+a[i]);
            maxsum=Math.max(cur,maxsum);
        }
        return maxsum;
    }
    static void findMaxSum(int a[],int b[])
    {
        Arrays.sort(b);
        int maxSum=findMaxSumSubarray(a,b);
        if(maxSum==Integer.MIN_VALUE)
            System.out.println("There is no subarray");
        else
            System.out.println(maxSum);
    }
	public static void main (String[] args) 
	{
	    int a[] = {1, 7, -10, 6, 2}; 
        int b[] = {5, 6, 7, 1}; 
		findMaxSum(a,b);
	}
}