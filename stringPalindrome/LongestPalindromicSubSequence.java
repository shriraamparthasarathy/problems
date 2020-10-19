package stringPalindrome;
//As example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is
//the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also palindromic subsequences of 
//the given sequence, but not the longest ones.
public class LongestPalindromicSubSequence 
{
	static int lps(String str)
	{
		int n=str.length();
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++)
			dp[i][i]=1;
		for(int cl=2;cl<=n;cl++)
		{
			for(int i=0;i<n-cl+1;i++)
			{
				int j=i+cl-1;
				if(str.charAt(i)==str.charAt(j)&&cl==2)
					dp[i][j]=2;
				else if(str.charAt(i)==str.charAt(j))
					dp[i][j]=dp[i+1][j-1]+2;
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
		return dp[0][n-1];
	}
	public static void main(String args[]) 
    { 
        String seq = "GEEKSFORGEEKS";
        System.out.println("The length of the lps is "+ lps(seq)); 
    } 
}
