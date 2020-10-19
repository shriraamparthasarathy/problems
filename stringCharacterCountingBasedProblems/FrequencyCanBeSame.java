package stringCharacterCountingBasedProblems;
//Given a string which contains lower alphabetic characters, we need to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string.
//
//Examples:
//
//Input: str = “xyyz”
//Output: Yes
//We can remove character ’y’ from above
//string to make the frequency of each
//character same.
//
//Input: str = “xyyzz”
//Output: Yes
//We can remove character ‘x’ from above
//string to make the frequency of each
//character same.
//
//Input: str = “xxxxyyzz”
//Output: No
//It is not possible to make frequency of
//each character same just by removing at
//most one character from above string.
public class FrequencyCanBeSame 
{
	static boolean isSame(int freq[])
	{
		int i,same=0;
		for(i=0;i<26;i++)
		{
			if(freq[i]>0)
			{
				same=freq[i];
				break;
			}
		}
		for(int j=i+1;j<26;j++)
			if(freq[j]>0&&freq[j]!=same)
				return false;
		return true;
	}
	static boolean possibleSameCharFreqByOneRemoval(String s)
	{
		int count[]=new int[26];
		for(int i=0;i<s.length();i++)
			count[s.charAt(i)-'a']++;
		if(isSame(count))
			return true;
		for(int i=0;i<26;i++)
		{
			if(count[i]>0)
			{
				count[i]--;
				if(isSame(count))
					return true;
				else
					count[i]++;
			}	
		}
		return false;
	}
	public static void main(String args[]) 
    { 
        String str = "xyyzz"; 
        if (possibleSameCharFreqByOneRemoval(str)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
}
