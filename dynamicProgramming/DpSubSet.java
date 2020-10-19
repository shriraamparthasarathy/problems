package dynamicProgramming;
//Given a set of non-negative integers, and a value sum, determine if there is a subset 
//of the given set with sum equal to given sum.
//Example:
//
//Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//Output: True  
//There is a subset (4, 5) with sum 9.
//
//Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
//Output: False
//There is no subset that add up to 30.
public class DpSubSet
{
	public static boolean subsetSum(int input[], int total) 
	{
	      boolean T[][] = new boolean[input.length + 1][total + 1];
	      for (int i = 0; i <= input.length; i++) 
	          T[i][0] = true;
	      for (int i = 1; i <= input.length; i++) 
	      {
	          for (int j = 1; j <= total; j++) 
	          {
	              if (input[i - 1] >j)
	            	  T[i][j] = T[i-1][j];             
	              else
	            	  T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
	          }
	      }
	      return T[input.length][total];

	 }
	 public static void main(String args[])
	 {
		 int set[] = { 3, 34, 4, 12, 5, 2 }; 
	     int sum = 9;
	     if (subsetSum(set, sum)) 
	         System.out.println("Found a subset with given sum"); 
	     else
	         System.out.println("No subset with given sum"); 
	 }
}
//algo: https://www.youtube.com/watch?v=s6FhG--P7z0&t=377s
//So we will create a 2D array of size (arr.size() + 1) * (target + 1) of type boolean. The 
//state DP[i][j] will be true if there exists a subset of elements from A[0….i] with sum value = 
//‘j’. The approach for the problem is:
//
//if (A[i] > j)
//DP[i][j] = DP[i-1][j]
//else 
//DP[i][j] = DP[i-1][j] OR DP[i-1][sum-A[i]]
//This means that if current element has value greater than ‘current sum value’ we will copy the
//answer for previous cases
//And if the current sum value is greater than the ‘ith’ element we will see if any of previous
//states have already experienced the sum=’j’ OR any previous states experienced a value ‘j – A[i]’
//which will solve our purpose.