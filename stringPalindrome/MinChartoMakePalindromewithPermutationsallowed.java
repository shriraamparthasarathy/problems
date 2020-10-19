package stringPalindrome;
//Given a string of lowercase letters. Find minimum characters to be inserted in string
//so that it can become palindrome. We can change positions of characters in string.
//
//Examples:
//
//Input : geeksforgeeks
//Output : 2
//geeksforgeeks can be changed as:
//geeksroforskeeg
//geeksorfroskeeg
//and many more
//
//Input : aabbc
//Output : 0
//aabbc can be changed as:
//abcba
//bacab
public class MinChartoMakePalindromewithPermutationsallowed 
{
	static int minInsertion(String str)
	{
		int odd=0;
		int count[]=new int[26];
		for(int i=0;i<str.length();i++)
			count[str.charAt(i)-'a']++;
		for(int i=0;i<26;i++)
			if(count[i]%2!=0)
				odd++;
		return (odd==0)?0:odd-1; //since one odd also means 0 insertions, 1 -1 =0 insertions
	}
	public static void main(String[] args) 
    { 
        String str = "geeksforgeeks"; 
        System.out.println(minInsertion(str)); 
    } 
}
//algo
//The idea is to count occurrence of each character in a string.
//As palindromic string can have one character which occur odd times so number of insertion
//will be one less then count of characters which occur odd times. And if string is already
//palindrome, we do not need to add any character so result will be 0.