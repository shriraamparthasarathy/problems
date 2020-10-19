package stringCharacterCountingBasedProblems;
//We are given a string S, we need to find count of all contiguous substrings starting and ending with same character.
//
//Examples :
//
//Input  : S = "abcab"
//Output : 7
//There are 15 substrings of "abcab"
//a, ab, abc, abca, abcab, b, bc, bca
//bcab, c, ca, cab, a, ab, b
//Out of the above substrings, there 
//are 7 substrings : a, abca, b, bcab, 
//c, a and b.
//
//Input  : S = "aba"
//Output : 4
//The substrings are a, b, a and aba
public class CountFirstLastSameSubstrings 
{
	static int countSubstringWithEqualEnds(String s)
	{
		int res=0;
		int count[]=new int[26];
		for(int i=0;i<s.length();i++)
			count[s.charAt(i)-'a']++;
		for(int i=0;i<26;i++)
			if(count[i]>0)
				res+=count[i]*(count[i]+1)/2;
		return res;
	}
	public static void main(String args[]) 
    { 
        String s = "abcab"; 
        System.out.println(countSubstringWithEqualEnds(s)); 
    } 
}
//algo
//Now if we carefully observe then we can realize that the answer 
//just depends on frequencies of characters in the original string. 
//For example in string abcab, frequency of ‘a’ is 2 and substrings
//contributing to answer are a, abca and a respectively, a total of 3, which is 
//calculated by (frequency of a+1)C2