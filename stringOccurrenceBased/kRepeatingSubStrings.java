package stringOccurrenceBased;
import java.util.HashMap;
//Given a string, find if it is possible to convert it to a string that is repetition of
//substring with k characters. To convert, we can replace one substring of length k with k 
//characters.
//
//Examples:
//
//Input: str = "bdac",  k = 2
//Output: True
//We can either replace "bd" with "ac" or 
//"ac" with "bd".
//
//Input: str = "abcbedabcabc",  k = 3
//Output: True
//Replace "bed" with "abc" so that the 
//whole string becomes repetition of "abc".
//
//Input: str = "bcacc", k = 3
//Output: False
//k doesn't divide string length i.e. 5%3 != 0
//
//Input: str = "bcacbcac", k = 2
//Output: False
//
//Input: str = "bcdbcdabcedcbcd", k = 3
//Output: False
public class kRepeatingSubStrings 
{
	static boolean checkString(String s,int k)
	{
		HashMap<String,Integer> hm=new HashMap<>();
		int n=s.length();
		if(n%k!=0)
			return false;
		for(int i=0;i<n;i+=k)
			hm.put(s.substring(i, i+k), hm.get(s.substring(i, i+k))==null?1:hm.get(s.substring(i, i+k))+1);
		if(hm.size()==1)
			return true;
		if(hm.size()!=2)
			return false;
		HashMap.Entry<String,Integer> entry=hm.entrySet().iterator().next();
		if(entry.getValue()==(n/k-1)||entry.getValue()==1)
			return true;
		return false;
	}
	public static void main(String[] args)  
    { 
        if (checkString("abababcd", 2)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
}
//algo
//Idea is to put all substring into a map 
//if there is more than 2 substring then not possible.
//if only 2 then the occurrence of one substring should be 1 or i/k -1 as we can only afford 1 diff substring
