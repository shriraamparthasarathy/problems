package stringSubsequenceandSubstring;
//Given a string, find the count of distinct subsequences of it.
//
//Examples:
//
//Input  : str = "gfg"
//Output : 7
//The seven distinct subsequences are "", "g", "f",
//"gf", "fg", "gg" and "gfg" 
//
//Input  : str = "ggg"
//Output : 4
//The four distinct subsequences are "", "g", "gg"
//and "ggg" 
import java.util.Arrays;

public class CountDistinctSubSequence 
{
	static int countSub(String s)
	{
		int n=s.length();
		int dp[]=new int[n+1];
		int last[]=new int[256];
		Arrays.fill(last, -1);
		dp[0]=1;
		for(int i=1;i<=n;i++)
		{
			dp[i]=2*dp[i-1];
			if(last[s.charAt(i-1)]!=-1)
				dp[i]=dp[i]-dp[last[s.charAt(i-1)]];
			last[s.charAt(i-1)]=i-1;
		}
		return dp[n];
		
	}
	public static void main(String args[]) 
    { 
        System.out.println(countSub("gfg")); 
    }
}
//algo
//An Efficient Solution doesn’t require the generation of subsequences.
//
//Let countSub(n) be count of subsequences of 
//first n characters in input string. We can
//recursively write it as below. 
//
//countSub(n) = 2*Count(n-1) - Repetition
//
//If current character, i.e., str[n-1] of str has
//not appeared before, then 
//   Repetition = 0
//
//Else:
//   Repetition  =  Count(m)
//   Here m is index of previous occurrence of
//   current character. We basically remove all
//   counts ending with previous occurrence of
//   current character.
//How does this work?
//If there are no repetitions, then count becomes double of count for n-1 because we get count(n-1) more subsequences by adding current character at the end of all subsequences possible with n-1 length.
//If there repetitions, then we find count of all distinct subsequences ending with previous occurrence. This count can be obtained be recursively calling for index of previous occurrence.
//
//Since above recurrence has overlapping subproblems, we can solve it using Dynamic Programming.