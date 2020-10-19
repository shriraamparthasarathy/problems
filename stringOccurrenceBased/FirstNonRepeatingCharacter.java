package stringOccurrenceBased;
import java.util.HashMap;
//Given a string, find the first non-repeating character in it. 
//For example, if the input string is “GeeksforGeeks”, then the output should be ‘f’ and
//if the input string is “GeeksQuiz”, then the output should be ‘G’.
//Input: "geeksforgeeks"
//Explanation:
//Step 1: Construct a character count array 
//        from the input string.
//   ....
//  count['e'] = 4
//  count['f'] = 1
//  count['g'] = 2
//  count['k'] = 2
//  ……
//
//Step 2: Get the first character who's 
//        count is 1 ('f').
public class FirstNonRepeatingCharacter
{
	static class CountIndex
	{
		int index, count;
		CountIndex(int index)
		{
			this.count=1;
			this.index=index;
		}
		private void incCount()
		{
			this.count++;
		}
	}
	static HashMap<Character,CountIndex> hm=new HashMap<>(256);//for all the alphabets
	static void getCharCount(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(hm.containsKey(str.charAt(i)))
			{
				hm.get(str.charAt(i)).incCount();
			}
			else
				hm.put(str.charAt(i),new CountIndex(i));
		}
	}
	static int firstNonRepeating(String str)
	{
		getCharCount(str);
		int res=Integer.MAX_VALUE;

		for(char ch: hm.keySet())
		{
			if(hm.get(ch).count==1 && res>hm.get(ch).index)
				res=hm.get(ch).index;
		}	
		return res;
	}
	public static void main(String[] args) 
    { 
        String str = "geeksforgeeks"; 
        int index = firstNonRepeating(str); 
  
        System.out.println( 
            index == Integer.MAX_VALUE 
                ? "Either all characters are repeating "
                      + " or string is empty"
                : "First non-repeating character is "
                      + str.charAt(index)); 
    }
}
//algo: Time complexity O(n) space complexity O(1)- hashmap size will always be 256 which is constant space
//Make a count_array which will have two fields namely frequency, first occurence of a character.
//The size of count_array is ‘256’.
//Traverse the given string using a pointer.
//Increase the count of current character and update the occurence.
//Now here’s a catch, the array will contain valid first occurence of the character which has
//frequency has unity otherwise the first occurence keeps updating.
//Now traverse the count_array and find the character which has least value of first occurence and
//frequency value as unity.
//Return the character
//Pseudo Code :
//
//for ( i=0 to str.length())
//count_arr[str[i]].first++;
//count_arr[str[i]].second=i;
//
//int res=INT_MAX;
//for(i=0 to count_arr.size())
//  if(count_arr[str[i]].first==1)
//  res=min(min, count_arr[str[i]].second)
//
//return res