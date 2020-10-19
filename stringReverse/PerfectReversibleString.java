package stringReverse;
//You are given a string ‘str’, the task is to check that reverses of all possible substrings 
//of ‘str’ are present in ‘str’ or not.
//
//Examples:
//
//Input : str = "ab"
//Output: "NO"
//// all substrings are "a","b","ab" but reverse
//// of "ab" is not present in str
//
//Input : str = "aba"
//Output: "YES"
//
//Input : str = "abab"
//Output: "NO"
// All substrings are "a", "b", "a", "b", "ab", 
// "ba", "ab", "aba", "bab", "abab" but reverse of
// "abab" is not present in str
public class PerfectReversibleString 
{
	static boolean isReversible(String str)
	{
		int l=0,r=str.length()-1;
		while(l<r)
		{	
			if(str.charAt(l)!=str.charAt(r))
				return false;
			l++;
			r--;
		}		
		return true;
	}
	public static void main (String[] args)  
	{ 
	    String str = "aba"; 
	    if (isReversible(str)) 
	        System.out.print("YES"); 
	    else
	        System.out.print( "NO"); 
	} 
}
//algo: check whether the string is palindrome
//reverse of all substrings of ‘str’ will exist in ‘str’ if and only if the entire string ‘str’
//is palindrome. We can justify this fact by considering the whole string, a reverse of it will 
//exist only if it is palindrome. And if a string is palindrome, then all reverse of all substrings
//exist.