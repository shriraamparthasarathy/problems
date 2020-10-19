package stringSubsequenceandSubstring;
//Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
//Examples:
//
//Input: str = "abcabcabc"
//Output: true
//The given string is 3 times repetition of "abc"
//
//Input: str = "abadabad"
//Output: true
//The given string is 2 times repetition of "abad"
//
//Input: str = "aabaabaabaab"
//Output: true
//The given string is 4 times repetition of "aab"
//
//Input: str = "abcdabc"
//Output: false
public class RepeatingStrings 
{
	static boolean isRepeat(String s)
	{
		int first=0,second=1,n=s.length();
		int diff=0;
		if(n==0)
			return false;
		while(second<n)
		{
			if(s.charAt(first)==s.charAt(second))
				first++;
			else
			{
				if(first!=0)
					second--;
				first=0;
			}
			second++;
		}
		diff=second-first;
		if(diff!=n&&n%diff==0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) 
	{ 
		String txt[] = {"ABCABC", "ABABAB", "ABCDABCD",  
	                "GEEKSFORGEEKS", "GEEKGEEK",  
	                "AAAACAAAAC", "ABCDABC"}; 
		int n = txt.length; 
		for (int i = 0; i < n; i++) 
		{ 
			if(isRepeat(txt[i]) == true) 
				System.out.println("True"); 
			else
				System.out.println("False"); 
		} 
	} 
}
//algo
//Time Complexity : O(n)
//* Space Complexity : O(1)
//* 
//   
//   Maintain two indexes (let’s say firstIndex and secondIndex )
//   secondIndex only moves forward while firstIndex moves forward only when 
//   string[firstIndex]==string[secondIndex]
//   else it will reset to start index i.e.., zero(0) index.