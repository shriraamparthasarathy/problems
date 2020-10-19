package queue3;
import java.util.LinkedList;
import java.util.Deque;
//Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
//Examples :
//
//Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
//Output: 3 3 4 5 5 5 6
//Explanation: 
//Maximum of 1, 2, 3 is 3
//Maximum of 2, 3, 1 is 3
//Maximum of 3, 1, 4 is 4
//Maximum of 1, 4, 5 is 5
//Maximum of 4, 5, 2 is 5 
//Maximum of 5, 2, 3 is 5
//Maximum of 2, 3, 6 is 6
public class SlidingWindowMax 
{
	static void printMax(int arr[],int n,int k)
	{
		Deque<Integer> q =new LinkedList<>();
		int i=0;
		for(i=0;i<k;i++)
		{
			while((!q.isEmpty())&&arr[q.peekLast()]<=arr[i])
				q.pollLast();
			q.addLast(i);
		}
		for(;i<n;i++)
		{
			System.out.print(arr[q.peek()]+" ");
			while((!q.isEmpty())&&q.peek()<=i-k)
				q.pollFirst();
			while((!q.isEmpty())&&arr[q.peekLast()]<=arr[i])
				q.pollLast();
			q.addLast(i);
		}
		System.out.print(arr[q.peek()]+" ");
	}
	public static void main(String[] args) 
    { 
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 }; 
        int k = 3; 
        printMax(arr, arr.length, k); 
    } 
}
//algo
//Create a deque to store k elements.
//Run a loop and insert first k elements in the deque. While inserting the element if 
//the element at the back of the queue is smaller than the current element remove all those
//elements and then insert the element.
//Now, run a loop from k to end of the array.
//Print the front element of the array
//Remove the element from the front of the queue if they are out of the current window.
//Insert the next element in the deque. While inserting the element if the element at the
//back of the queue is smaller than the current element remove all those elements and then insert 
//the element.
//Print the maximum element of the last window.