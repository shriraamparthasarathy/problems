package queueReversal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReversingQueueusingStack 
{
	static Queue<Integer> queue;
	static void reversequeue()
	{
		Stack<Integer> s=new Stack<>();
		while(!queue.isEmpty())
			s.add(queue.poll());
		while(!s.isEmpty())
			queue.add(s.pop());
	}
	static void Print()
	{
		for(int n:queue)
			System.out.print(n+", ");
		System.out.println();
	}
	public static void main(String args[]) 
    { 
        queue = new LinkedList<Integer>(); 
        queue.add(10); 
        queue.add(20); 
        queue.add(30); 
        queue.add(40); 
        queue.add(50); 
        queue.add(60); 
        queue.add(70); 
        queue.add(80); 
        queue.add(90); 
        queue.add(100); 
        Print(); 
        reversequeue(); 
        Print(); 
    } 
}
