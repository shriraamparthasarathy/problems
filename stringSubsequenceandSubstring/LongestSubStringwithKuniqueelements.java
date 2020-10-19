package stringSubsequenceandSubstring;

import java.util.Arrays;
//Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.
//Examples:
//
//"aabbcc", k = 1
//Max substring can be any one from {"aa" , "bb" , "cc"}.
//
//"aabbcc", k = 2
//Max substring can be any one from {"aabb" , "bbcc"}.
//
//"aabbcc", k = 3
//There are substrings with exactly 3 unique characters
//{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
//Max is "aabbcc" with length 6.
//
//"aaabbb", k = 3
//There are only two unique characters, thus show error message. 
public class LongestSubStringwithKuniqueelements 
{
	static boolean isValid(int[] count,int k)
	{
		int res=0;
		for(int i=0;i<26;i++)
			if(count[i]>0)
				res++;
		return k>=res;
	}
	static void kUniques(String s,int k)
	{
		int count[]=new int[26];
		int cur_start=0,cur_end=0,max_window=1,max_start=0,u=0;
		for(int i=0;i<s.length();i++)
		{
			if(count[s.charAt(i)-'a']==0)
				u++;
			count[s.charAt(i)-'a']++;	
		}
		if(u<k)
		{
			System.out.println("Not enough unique characters");
			return;
		}
		Arrays.fill(count, 0);
		count[s.charAt(0)-'a']++;
		for(int i=1;i<s.length();i++)
		{
			count[s.charAt(i)-'a']++;
			cur_end++;
			while(!isValid(count,k))
			{
				count[s.charAt(cur_start)-'a']--;
				cur_start++;
			}
			if(cur_end-cur_start+1>max_window)
			{
				max_window=cur_end-cur_start+1;
				max_start=cur_start;
			}
		}
		System.out.println("Max sustring is : "
                + s.substring(max_start, max_start +max_window) 
                + " with length " + max_window); 
	}
	static public void main(String[] args) 
	{ 
	        String s = "aabacbebebe"; 
	        int k = 3; 
	        kUniques(s, k); 
	} 
}
//algo
//The problem can be solved in O(n). Idea is to maintain a window 
//and add elements to the window till it contains less or equal k,
//update our result if required while doing so. If unique elements
//exceeds than required in window, start removing the elements from left side.
//
//Below are the implementations of above. The implementations
//assume that the input string alphabet contains only 26 characters (from ‘a’ to ‘z’). 
//The code can be easily extended to 256 characters.