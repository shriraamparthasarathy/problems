package stringOccurrenceBased;
import java.util.Queue;
import java.util.LinkedList;
//Given a stream of characters and we have to find first non repeating character each 
//time a character is inserted to the stream.
//
//Examples:
//
//Input  : a a b c
//Output : a -1 b b
//
//Input  : a a c
//Output : a -1 c
public class NonRepeatingCharactersinStreamusingQueue 
{
	static void firstNonRepeating(String s)
	{
		int count[]=new int[26];
		Queue<Character> q=new LinkedList<Character>();
		for(int i=0;i<s.length();i++)
		{
			q.add(s.charAt(i));
			count[s.charAt(i)-'a']++;
			while(!q.isEmpty())
			{
				if(count[q.peek()-'a']>1)
					q.remove();

				else
				{
					System.out.print(q.peek()+" ");
					break;
				}
			}
			if(q.isEmpty())
				System.out.print(-1+ " ");
		}
	}
	public static void main(String[] args) 
    { 
        String str = "aabc"; 
        firstNonRepeating(str); 
    } 
}
//algo using queue
//Create a count array of size 26(assuming only lower case characters are present) and
//initialize it with zero.
//Create a queue of char datatype.
//Store each character in queue and increase its frequency in the hash array.
//For every character of stream, we check front of the queue.
//If the frequency of character at the front of queue is one, then that will be the first non 
//repeating character.
//Else if frequency is more than 1, then we pop that element.
//If queue became empty that means there are no non repeating character so we will print -1.