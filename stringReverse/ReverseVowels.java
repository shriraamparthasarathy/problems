package stringReverse;
//Given a string, your task is to reverse only the vowels of string.
//
//Examples:
//
//Input : hello
//Output : holle
//
//Input : hello world
//Output : hollo werld
public class ReverseVowels 
{
	static boolean isVowel(char c)
	{
		c=Character.toLowerCase(c);
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
	}
	static String reverseVowel(char[] ch)
	{
		int l=0,r=ch.length-1;
		while(l<r)
		{
			if(!isVowel(ch[l]))
			{
				l++;
				 continue;
			}
			else if(!isVowel(ch[r]))
			{
				r--;
				continue;
			}
			char t=ch[l];
			ch[l]=ch[r];
			ch[r]=t;
			l++;
			r--;
		}
		return new String(ch);
	}
	public static void main(String[] args) 
	{ 
        char ch[] = "hello world".toCharArray(); 
        System.out.println(reverseVowel(ch)); 
    }
}
//algo
//two pointer technique