package stack3;
import java.util.Stack;
public class SortStackRecursion 
{
	static void sortedInsert(int x,Stack<Integer> s)
	{
		if(s.isEmpty()||x>s.peek())
		{
			s.push(x);
			return;
		}
		int temp=s.pop();
		sortedInsert(x,s);
		s.push(temp);
	}
	static void sortStack(Stack<Integer> s)
	{
		if(!s.isEmpty())
		{
			int x=s.pop();
			sortStack(s);
			sortedInsert(x,s);
		}
	}
	static void printStack(Stack<Integer> s)
	{
		for(int i:s)
			System.out.print(i+" ");
	}
	public static void main(String[] args)  
    { 
        Stack<Integer> s = new Stack<>(); 
        s.push(30); 
        s.push(-5); 
        s.push(18); 
        s.push(14); 
        s.push(-3); 
       
        System.out.println("Stack elements before sorting: "); 
        printStack(s); 
       
        sortStack(s); 
       
        System.out.println(" \n\nStack elements after sorting:"); 
        printStack(s); 
       
    } 
}
