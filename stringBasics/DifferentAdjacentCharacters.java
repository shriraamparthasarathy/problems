package stringBasics;
//Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are same.
//
//Note : It may be assumed that the string has only lowercase English alphabets.
//
//Examples:
//
//Input: aaabc 
//Output: abaca 
//
//Input: aaabb
//Output: ababa 
//
//Input: aa 
//Output: Not Possible
//
//Input: aaaabc 
//Output: Not Possible
import java.util.PriorityQueue;
public class DifferentAdjacentCharacters 
{
	static class key
	{
		int freq;
		char ch;
		key(char ch,int freq)
		{
			this.freq=freq;
			this.ch=ch;
		}
	}
	static void rearrangeString(String str)
	{
		int n=str.length();
		int count[]=new int[26];
		for(int i=0;i<n;i++)
			count[str.charAt(i)-'a']++;
		
		PriorityQueue<key> pq=new PriorityQueue<>((k1,k2)->
		{
			if(k1.freq<k2.freq)
				return 1;
			else if(k1.freq>k2.freq)
				return -1;
			else
				return 0;
		});
		for(char c='a';c<='z';c++)
		{
			int val=c-'a';
			if(count[val]>0)
				pq.add(new key(c,count[val]));
		}
		
		str="";
		key prev=new key('#',-1);
		while(pq.size()!=0)
		{
			key k=pq.poll();
			str=str+k.ch;
			if(prev.freq>0)
				pq.add(prev);
			k.freq--;
			prev=k;
		}
		if(n!=str.length())
			System.out.println("Illegal string");
		else
			System.out.println(str);
	}
	public static void main(String args[])
	{
		String str="bbbaa";
		rearrangeString(str);
	}
}
//algo
//The idea is to put the highest frequency character first (a greedy approach). 
//We use a priority queue (Or Binary Max Heap) and put all characters and
//ordered by their frequencies (highest frequency character at root). 
//We one by one take the highest frequency character from the heap and add it to result. 
//After we add, we decrease the frequency of the character and we temporarily move this
//character out of priority queue so that it is not picked next time.
//
//We have to follow the step to solve this problem, they are:
//1. Build a Priority_queue or max_heap, pq that stores characters and their frequencies.
//…… Priority_queue or max_heap is built on the bases of the frequency of character.
//2. Create a temporary Key that will be used as the previously visited element
//(the previous element in the resultant string. Initialize it { char = ‘#’ , freq = ‘-1’ }
//3. While pq is not empty.
//….. Pop an element and add it to the result.
//….. Decrease frequency of the popped element by ‘1’
//….. Push the previous element back into the priority_queue if it’s frequency > ‘0’
//….. Make the current element as the previous element for the next iteration.
//4. If the length of the resultant string and original string is not equal, print 
//“not possible”. Else print result.