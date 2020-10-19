package queue3;
import java.util.LinkedList;
import java.util.Queue;
//Given a number n, write a function that generates and prints all binary numbers with decimal
//values from 1 to n.
//Examples:
//
//Input: n = 2
//Output: 1, 10
//
//Input: n = 5
//Output: 1, 10, 11, 100, 101
public class GenerateBinaryNumbers 
{
	static void generatePrintBinary(int n)
	{
		Queue<String> q=new LinkedList<>();
		q.add("1");
		for(int count=n;count>0;count--)
		{
			String s=q.poll();
			System.out.println(s);
			q.add(s+'0');
			q.add(s+'1');
		}
	}
	public static void main(String[] args)  
    { 
        int n=10; 
        generatePrintBinary(n); 
    } 
}
//algo time complexity O(n * logn)
//1) Create an empty queue of strings
//2) Enqueue the first binary number “1” to queue.
//3) Now run a loop for generating and printing n binary numbers.
//……a) Dequeue and Print the front of queue.
//……b) Append “0” at the end of front item and enqueue it.
//……c) Append “1” at the end of front item and enqueue it.