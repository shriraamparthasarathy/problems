package stringCharacterCountingBasedProblems;
//Given a string, find the all distinct (or non-repeating characters) in it. For example, if the input string is “Geeks for Geeks”, then output should be ‘for’ and if input string is “Geeks Quiz”, then output should be ‘GksQuiz’.
//
//The distinct characters should be printed in same order as they appear in input string.
//
//Examples:
//
//Input  : Geeks for Geeks
//Output : for
//
//Input  : Hello Geeks
//Output : HoGks
import java.util.Arrays;

public class DisinctCharactersinOrder 
{
	static void printDistinct(String s)
	{
		int count[]=new int[256];
		int distinct[]=new int[256];
		int n=s.length();
		for(int i=0;i<256;i++)
			distinct[i]=n;
		for(int i=0;i<n;i++)
		{
			count[s.charAt(i)]++;
			if(count[s.charAt(i)]==1&&s.charAt(i)!=' ')
				distinct[s.charAt(i)]=i;
			else
				distinct[s.charAt(i)]=n;
		}
		Arrays.sort(distinct);
		for(int i=0;i<256&&distinct[i]!=n;i++)
			System.out.print(s.charAt(distinct[i]));
	}
	public static void main(String args[]) 
    { 
        String str = "GeeksforGeeks"; 
        printDistinct(str); 
    } 
}
//algo
//The idea is to use two auxiliary arrays of size 256 (Assuming that characters are
//		stored using 8 bits).
//
//Initialize all values in count[] as 0 and all values in index[] as n where n is length of string.
//Traverse the input string str and do following for every character c = str[i].
//Increment count[x].
//If count[x] is 1, then store index of x in index[x], i.e., index[x] = i
//If count[x] is 2, then remove x from index[], i.e., index[x] = n
//Now index[] has indexes of all distinct characters. Sort indexes and
//print characters using it. Note that this step takes O(1) time assuming number of 
//characters are fixed (typically 256)