package stringSubsequenceandSubstring;
//Input: str = "abc"
//Output: 0
//There is no repeating subsequence
//
//Input: str = "aab"
//Output: 1
//The two subssequence are 'a'(first) and 'a'(second). 
//Note that 'b' cannot be considered as part of subsequence 
//as it would be at same index in both.
//
//Input: str = "aabb"
//Output: 2
//
//Input: str = "axxxy"
//Output: 2
public class LongestRepeatingSubsequence 
{
	static int findLongestRepeatingSubSeq(String s)
	{
		int n=s.length();
		int dp[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s.charAt(i-1)==s.charAt(j-1)&&i!=j)
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[n][n];
	}
	public static void main (String[] args)  
    { 
        String str = "aabb"; 
        System.out.println("The length of the largest subsequence that"
            +" repeats itself is : "+findLongestRepeatingSubSeq(str)); 
    } 
}
//algo
//This problem is just the modification of Longest Common Subsequence problem.
//The idea is to find the LCS(str, str)where str is the input string with the restriction
//that when both the characters are same, they shouldn�t be on the same index in the two strings.