package queue;
import java.util.Stack;
public class QueueusingStack 
{
	static Stack<Integer> s1=new Stack<>();
	static Stack<Integer> s2=new Stack<>();
	static void enqueue(int x)
	{
		s1.push(x);
	}
	static void dequeue()
	{
		if(s1.isEmpty()&&s2.isEmpty())
		{
			System.out.println("Q is empty");
			return;
		}
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				int d=s1.peek();
				s1.pop();
				s2.push(d);
			}
		}
		System.out.println(s2.peek());
		s2.pop();
		
	}
	public static void main(String[] args)
	{
		enqueue(1);
		enqueue(2);
		enqueue(3);
		dequeue();
		dequeue();
		dequeue();
		dequeue();
	}
}
//time complexity O(n) space O(n)
//enqueue in stack s1
//if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.