package stringCharacterCountingBasedProblems;
//Given a string s, find the number of pairs of characters that are same. Pairs (s[i], s[j]), (s[j], s[i]), (s[i], s[i]), (s[j], s[j]) should be considered different.
//
//Examples :
//
//Input: air
//Output: 3
//Explanation :
//3 pairs that are equal are (a, a), (i, i) and (r, r)
//
//Input : geeksforgeeks
//Output : 31
public class CountEqualPairs 
{
	static int countPairs(String s)
	{
		int count[]=new int[26],res=0;
		for(int i=0;i<s.length();i++)
			count[s.charAt(i)-'a']++;
		for(int i=0;i<26;i++)
			if(count[i]>0)
				res+=count[i]*count[i];
		return res;
	}
	public static void main (String[] args) 
    { 
        String s = "geeksforgeeks"; 
        System.out.println(countPairs(s)); 
    } 
}
//algo
//For an efficient approach, we need to count the number of equal pairs
//in linear time. Since pairs (x, y) and pairs (y, x) are considered different. 
//We need to use a hash table to store the count of all occurrences of a character.
//So we know if a character occurs twice, then it will have 4 pairs – 
//(i, i), (j, j), (i, j), (j, i). So using a hash function, store the occurrence of each
//character, then for each character the number of pairs will be occurrence^2. 
//Hash table will be 256 in length as we have 256 characters.