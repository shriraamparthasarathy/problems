//Given a string check if it is Pangram or not. 
//A pangram is a sentence containing every letter in the English Alphabet.
//Examples : The quick brown fox jumps over the lazy dog ” is a Pangram 
//[Contains all the characters from ‘a’ to ‘z’]
//“The quick brown fox jumps over the dog” is not a Pangram 
//[Doesn’t contains all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing]

package stringBasics;
public class Pangram
{
	static boolean isPangram(String str)
	{
		boolean mark[]=new boolean[26];
		for(int i=0;i<str.length();i++)
		{
			int index=0;
			if('A'<=str.charAt(i) && str.charAt(i)<='Z')
				index=str.charAt(i)-'A';
			else if('a'<=str.charAt(i) && str.charAt(i)<='z')
				index=str.charAt(i)-'a';
			else
				continue;
			mark[index]=true;
		}
		for(int i=0;i<26;i++)
			if(mark[i]==false)
				return false;
		return true;
	}
	public static void main(String args[])
	{
		String str="The quick brown fox jumps over the lazy dog";
		if(isPangram(str))
			System.out.println("Pangram");
		else
			System.out.println("Not a pangram");
	}
}
//algo: Time complexity O(n) space O(1)
//We create a mark[] array of Boolean type. 
//We iterate through all the characters of our string and 
//whenever we see a character we mark it. 
//Lowercase and Uppercase are considered the same.
//So ‘A’ and ‘a’ are marked in index 0 and similarly ‘Z’ and ‘z’ are marked in index 25.
//
//After iterating through all the characters we check whether all the characters are marked
//or not. If not then return false as this is not a pangram else return true.