package stack2;
import java.util.Stack;
//Given an array, for each element find the value of nearest element to the right which is having
//frequency greater than as that of current element. If there does not exist an answer for a
//position, then make the value ‘-1’.
//
//Examples:
//
//Input : a[] = [1, 1, 2, 3, 4, 2, 1] 
//Output : [-1, -1, 1, 2, 2, 1, -1]
//Explanation:
//Given array a[] = [1, 1, 2, 3, 4, 2, 1] 
//Frequency of each element is: 3, 3, 2, 1, 1, 2, 3
//Lets calls Next Greater Frequency element as NGF
//1. For element a[0] = 1 which has a frequency = 3,
//   As it has frequency of 3 and no other next element 
//   has frequency more than 3 so  '-1'
//2. For element a[1] = 1 it will be -1 same logic 
//   like a[0]
//3. For element a[2] = 2 which has frequency = 2,
//   NGF element is 1 at position = 6  with frequency 
//   of 3 > 2
//4. For element a[3] = 3 which has frequency = 1,
//   NGF element is 2 at position = 5 with frequency 
//   of 2 > 1
//5. For element a[4] = 4 which has frequency = 1,
//   NGF element is 2 at position = 5 with frequency 
//   of 2 > 1
//6. For element a[5] = 2 which has frequency = 2,
//   NGF element is 1 at position = 6 with frequency
//   of 3 > 2
//7. For element a[6] = 1 there is no element to its 
//   right, hence -1 

public class NextGreatestFrequencyElement 
{
	static void NFG(int [] a,int n, int freq[])
	{
		Stack<Integer> s=new Stack<>();
		int res[]=new int[n];
		s.push(0);
		for(int i=1;i<n;i++)
		{
			if(freq[a[s.peek()]]>freq[a[i]])
				s.push(i);
			else
			{
				while(freq[a[s.peek()]]<freq[a[i]]&&!s.isEmpty())
				{
					res[s.peek()]=a[i];
					s.pop();
				}
				s.push(i);
			}		
		}
		while(!s.isEmpty())
		{
			res[s.peek()]=-1;
			s.pop();
		}
		for(int i:res)
			System.out.print(i+" ");
	}
	public static void main(String args[]) 
	{ 
	  
	    int a[] = {1, 1, 2, 3, 4, 2, 1}; 
	    int len = 7; 
	    int max = Integer.MIN_VALUE; 
	    for (int i = 0; i < len; i++) 
	    { 
	        //Getting the max element of the array 
	        if (a[i] > max)  
	        { 
	            max = a[i]; 
	        } 
	    } 
	    int freq[] = new int[max + 1]; 
	      
	    for (int i = 0; i < max + 1; i++) 
	    freq[i] = 0; 
	      
	    //Calculating frequency of each element 
	    for (int i = 0; i < len; i++)  
	    { 
	        freq[a[i]]++; 
	    } 
	  
	    NFG(a, len, freq); 
	} 
}
//algo
//We can use hashing and stack data structure to efficiently solve for many cases. A simple
//hashing technique is to use values as index and frequency of each element as value. We use
//stack data structure to store position of elements in the array.
//
//1) Create a list to use values as index to store frequency of each element.
//2) Push the position of first element to stack.
//3) Pick rest of the position of elements one by one and follow following steps in loop.
//…….a) Mark the position of current element as ‘i’ .
//……. b) If the frequency of the element which is pointed by the top of stack is greater than
//frequency of the current element, push the current position i to the stack
//……. c) If the frequency of the element which is pointed by the top of stack is less than
//frequency of the current element and the stack is not empty then follow these steps:
//…….i) continue popping the stack
//…….ii) if the condition in step c fails then push the current position i to the stack
//4) After the loop in step 3 is over, pop all the elements from stack and print -1 as next
//greater frequency element for them does not exist.