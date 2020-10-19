package queue;
import java.util.Queue;
import java.util.LinkedList;
public class StackUsingQueue 
{
	static Queue<Integer> q1=new LinkedList<>();
	static Queue<Integer> q2=new LinkedList<>();
	static void push(int x)
	{
		q1.add(x);
	}
	static void pop()
	{
		if(q1.isEmpty())
		{
			System.out.println("Empty stack");
			return;
		}
		while(q1.size()>1)
		{
			int x=q1.poll();
			q2.add(x);
		}
		System.out.println(q1.poll());
		Queue<Integer> temp=q1;
		q1=q2;
		q2=temp;
	}
	public static void main(String [] args)
	{
		push(1);
		push(2);
		push(3);
		pop();
		pop();
		pop();
		pop();
		
	}
}
