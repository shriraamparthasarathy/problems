package stringSubsequenceandSubstring;
//Given two strings, find the number of times the second string occurs in the first string,
//whether continuous or discontinuous.
//
//Examples:
//
//Input:  
//string a = "GeeksforGeeks"
//string b = "Gks"
//
//Output: 4


public class CountSubSequenceinString 
{
	static int count(String a,String b,int m,int n)
	{
		if((m==0&&n==0)||(n==0))
			return 1;
		if(m==0)
			return 0;
		if(a.charAt(m-1)==b.charAt(n-1))
			return count(a,b,m-1,n-1) + count(a,b,m-1,n);
		else
			return count(a,b,m-1,n);
	}
	public static void main (String[] args)  
    { 
        String a = "GeeksforGeeks"; 
        String b = "Gks"; 
        System.out.println( count(a, b, a.length(), b.length())) ; 
      
    } 
}
//If we carefully analyze the given problem, we can see that it can be easily divided into sub-problems. The idea is to process all characters of both strings one by one staring from either from left or right side. Let us traverse from right corner, there are two possibilities for every pair of character being traversed.
//
//m: Length of str1 (first string)
//n: Length of str2 (second string)
//
//If last characters of two strings are same, 
//   1. We consider last characters and get count for remaining 
//      strings. So we recur for lengths m-1 and n-1. 
//   2. We can ignore last character of first string and 
//      recurse for lengths m-1 and n.
//else 
//If last characters are not same, 
//   We ignore last character of first string and 
//   recurse for lengths m-1 and n.