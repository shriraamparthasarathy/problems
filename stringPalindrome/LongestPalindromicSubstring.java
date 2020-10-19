package stringPalindrome;
//Given a string, find the longest substring which is palindrome.
//
//For Example:
//
//Input: Given string :"forgeeksskeegfor", 
//Output: "geeksskeeg".
//
//Input: Given string :"Geeks", 
//Output: "ee".
public class LongestPalindromicSubstring 
{
	static int longestPalSubstr(String str)
	{
		int start=0,maxlen=Integer.MIN_VALUE;
		int high=0,low=0;
		int n=str.length();
		for(int i=1;i<n;i++)
		{
			// Find the longest even 
            // length palindrome with 
            // center points as i-1 and i. 
			low=i-1;
			high=i;
			while(low>=0&&high<n&&(str.charAt(low)==str.charAt(high)))
			{
				if(high-low+1>maxlen)
				{
					start=low;
					maxlen=high-low+1;
				}
				high++;
				low--;
			}
			// Find the longest odd length 
            // palindrome with center point as i 
			low=i-1;
			high=i+1;
			while(low>=0&&high<n&&(str.charAt(low)==str.charAt(high)))
			{
				if(high-low+1>maxlen)
				{
					start=low;
					maxlen=high-low+1;
				}
				high++;
				low--;
			}
		}
		System.out.println(str.substring(start, start+maxlen));
		return maxlen;
	}
	public static void main(String[] args) 
    { 
  
        String str = "forgeeksskeegfor"; 
        System.out.println("Length is: " + longestPalSubstr(str)); 
    } 
}
//algo: time complexity O(n^2) space O(1)
//Dynamic programming solution is already discussed here previous post. The time complexity of 
//the Dynamic Programming based solution is O(n^2) and it requires O(n^2) extra space. We can find 
//the longest palindrome substring in (n^2) time with O(1) extra space. The idea is to generate all
//even length and odd length palindromes and keep track of the longest palindrome seen so far.
//
//The idea is to generate all even length and odd length palindromes and keep track of the longest
//palindrome seen so far.
//To generate odd length palindrome, Fix a centre and expand in both directions for longer 
//palindromes, i.e. fix i (index) as center and two indices as i1 = i+1 and i2 = i-1
//Compare i1 and i2 if equal then decrease i2 and increase i1 and find the maximum length.
//Use a similar technique to find the even length palindrome.
//Take two indices i1 = i and i2 = i-1 and compare characters at i1 and i2 and find the maximum
//length till all pair of compared characters are equal and store the maximum length.
//Print the maximum length.
