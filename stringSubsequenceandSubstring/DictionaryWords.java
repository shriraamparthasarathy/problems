package stringSubsequenceandSubstring;
//Giving a dictionary and a string ‘str’, find the longest string in dictionary which can be formed by deleting some characters of the given ‘str’.
//
//Examples:
//
//Input : dict = {"ale", "apple", "monkey", "plea"}   
//        str = "abpcplea"  
//Output : apple 
//
//Input  : dict = {"pintu", "geeksfor", "geeksgeeks", 
//                                        " forgeek"} 
//         str = "geeksforgeeks"
//Output : geeksgeeks
public class DictionaryWords 
{
	static boolean isSubSequence(String s1,String s2) // s2 will be String str
	{
		int i=0,j=0;
		for(i=0;i<s2.length()&&j<s1.length();i++)
			if(s2.charAt(i)==s1.charAt(j))
				j++;
		return j==s1.length();		
	}
	static String findLongestString(String dict[],String s)
	{
		int length=0;
		String word="";
		for(String temp:dict)
		{
			if(length<temp.length()&&isSubSequence(temp,s))
			{
				word=temp;
				length=temp.length();
			}
		}
		return word;
	}
	public static void main(String[] args)  
    { 
        String[] dict = {"ale", "apple", "monkey", "plea"}; 
        String str = "abpcplea"; 
        System.out.println(findLongestString(dict, str)); 
    } 
}
//algo
//Time Complexity : O(N*K*n) Here N is the length of dictionary and n is 
//the length of given string ‘str’ and K – maximum length of words in the dictionary.
//
//Auxiliary Space : O(1)
//This problem reduces to finding if a string is subsequence of another
//string or not. We traverse all dictionary words and for every word,
//we check if it is subsequence of given string and is largest of all such words.
//We finally return the longest word with given string as subsequence.