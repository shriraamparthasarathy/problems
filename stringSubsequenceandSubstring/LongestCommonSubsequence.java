package stringSubsequenceandSubstring;

public class LongestCommonSubsequence 
{
	static int findLongestCommonSubSeq(String s1,String s2)
	{
		int m=s1.length(),n=s2.length();
		int dp[][]=new int[n+1][n+1];
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[m][n];
	}
	public static void main (String[] args)  
    { 
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
        System.out.println("The length of the largest subsequence that"
            +" is common: "+findLongestCommonSubSeq(s1,s2)); 
    } 
}
//algo
//same as longestrepeatingsubsequence but with 2 strings and that i can be = j