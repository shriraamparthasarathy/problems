package stringAnagram;
//We have given a anagram string and we have to check whether it can be made palindrome o not.
//
//Examples:
//
//Input : geeksforgeeks 
//Output : No
//There is no palindrome anagram of 
//given string
//
//Input  : geeksgeeks
//Output : Yes
//There are palindrome anagrams of
//given string. For example kgeeseegk
public class isPalindromeAnyAnagamofthegivenString 
{
	static boolean canFormPalindrome(String s)
	{
		int count[]=new int[256];
		int odd=0;
		for(int i=0;i<s.length();i++)
			count[s.charAt(i)]++;
		for(int i=0;i<count.length;i++)
		{
			if(count[i]%2!=0)
				odd++;
			if(odd>1)
				return false;
		}		
		return true;
	}
	public static void main(String args[]) 
    { 
        System.out.println(canFormPalindrome("geeksforgeeks") 
                               ? "Yes"
                               : "No"); 
        System.out.println(canFormPalindrome("geeksogeeks") 
                               ? "Yes"
                               : "No"); 
    } 
}
//algo
//1) Create a count array of alphabet size which is typically 256. 
//Initialize all values of count array as 0.
//2) Traverse the given string and increment count of every character.
//3) Traverse the count array and if the count array has more than one odd values,
//return false. Otherwise return true.