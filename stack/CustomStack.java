package stack;
public class CustomStack 
{
	static int MAX_SIZE=1000;
	static class Pair
	{
		int ele,mini;
		Pair(int x,int y)
		{
			ele=x;
			mini=y;
		}
	}
	static class stack
	{
		int top;
		Pair p[];
		int min;
		stack()
		{
			p=new Pair[MAX_SIZE];
			min=99999;
			top=-1;
		}
		int AddElement(int d)
		{
			if(top>MAX_SIZE)
			{
				System.out.println("Stack overflow");
				return -1;
			}
			if(min>d)
				min=d;
			top++;
			p[top]=new Pair(d,min);
			return 1;
		}
		int GetMin()
		{
			if(top<0)
			{
				System.out.println("Stack is empty");
				return -1;
			}
			return p[top].mini;
		}
		int GetLastElement()
		{
			if(top<0)
			{
				System.out.println("Stack is empty");
				return -1;
			}
			return p[top].ele;
		}
		int RemoveLastElement()
		{
			if(top<0)
			{
				System.out.println("Stack is empty");
				return -1;
			}
			if(top>0)
				min=p[top-1].mini;
			else if(top==0)
				min=9999;
			top--;
			return 1;
		}
	}
	
	public static void main(String args[])
	{
		{ 
		    stack s=new stack();; 
		    int success = s.AddElement(5); 
		    if (success == 1) 
		        System.out.println( "5 inserted successfully\n"); 
		  
		    success = s.AddElement(7); 
		    if (success == 1) 
		        System.out.println( "7 inserted successfully\n"); 
		  
		    success = s.AddElement(3); 
		    if (success == 1) 
		        System.out.println( "3 inserted successfully\n"); 
		    int min1 = s.GetMin(); 
		    System.out.println( "min element  :: " +min1); 
		  
		    success = s.RemoveLastElement(); 
		    if (success == 1) 
		        System.out.println( "removed successfully\n"); 
		  
		    success = s.AddElement(2); 
		    if (success == 1) 
		        System.out.println( "2 inserted successfully\n"); 
		  
		    success = s.AddElement(9); 
		    if (success == 1) 
		        System.out.println( "9 inserted successfully\n"); 
		    int last = s.GetLastElement(); 
		    System.out.println( "Last element :: " + last); 
		  
		    success = s.AddElement(0); 
		    if (success == 1) 
		        System.out.println( "0 inserted successfully\n"); 
		    min1 = s.GetMin(); 
		    System.out.println( "min element  :: "+min1); 
		  
		    success = s.RemoveLastElement(); 
		    if (success == 1) 
		        System.out.println( "removed successfully\n"); 
		  
		    success = s.AddElement(11); 
		    if (success == 1) 
		        System.out.println( "11 inserted successfully\n"); 
		    min1 = s.GetMin(); 
		    System.out.println( "min element  :: "+ min1); 
		} 
	}
}
