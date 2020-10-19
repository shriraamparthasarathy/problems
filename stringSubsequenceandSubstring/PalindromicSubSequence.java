package stringSubsequenceandSubstring;
//Find how many palindromic subsequence (need not necessarily be distinct) can be formed in a given string. Note that the empty string is not considered as a palindrome.
//Examples:
//
//Input : str = "abcd"
//Output : 4
//Explanation :- palindromic  subsequence are : "a" ,"b", "c" ,"d" 
//
//Input : str = "aab"
//Output : 4
//Explanation :- palindromic subsequence are :"a", "a", "b", "aa"
//
//Input : str = "aaaa"
//Output : 15
public class PalindromicSubSequence 
{
	static String str="abcb";
	static int dp[][]=new int[1000][1000];
	static int n;
	static int countPS(int i,int j)
	{
		if(i>=n||j<0)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		if(i-j==1||i-j==-1)
		{
			if(str.charAt(i)==str.charAt(j))
				return dp[i][j]=3;
			else
				return dp[i][j]=2;
		}
		if(i==j)
			return 1;
		else if(str.charAt(i)==str.charAt(j))
			return dp[i][j]=countPS(i+1,j) + countPS(i,j-1)+1;
		else
			return dp[i][j]=countPS(i+1,j) + countPS(i,j-1)-countPS(i+1,j-1);
		
	}
	
	public static void main(String[] args)  
    {  
        for(int i = 0; i < 1000; i++)  
            for(int j = 0; j < 1000; j++)  
                dp[i][j] = -1;  
      
        n=str.length();  
            System.out.println("Total palindromic subsequence" +  
                            "are : "+ countPS(0,n-1));  
    }  
}
