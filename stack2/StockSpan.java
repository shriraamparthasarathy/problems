package stack2;
import java.util.Stack;
public class StockSpan 
{
	static void calculateSpan(int price[],int n,int s[])
	{
		Stack<Integer> st=new Stack<>();
		st.push(0);
		s[0]=1;
		for(int i=1;i<n;i++)
		{
			while(!st.isEmpty()&&price[st.peek()]<=price[i])
				st.pop();
			s[i]=st.isEmpty()?i+1:i-st.peek();
			st.push(i);
		}
	}
	static void printArray(int s[])
	{
		for(int i:s)
			System.out.print(i+" ");
	}
	public static void main(String[] args) 
	{ 
		int price[] = { 10, 4, 5, 90, 120, 80 }; 
	    int n = price.length; 
	    int s[] = new int[n]; 
	    calculateSpan(price, n, s); 
	    printArray(s); 
	} 
}
//algo
//check stack method for https://www.geeksforgeeks.org/the-stock-span-problem/