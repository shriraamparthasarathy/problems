package stringSubsequenceandSubstring;

//Given a string str, find the longest repeating non-overlapping substring in it. In other words find 2 identical substrings of maximum length which do not overlap. If there exists more than one such substring return any of them.
//
//Examples:
//
//Input : str = "geeksforgeeks"
//Output : geeks
//
//Input : str = "aab"
//Output : a
//
//Input : str = "aabaabaaba"
//Output : aaba
//
//Input : str = "aaaaaaaaaaa"
//Output : aaaaa
//
//Input : str = "banana"
//Output : an 
//         or na
public class LongestRepeatingnonOverlappingSubString 
{
	static String findLongestCommonSubSeq(String s)
	{
		int n=s.length();
		int dp[][]=new int[n+1][n+1];
		int maxi=0,end=n;
		for(int i=1;i<=n;i++)
		{
			for(int j=i+1;j<=n;j++)
			{
				if(s.charAt(i-1)==s.charAt(j-1)&&(j-i>dp[i-1][j-1]))
				{
					dp[i][j]=1+dp[i-1][j-1];
					if(dp[i][j]>maxi)
					{
						maxi=dp[i][j];
						end=Math.max(end, i);
					}
				}
			}
		}
		return s.substring(end-maxi, end);
	}
	public static void main (String[] args)  
    { 
		String s = "aaaaa";
        System.out.println(findLongestCommonSubSeq(s)); 
    } 
}
//algo
//This problem can be solved in O(n2) time using Dynamic Programming. 
//The basic idea is to find the longest repeating suffix for all prefixes in the string str.
//
//Length of longest non-repeating substring can be recursively
//defined as below.
//
//LCSRe(i, j) stores length of the matching and
//            non-overlapping substrings ending 
//            with i'th and j'th characters.
//
//If str[i-1] == str[j-1] && (j-i) > LCSRe(i-1, j-1)
//     LCSRe(i, j) = LCSRe(i-1, j-1) + 1, 
//Else
//     LCSRe(i, j) = 0
//
//Where i varies from 1 to n and 
//      j varies from i+1 to n
//To avoid overlapping we have to ensure that the length of suffix is less than (j-i) at any instant.
//The maximum value of LCSRe(i, j) provides the length of the longest repeating substring and
//the substring itself can be found using the length and the ending index of the common suffix.
//
