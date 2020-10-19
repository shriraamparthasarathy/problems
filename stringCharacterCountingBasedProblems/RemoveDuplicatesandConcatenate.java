package stringCharacterCountingBasedProblems;
import java.util.HashMap;
//Two strings are given and you have to modify 1st string such that all the common characters of the 2nd strings have to be removed and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.
//
//Examples:
//
//Input : S1 = "aacdb"
//        S2 = "gafd"
//Output : "cbgf"
//
//Input : S1 = "abcs";
//        S2 = "cxzca";
//Output : "bsxz"
public class RemoveDuplicatesandConcatenate 
{
	static String concatenatedString(String s1,String s2)
	{
		String res="";
		HashMap<Character,Integer> hm=new HashMap<>();
		for(int i=0;i<s1.length();i++)
			hm.put(s1.charAt(i),1);
		for(int i=0;i<s2.length();i++)
		{
			if(!hm.containsKey(s2.charAt(i)))
				res+=s2.charAt(i);
			else
				hm.put(s2.charAt(i),2);
		}
		for(int i=0;i<s1.length();i++)
			if(hm.get(s1.charAt(i))==1)
				res+=s1.charAt(i);
		return res;
	}
	public static void main(String[] args) 
    { 
        String s1 = "abcs"; 
        String s2 = "cxzca"; 
        System.out.println(concatenatedString(s1, s2)); 
    } 
}
//algo
//The idea is to use hash map where key is character and value is number 
//of strings in which character is present. If a character is present in one string, 
//then count is 1, else if character is present in both strings, count is 2.
//
//Initialize result as empty string.
//Push all characters of 2nd string in map with count as 1.
//Traverse first string and append all those characters to result that are not present in map.
//Characters that are present in map, make count 2.
//Traverse second string and append all those characters to result whose count is 1.