package stringAnagram;
//Remove minimum number of characters so that two strings become anagram
//Given two strings in lowercase, the task is to make them anagram. 
//The only allowed operation is to remove a character from any string.
//Find minimum number of characters to be deleted to make both the strings anagram?
//If two strings contains same data set in any order then strings are called Anagrams.
//
//Examples :
//
//Input : str1 = "bcadeh" str2 = "hea"
//Output: 3
//We need to remove b, c and d from str1.
//
//Input : str1 = "cddgk" str2 = "gcd"
//Output: 2
//
//Input : str1 = "bca" str2 = "acb"
//Output: 0

//NOTE: this is also called as Minimum Number of Manipulations required to make two Strings Anagram Without Deletion of Character
public class RemovetoGetAnagram
{	
	static int countDeletions(String str1,String str2)
	{
		int count[]=new int[26];
		int res=0;
		for(int i=0;i<str1.length();i++)
			count[str1.charAt(i)-'a']++;
		for(int i=0;i<str2.length();i++)
			count[str2.charAt(i)-'a']--;
		for(int i=0;i<count.length;i++)
			res+=Math.abs(count[i]);
		return res;
	}
	static public void main(String[] args) 
	{ 
        String str1 = "bcadeh", str2 = "hea"; 
        System.out.println(countDeletions(str1, str2)); 
    } 
}
