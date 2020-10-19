package stack3;
import java.util.Stack;
public class SortStackwithTempStack 
{
	static Stack<Integer> sortstack(Stack<Integer> input)
	{
		Stack<Integer> tempstack=new Stack<>();
		while(!input.isEmpty())
		{
			int t=input.pop();
			while(!tempstack.isEmpty()&&t<tempstack.peek())
				input.push(tempstack.pop());
			tempstack.push(t);
		}
		return tempstack;
	}
	public static void main(String args[]) 
    { 
        Stack<Integer> input = new Stack<Integer>(); 
        input.add(34); 
        input.add(3); 
        input.add(31); 
        input.add(98); 
        input.add(92); 
        input.add(23); 
      
        // This is the temporary stack 
        Stack<Integer> tmpStack=sortstack(input); 
        System.out.println("Sorted numbers are:"); 
      
        for(int i:tmpStack)
        	System.out.print(i+" ");
    } 
}
