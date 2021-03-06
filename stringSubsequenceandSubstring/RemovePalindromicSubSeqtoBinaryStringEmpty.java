package stringSubsequenceandSubstring;
//Given a binary string, count minimum number of subsequences to be removed to make it an empty string.
//
//Examples :
//
//Input: str[] = "10001"
//Output: 1
//Since the whole string is palindrome, 
//we need only one removal.
//
//Input: str[] = "10001001"
//Output: 2
//We can remove the middle 1 as first 
//removal, after first removal string
//becomes 1000001 which is a palindrome.
public class RemovePalindromicSubSeqtoBinaryStringEmpty 
{
	static boolean isPalindrome(String s)
	{
		int l=0,h=s.length()-1;
		while(l<=h)
		{
			if(s.charAt(l++)!=s.charAt(h--))
				return false;
		}
		return true;
	}
	static int minRemovals(String s)
	{
		if(s.charAt(0)=='\0')
			return 0;
		if(isPalindrome(s))
			return 1;
		return 2;
	}
	public static void main (String[] args)  
	{ 
	    System.out.println (minRemovals("010010")); 
	    System.out.println (minRemovals("0100101")); 
	          
	} 
}
//algo
//The problem is simple and can be solved easily using below two facts.
//1) If given string is palindrome, we need only one removal.
//2) Else we need two removals. Note that every binary string has all 1�s as a subsequence 
//and all 0�s as another subsequence. We can remove any of the two subsequences to get a
//unary string. A unary string is always palindrome.