package stack;

public class TwoStacks 
{
	int arr[];
	int t1;
	int t2;
	int size;
	
	public TwoStacks(int n)
	{
		this.size=n;
		arr=new int[size];
		t1=-1;
		t2=size;
	}
	void push1(int d)
	{
		if(t1>=t2-1)
		{
			System.out.println("Stack overflow");
			return;
		}
		t1++;
		arr[t1]=d;
	}
	void push2(int d)
	{
		if(t1>=t2-1)
		{
			System.out.println("Stack overflow");
			return;
		}
		t2--;
		arr[t2]=d;
	}
	int pop1()
	{
		if(t1>=0)
		{
			int x=arr[t1];
			t1--;
			return x;
		}
		else
			System.out.println("Stack UnderFlow");
		return -1;
	}
	int pop2()
	{
		if(t2<size)
		{
			int x=arr[t2];
			t2++;
			return x;
		}
		else
			System.out.println("Stack UnderFlow");
		return -1;
	}
	public static void main(String args[]) 
    { 
        TwoStacks ts = new TwoStacks(5); 
        ts.push1(5); 
        ts.push2(10); 
        ts.push2(15); 
        ts.push1(11); 
        ts.push2(7); 
        System.out.println("Popped element from"
                           + " stack1 is " + ts.pop1()); 
        ts.push2(40); 
        System.out.println("Popped element from"
                           + " stack2 is " + ts.pop2()); 
    } 
}
//his method efficiently utilizes the available space. It doesn’t cause an 
//overflow if there is space available in arr[]. The idea is to start two stacks from two 
//extreme corners of arr[]. stack1 starts from the leftmost element, the first element in stack1
//is pushed at index 0. The stack2 starts from the rightmost corner, the first element in stack2 
//is pushed at index (n-1). Both stacks grow (or shrink) in opposite direction. To check for
//overflow, all we need to check is for space between top elements of both stacks. 