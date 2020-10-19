//Given an array of n elements. Find maximum sum of pairwise multiplications. Sum can be larger so take mod with 10^9+7. If there are odd elements, then we can add any one element (without forming a pair) to the sum.
//
//Examples:
//
//Input : arr[] = {-1, 4, 5, -7, -4, 9, 0}
//Output : 77
//So to get the maximum sum, the arrangement will 
//be {-7, -4}, {-1, 0}, {9, 5} and {4}.
//So the answer is (-7*(-4))+((-1)*0)+(9*5)+(4) ={77}.
//
//Input : arr[] = {8, 7, 9}
//Output : 79
//Answer is (9*8) +(7) = 79.
package arraySearching;

import java.util.Arrays;
class MaxPathwiseProduct 
{
    static int findMaxProduct(int a[])
    {
        int MOD=1000000007;
        int sum=0,n=a.length,i=0,j=0;
        Arrays.sort(a);
     // First multiply negative numbers  
        // pairwise and sum up from starting  
        // as to get maximum sum. 
        while(i<n&&a[i]<0)
        {
            if(i!=n-1&&a[i+1]<=0)
            {
                sum=(sum+(a[i]*a[i+1])%MOD)%MOD;
                i+=2;
            }    
            else
                break;
        }
        j=n-1;
     // Second multiply positive numbers  
        // pairwise and summed up from the  
        // last as to get maximum sum. 
        while(j>=0&&a[j]>0)
        {
            if(j!=0&&a[j-1]>0)
            {
                sum=(sum+(a[j]*a[j-1])%MOD)%MOD;
                j-=2;
            }
            else
                break;
        }
        // To handle case if positive and negative 
        // numbers both are odd in counts. 
        if(j>i)
            sum=(sum+(a[i]*a[j])%MOD)%MOD;
        // If one of them occurs odd times 
        else if(i==j)
            sum=(sum+a[i])%MOD;
        return sum;    
    }
	public static void main (String[] args) 
	{
		int a[]={-1, 4, 5, -7, -4, 9, 0}; 
		System.out.println("Maximum pathwise product: "+findMaxProduct(a));
	}
}
//algo:
//	1- Sort the given array.
//	2- First, multiply the negative numbers pairwise from the starting and add to the total_sum.
//	3- Second, multiply the positive numbers pairwise from the last and to the total_sum.
//	4- Check if negative and positive both counts are odd, then add the product of last pair
//	i.e. last negative and positive left.
//	5- Or if any of the one counts is odd, then add that element left.
//	6- Return sum.