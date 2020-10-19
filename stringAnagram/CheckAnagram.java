package stringAnagram;
//Write a function to check whether two given strings are anagram of each other or not.
//An anagram of a string is another string that contains same characters, only the order of 
//characters can be different. For example, “abcd” and “dabc” are anagram of each other.

//NOTE: This is also called as checking permutations of two strings are same
public class CheckAnagram 
{
	static boolean areAnagram(String str1,String str2)
	{
		int count[]=new int[256];
		if(str1.length()!=str2.length())
			return false;
		for(int i=0;i<str1.length();i++)
		{
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}
		for(int i=0;i<count.length;i++)
			if(count[i]!=0)
				return false;
		return true;
	}
	public static void main(String args[]) 
    { 
        String str1 = "geeksforgeeks"; 
        String str2 = "forgeeksgeeks"; 
  
        if (areAnagram(str1, str2)) 
            System.out.println("The two strings are"
                               + " anagram of each other"); 
        else
            System.out.println("The two strings are not"
                               + " anagram of each other"); 
    } 
}
//algo: time complexity O(n) space O(1)
//We can increment the value in count array for characters in str1 and decrement 
//for characters in str2. Finally, if all count values are 0, then the two strings
//are anagram of each other. 