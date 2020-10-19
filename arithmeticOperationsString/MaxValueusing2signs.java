package arithmeticOperationsString;
//Given a string of numbers, the task is to find the maximum value from the string, you can add a ‘+’ or ‘*’ sign between any two numbers.
//
//Examples:
//
//Input : 01231
//Output : 
//((((0 + 1) + 2) * 3) + 1) = 10
//In above manner, we get the maximum value i.e. 10
//
//Input : 891
//Output :73
//As 8*9*1 = 72 and 8*9+1 = 73.So, 73 is maximum.
public class MaxValueusing2signs 
{
	static int findMax(String s)
	{
		int res=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='0'||s.charAt(i)=='1'||res<2)
				res+=(s.charAt(i)-'0');
			else
				res*=(s.charAt(i)-'0');
		}
		return res;
	}
	public static void main(String args[])
	{
		String s="01891";
		System.out.println("Max value using * and + is: "+findMax(s));
	}
}
//algo
//The task is pretty simple as we can get the maximum value on multiplying all values
//but the point is to handle the case of 0 and 1 i.e. On multiplying with 0 and 1 we get
//the lower value as compared to on adding with 0 and 1.
//So, use ‘*’ sign between any two numbers(except numbers containing 0 and 1) and
//use ‘+’ if any of the number is 0 and 1.