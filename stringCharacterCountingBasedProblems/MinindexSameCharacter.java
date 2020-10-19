package stringCharacterCountingBasedProblems;
import java.util.HashMap;
//Given a string str and another string patt. Find the character in patt
//that is present at the minimum index in str. If no character of patt is present in str 
//then print ‘No character present’.
//
//Examples:
//
//Input: str = “geeksforgeeks”, patt = “set”
//Output: e
//Both e and s of patt are present in str,
//but e is present at minimum index, which is 1.
//
//Input: str = “adcffaet”, patt = “onkl”
//Output: No character present
public class MinindexSameCharacter 
{
	static void printMinIndexChar(String str,String pat)
	{
		HashMap<Character,Integer>hm=new HashMap<>();
		int min=Integer.MAX_VALUE;
		for(int i=0;i<str.length();i++)
			if(!hm.containsKey(str.charAt(i)))
				hm.put(str.charAt(i),i);
		for(int i=0;i<pat.length();i++)
		{
			if(hm.containsKey(pat.charAt(i))&&hm.get(pat.charAt(i))<min)
				min=hm.get(pat.charAt(i));
		}
		if(min==Integer.MAX_VALUE)
			System.out.println("No character present");
		else
			System.out.println(str.charAt(min));
	}
	public static void main(String[] args) 
    { 
        String str = "geeksforgeeks"; 
        String patt = "set"; 
        printMinIndexChar(str, patt); 
    } 
}
//algo
//Create a hash table with (key, value) tuple represented as (character, index) tuple.
//Store the first index of each character of str in the hash table.
//Now, for each character of patt check if it is present in the hash table or not.
//If present then get its index from the hash table and update 
//minIndex(minimum index encountered so far).
//For no matching character print “No character present”.