package stringCharacterCountingBasedProblems;
import java.util.HashMap;
import java.util.Map;
//Given an array of n words. Some words are repeated twice, we need count such words.
//Examples:
//
//Input : s[] = {"hate", "love", "peace", "love", 
//               "peace", "hate", "love", "peace", 
//               "love", "peace"};
//Output : 1
//There is only one word "hate" that appears twice
//
//Input : s[] = {"Om", "Om", "Shankar", "Tripathi", 
//                "Tom", "Jerry", "Jerry"};
//Output : 2
//There are two words "Om" and "Jerry" that appear
//twice.
public class CountWordsTwo 
{
	static int countWords(String s[],int n)
	{
		HashMap<String,Integer> hm=new HashMap<>();
		int count=0;
		for(String str:s)
		{
			if(hm.containsKey(str))
			{
				int m=hm.get(str);
				hm.put(str,m+1);
			}
			else
				hm.put(str,1);
		}
		for(Map.Entry<String, Integer> it:hm.entrySet())
			if(it.getValue()==2)
				count++;
		return count;
	}
	public static void main(String args[]) 
    { 
        String s[] = { "hate", "love", "peace", "love", 
                       "peace", "hate", "love", "peace", 
                       "love", "peace" }; 
        int n = s.length; 
        System.out.println( countWords(s, n)); 
    } 
}
//algo
//Traverse the given array, store counts of words in a hash table
//Traverse hash table and count all words with count 2.