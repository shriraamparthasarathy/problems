package arithmeticOperationsString;
//Given a string containing alphanumeric characters, calculate sum of all numbers present in the string.
//
//Examples:
//
//Input:  1abc23
//Output: 24
//
//Input:  geeks4geeks
//Output: 4
//
//Input:  1abc2x30yz67
//Output: 100
//
//Input:  123abc
//Output: 123
public class SumOfAllNoinAlphanumeric 
{
	static int findSum(String s)
	{
		int sum=0;
		String t="0";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='0'&&s.charAt(i)<='9')
				t+=s.charAt(i);
			else
			{
				sum+=Integer.parseInt(t);
				t="0";
			}
		}
		return sum+Integer.parseInt(t);
	}
	public static void main(String args[])
	{
		String s="12abc20yz68";
		System.out.println("The sum of numbers is: "+findSum(s));
	}
}
