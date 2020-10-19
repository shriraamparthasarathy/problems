package stringAnagram;
//Given two strings of lowercase alphabets and a value k, the task is to find
//if two strings are K-anagrams of each other or not.
//
//Two strings are called k-anagrams if following two conditions are true.
//
//Both have same number of characters.
//Two strings can become anagram by changing at most k characters in a string.
//Examples :
//
//Input:  str1 = "anagram" , str2 = "grammar" , k = 3
//Output:  Yes
//Explanation: We can update maximum 3 values and 
//it can be done in changing only 'r' to 'n' 
//and 'm' to 'a' in str2.
//
//Input:  str1 = "geeks", str2 = "eggkf", k = 1
//Output:  No
//Explanation: We can update or modify only 1 
//value but there is a need of modifying 2 characters. 
//i.e. g and f in str 2.
public class KAnagram 
{
	static boolean areKAnagrams(String str1,String str2,int k)
	{
		int count[]=new int[26];
		int res=0;
		for(int i=0;i<str1.length();i++)
			count[str1.charAt(i)-'a']++;
		for(int i=0;i<str2.length();i++)
		{
			if(count[str2.charAt(i)-'a']>0)
				count[str2.charAt(i)-'a']--;
			else
				res++;
		}
		return res<=k;
	}
	public static void main(String args[]) 
    { 
        String str1 = "fodr"; 
        String str2 = "gork"; 
        int k = 2; 
        if (areKAnagrams(str1, str2, k)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
}
//algo:
//same as removetogetanagram program but we have an additional condition where count<=k