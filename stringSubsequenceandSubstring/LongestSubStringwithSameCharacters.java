package stringSubsequenceandSubstring;
//We have a string of length n, which consist only UPPER and LOWER CASE characters and we have a number k (always less than n and greater than 0). We can make at most k changes in our string such that we can get a sub-string of maximum length which have all same characters.
//
//Examples:
//
//n = length of string
//k = changes you can make
//Input : n = 5 k = 2
//        str = ABABA
//Output : maximum length = 5
//which will be (AAAAA)
//
//Input : n = 6 k = 4
//       str = HHHHHH
//Output : maximum length=6
//which will be(HHHHHH) 
public class LongestSubStringwithSameCharacters 
{
	static int findMax(String s,int n,int k,char ch)
	{
		int maxlen=1,l=0,r=0,count=0;
		while(r<n)
		{
			if(s.charAt(r)!=ch)
				count++;
			while(count>k)
			{
				if(s.charAt(l)!=ch)
					count--;
				l++;
			}
			maxlen=Math.max(maxlen, r-l+1);
			r++;
		}
		return maxlen;
	}
	static int answer(String s,int n,int k)
	{
		int maxlen=0;
		for(int i=0;i<26;i++)
		{
			maxlen=Math.max(maxlen, findMax(s,n,k,(char)(i+'a')));
			maxlen=Math.max(maxlen, findMax(s,n,k,(char)(i+'A')));
		}
		return maxlen;
	}
	public static void main(String[] args) 
    { 
        int n = 5, k = 2; 
        String A = "ABABA"; 
        System.out.println("Maximum length = " + answer(A, n, k)); 
       
        n = 6; k = 4; 
        String B = "HHHHHH"; 
        System.out.println("Maximum length = " + answer(B, n, k)); 
    } 
}
//algo
//We check for each character of English alphabet (both upper and lower cases one by one).
//We are basically looking for maximum length of sub-string that can be formed by each character 
//and whichever character will form the sub-string of maximum length then that length will be our
//answer.
//
//We check for maximum length of sub-string that can be formed by every character in a set
//of 52 characters (From ‘A’ to ‘Z’ and from ‘a’ to ‘z’).
//For doing this we traverse whole string and whenever we find a different character, we
//increase the count.
//If count becomes greater than k (at right index), we again start from 0th index and if we
//found different character we will decrease the count.
//When count will be equal to k (at left index) then at that point the length will be 
//rightIndex-leftIndex+1.
//We repeat this process until we reach at the end of string and at that point we will 
//return the maximum length.
//We do this for all characters and finally return the maximum length.