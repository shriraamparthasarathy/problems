package arithmeticOperationsString;

//Given a string of lowercase alphabets and a number k,
//the task is to print the minimum value of the string after removal of ‘k’ characters.
//The value of a string is defined as the sum of squares of the count of each distinct character.
//For example consider the string “saideep”, here 
//frequencies of characters are s-1, a-1, i-1, e-2, d-1, p-1 and value of the string 
//is 1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 2^2 = 9.
//
//Expected Time Complexity: O(k*logn)
//
//Examples:
//
//Input :  str = abccc, K = 1
//Output :  6
//We remove c to get the value as 1^2 + 1^2 + 2^2
//
//Input :  str = aaab, K = 2
//Output :  2
import java.util.PriorityQueue;
public class SquareSumofCharacterminusK
{
	static int findSquareSum(String str,int k)
	{
		int count[]=new int[26],n=str.length(),res=0;
		if(k>=n)
			return 0;
		for(int i=0;i<n;i++)
			count[str.charAt(i)-'a']++;
		PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->  //since pq is integer, o1 and o2 will also be integer
		{
			if(o1<o2)
				return 1;
			else if(o1>o2)
				return -1;
			else 
				return 0;
		});
		for(int i=0;i<26;i++)
			if(count[i]!=0)
				pq.add(count[i]);
		while(k>0)
		{
			int t=pq.poll()-1;
			if(t>0)
				pq.add(t);
			k--;
		}
		while(pq.size()!=0)
		{
			int t=pq.poll();
			res+=t*t;
		}
		return res;
	}
	public static void main(String args[])
	{
		String str="abccc";
		int k=1;
		System.out.println("The square sum after removing "+k+" elements is: "+findSquareSum(str,k));
	}
}
//algo: time complexity O(k*logn)
//pushing the elements of array into priorityqueue is logn, k times removing and adding elements
//is O(k*logn) each 
//A Better Solution used to Priority Queue which has to the highest element on top.
//
//Initialize empty priority queue.
//Count frequency of each character and Store into temp array.
//Remove K characters which have highest frequency from queue.
//Finally Count Sum of square of each element and return it.