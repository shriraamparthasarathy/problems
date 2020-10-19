package stringPalindrome;
//Given a string str, the task is to find the minimum number of characters to be inserted to
//convert it to palindrome.
//Before we go further, let us understand with few examples:
//
//ab: Number of insertions required is 1 i.e. bab
//aa: Number of insertions required is 0 i.e. aa
//abcd: Number of insertions required is 3 i.e. dcbabcd
//abcda: Number of insertions required is 2 i.e. adcbcda which is same as number of insertions in 
//the substring bcd(Why?).
//abcde: Number of insertions required is 4 i.e. edcbabcde
public class MinChartoMakePalindrome 
{
	static int LCS(String x,String y,int n)
	{
		int dp[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(x.charAt(i-1)==y.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[n][n];
	}
	static int findMinInsertionsLCS(String str,int n)
	{
		StringBuffer sb=new StringBuffer(str);
		sb.reverse();
		String stringreverse=sb.toString();
		return(n-LCS(str,stringreverse,n));
	}
	public static void main(String args[]) 
    { 
        String str = "geeks"; 
        System.out.println(findMinInsertionsLCS(str, str.length())); 
    } 
}
//algo: timecomplexity O(n^2) space O(n^2)
//The problem of finding minimum insertions can also be solved using Longest Common Subsequence 
//(LCS) Problem. If we find out LCS of string and its reverse, we know how many maximum characters
//can form a palindrome. We need insert remaining characters. Following are the steps.
//
//Find the length of LCS of input string and its reverse. Let the length be ‘l’.
//The minimum number insertions needed is length of input string minus ‘l’.