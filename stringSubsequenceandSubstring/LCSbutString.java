package stringSubsequenceandSubstring;
//Given two string X and Y. The task is to find the length of longest subsequence of string X which is substring in sequence Y.
//
//Examples:
//
//Input : X = "ABCD",  Y = "BACDBDCD"
//Output : 3
//"ACD" is longest subsequence of X which
//is substring of Y.
//
//Input : X = "A",  Y = "A"
//Output : 1
public class LCSbutString 
{
	static int findLongestCommonSubSeq(String s1,String s2)
	{
		int n=s1.length(),m=s2.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(j-1)==s2.charAt(i-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=dp[i][j-1];
			}
		}
		int ans=0;
		for(int i=1;i<=m;i++)
			ans=Math.max(ans, dp[i][n]);
		return ans;
	}
	public static void main (String[] args)  
    { 
		String s1 = "ABCD"; 
	    String s2 = "BACDBDCD"; 
        System.out.println(findLongestCommonSubSeq(s1,s2)); 
    } 
}
//algo
//Let n be length of X and m be length of Y. Create a 2D array ‘dp[][]’ of m + 1 rows and n + 1
//columns. Value dp[i][j] is maximum length of subsequence of X[0….j] which is substring of Y[0….i].
//Now for each cell of dp[][] fill value as :
//	for (i = 1 to m)
//		  for (j = 1 to n)
//		    if (x[i-1] == y[j - 1])
//		      dp[i][j] = dp[i-1][j-1] + 1;
//		    else
//		      dp[i][j] = dp[i][j-1];
//		And finally, the length of the longest subsequence of x which is substring of y is max(dp[i][n]) where 1 <= i <= m.