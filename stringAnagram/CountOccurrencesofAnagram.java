package stringAnagram;
//Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search
//(char pat[], char txt[]) that prints all occurrences of pat[] and its permutations
//(or anagrams) in txt[]. You may assume that n > m.
//Expected time complexity is O(n)
//
//Examples:
//
//1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
//   Output:   Found at Index 0
//             Found at Index 5
//             Found at Index 6
//2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
//   Output:   Found at Index 0
//             Found at Index 1
//             Found at Index 4
public class CountOccurrencesofAnagram 
{
	static boolean compare(int countpat[],int counttxt[])
	{
		for(int i=0;i<256;i++)
		{
			if(countpat[i]!=counttxt[i])
				return false;
		}
		return true;
	}
	static void search(String pat,String txt)
	{
		int countpat[]=new int[256];
		int counttxt[]=new int[256];
		int m=pat.length(),n=txt.length();
		for(int i=0;i<m;i++)
		{
			countpat[pat.charAt(i)]++;
			counttxt[txt.charAt(i)]++;
		}
		for(int i=m;i<n;i++)
		{
			if(compare(countpat,counttxt))
				System.out.println("An anagram is at: "+(i-m));
			counttxt[txt.charAt(i)]++;
			counttxt[txt.charAt(i-m)]--;
		}
		if(compare(countpat,counttxt))
			System.out.println("An anagram is at: "+(n-m));
	}
	public static void main(String args[]) 
    { 
        String txt = "BACDGABCDA"; 
        String pat = "ABCD"; 
        search(pat, txt); 
    } 
}
//algo: time complexity O(n) space O(1)
//We can achieve O(n) time complexity under the assumption that alphabet size is fixed
//which is typically true as we have maximum 256 possible characters in ASCII.
//The idea is to use two count arrays:
//
//1) The first count array store frequencies of characters in pattern.
//2) The second count array stores frequencies of characters in current window of text.
//
//The important thing to note is, time complexity to compare two count arrays is O(1) as the
//number of elements in them are fixed (independent of pattern and text sizes). Following are steps
//of this algorithm.
//1) Store counts of frequencies of pattern in first count array countP[]. Also store counts of
//frequencies of characters in first window of text in array countTW[].
//
//2) Now run a loop from i = M to N-1. Do following in loop.
//…..a) If the two count arrays are identical, we found an occurrence.
//…..b) Increment count of current character of text in countTW[]
//…..c) Decrement count of first character in previous window in countWT[]
//
//3) The last window is not checked by above loop, so explicitly check it.