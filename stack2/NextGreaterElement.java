package stack2;
import java.util.Stack;
//Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element
//for an element x is the first greater element on the right side of x in array. Elements for which
//no greater element exist, consider next greater element as -1.
//
//Examples:
//
//For any array, rightmost element always has next greater element as -1.
//For an array which is sorted in decreasing order, all elements have next greater element as -1.
//For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
//Element       NGE
//   4      -->   5
//   5      -->   25
//   2      -->   25
//   25     -->   -1
//d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
//
//  Element        NGE
//   13      -->    -1
//   7       -->     12
//   6       -->     12
//   12      -->     -1
public class NextGreaterElement 
{
	static void printNGE(int arr[],int n)
	{
		Stack<Integer> s=new Stack<>();
		int element=0,next=0;
		for(int i=0;i<n;i++)
		{
			next=arr[i];
			if(!s.isEmpty())
			{
				element=s.pop();
				while(element<next)
				{
					System.out.println(element+" --> "+next);
					if(s.isEmpty())
						break;
					element=s.pop();
				}
				if(element>next)
					s.push(element);
			}
			s.push(next);
		}
		next=-1;
		while(!s.isEmpty())
		{
			element=s.pop();
			System.out.println(element+" --> "+next);
		}
	}
	public static void main(String[] args)  
    { 
        int arr[] = { 11, 13, 21, 3 }; 
        int n = arr.length; 
        printNGE(arr, n); 
    } 
}
//algo
//Push the first element to stack.
//Pick rest of the elements one by one and follow the following steps in loop.
//Mark the current element as next.
//If stack is not empty, compare top element of stack with next.
//If next is greater than the top element,Pop element from stack. next is the next greater 
//element for the popped element.
//Keep popping from the stack while the popped element is smaller than next. next becomes the next 
//greater element for all such popped elements
//Finally, push the next in the stack.
//After the loop in step 2 is over, pop all the elements from stack and print -1 as next element 
//for them.