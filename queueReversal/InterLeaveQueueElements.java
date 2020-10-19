package queueReversal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class InterLeaveQueueElements
{
	static Queue<Integer> q;
	static void interLeaveQueue()
	{
		if(q.size()%2!=0)
		{
			System.out.println("Not of even length to interleave");
			return;
		}
		Stack<Integer> s=new Stack<>();
		int half=q.size()/2;
		for(int i=0;i<half;i++)
			s.push(q.poll());
		for(int i=0;i<half;i++)
			q.add(s.pop());
		for(int i=0;i<half;i++)
			q.add(q.poll());
		for(int i=0;i<half;i++)
			s.push(q.poll());
		for(int i=0;i<half;i++)
		{
			q.add(s.pop());
			q.add(q.poll());
		}
		
	}
	static void Print()
	{
		for(int n:q)
			System.out.print(n+", ");
		System.out.println();
	}
	public static void main(String args[]) 
    { 
		q = new LinkedList<>(); 
	    q.add(11); 
	    q.add(12); 
	    q.add(13); 
	    q.add(14); 
	    q.add(15); 
	    q.add(16); 
	    q.add(17); 
	    q.add(18); 
	    q.add(19); 
	    q.add(20); 
        Print(); 
	    interLeaveQueue(); 
        Print(); 
    } 
}
//algo
//Following are the steps to solve the problem:
//1.Push the first half elements of queue to stack.
//2.Enqueue back the stack elements.
//3.Dequeue the first half elements of the queue and enqueue them back.
//4.Again push the first half elements into the stack.
//5.Interleave the elements of queue and stack.

