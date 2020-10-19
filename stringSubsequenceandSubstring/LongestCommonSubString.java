package stringSubsequenceandSubstring;

public class LongestCommonSubString 
{
//	Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
//	Examples :
//
//	Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
//	Output : 5
//	The longest common substring is “Geeks” and is of length 5.
//
//	Input : X = “abcdxyz”, y = “xyzabcd”
//	Output : 4
//	The longest common substring is “abcd” and is of length 4.
//
//	Input : X = “zxabcdezy”, y = “yzabcdezx”
//	Output : 6
//	The longest common substring is “abcdez” and is of length 6.
	static int findLongestCommonSubSeq(String s1,String s2)
	{
		int m=s1.length(),n=s2.length();
		int dp[][]=new int[m+1][n+1];
		int ans=0;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
					ans=Math.max(ans, dp[i][j]);
				}
				else
					dp[i][j]=0;
			}
		}
		return ans;
	}
	public static void main (String[] args)  
    { 
		String s1 = "OldSite:GeeksforGeeks.org"; 
	    String s2 = "NewSite:GeeksQuiz.com"; 
        System.out.println(findLongestCommonSubSeq(s1,s2)); 
    } 
}
//algo
//The idea is to find length of the longest common suffix for all substrings of both 
//strings and store these lengths in a table.
//
//The longest common suffix has following optimal substructure property.
//
//If last characters match, then we reduce both lengths by 1
//LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1]
//If last characters do not match, then result is 0, i.e.,
//LCSuff(X, Y, m, n) = 0 if (X[m-1] != Y[n-1])
//
//Now we consider suffixes of different substrings ending at different indexes.
//The maximum length Longest Common Suffix is the longest common substring.
//LCSubStr(X, Y, m, n) = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m and 1 <= j <= n