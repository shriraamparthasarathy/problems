package stringSubsequenceandSubstring;
//Given two strings in lowercase, find the longest string whose permutations are subsequences of given two strings. The output longest string must be sorted.
//
//Examples:
//
//Input  :  str1 = "pink", str2 = "kite"
//Output : "ik" 
//The string "ik" is the longest sorted string 
//whose one permutation "ik" is subsequence of
//"pink" and another permutation "ki" is 
//subsequence of "kite". 
//
//Input  : str1 = "working", str2 = "women"
//Output : "now"
//
//Input  : str1 = "geeks" , str2 = "cake"
//Output : "ek"
//
//Input  : str1 = "aaaa" , str2 = "baba"
//Output : "aa"
public class LCSwithPermutations 
{
	static void longestString(String s1,String s2)
	{
		int count1[]=new int[26],count2[]=new int[26];
		for(int i=0;i<s1.length();i++)
			count1[s1.charAt(i)-'a']++;
		for(int i=0;i<s2.length();i++)
			count2[s2.charAt(i)-'a']++;
		String res="";
		for(int i=0;i<26;i++)
		{
			for(int j=1;j<=Math.min(count1[i],count2[i]);j++)
				res+=(char)(i+'a');
		}
		System.out.println(res);
	}
	public static void main(String[] args) 
	{ 
        String str1 = "geeks", str2 = "cake"; 
        longestString(str1, str2); 
    } 
}
//algo: time O(m+n) space O(1)
//The idea is to count characters in both strings.
//
//calculate frequency of characters for each string and store them in their respective count arrays, say count1[] for str1 and count2[] for str2.
//Now we have count arrays for 26 characters. So traverse count1[] and for any index ‘i’ append character (‘a’+i) in resultant string ‘result’ by min(count1[i], count2[i]) times.
//Since we traverse count array in ascending order, our final string characters will be in sorted order.