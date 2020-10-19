package queue;
import java.util.Queue;
import java.util.LinkedList;
public class StackUsingSingleQueue 
{
	static Queue<Integer> q=new LinkedList<>();
	static void push(int x)
	{
		int size=q.size();
		q.add(x);
		for(int i=0;i<size;i++)
		{
			int d=q.poll();
			q.add(d);
		}
	}
	static void pop()
	{
		if(q.isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		System.out.println(q.poll());
	}
	static int top()
	{
		return q.peek();
	}
	public static void main(String[] args)  
    { 
        push(10); 
        push(20); 
        System.out.println("Top element :" + top()); 
        pop(); 
        push(30); 
        pop(); 
        System.out.println("Top element :" + top()); 
        pop();
        pop();
    } 
}
////x is the element to be pushed and s is stack
//push(s, x) 
//1) Let size of q be s. 
//1) Enqueue x to q
//2) One by one Dequeue s items from queue and enqueue them.
//
////Removes an item from stack
//pop(s)
//1) Dequeue an item from q