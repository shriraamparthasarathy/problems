package queue3;
import java.util.LinkedList;
import java.util.Queue;
//We are given an integer N. We need to write a program to find the least positive integer X made 
//up of only digits 9’s and 0’s, such that, X is a multiple of N.
//
//Note: It is assumed that the value of X will not exceed 106.
//
//Examples:
//
//Input : N = 5
//Output : X = 90
//Exaplanation: 90 is the smallest number made up 
//of 9's and 0's which is divisible by 5.
//
//Input : N = 7
//Output : X = 9009
//Exaplanation: 9009 is smallest number made up 
//of 9's and 0's which is divisible by 7.
public class SmallestMultipleofDigits0and9 
{
	static int MAX_COUNT=100000;
	static LinkedList<String> vec=new LinkedList<>();
	static void generateNumbersUtil()
	{
		Queue<String> q=new LinkedList<>();
		q.add("9");
		for(int count=MAX_COUNT;count>0;count--)
		{
			String s=q.poll();
			vec.add(s);
			q.add(s+'0');
			q.add(s+'9');
		}
	}
	static String findSmallestMultiple(int n)
	{
		for(int i=0;i<vec.size();i++)
			if(Integer.parseInt(vec.get(i))%n==0)
				return vec.get(i);
		return "";
	}
	public static void main(String[] args)  
    { 
        generateNumbersUtil(); 
        int n = 7; 
        System.out.println(findSmallestMultiple(n)); 
    } 
}
//algo
//The idea to solve this problem is to generate and store all of the numbers which can
//be formed using digits 0 & 9. Then find the smallest number among these generated number
//which is divisible by N.
//
//We will use the method of generating binary numbers to generate all numbers which can be
//formed by using digits 0 & 9.