package arithmeticOperationsString;

public class LargerNumberDivisibleby11 
{
	static boolean isDivisby11(String s)
	{
		int odd=0,even=0;
		for(int i=0;i<s.length();i++)
		{
			if(i%2==0)
				odd+=(s.charAt(i)-'0');
			else
				even+=(s.charAt(i)-'0');
		}
		return ((odd-even)%11==0);
	}
	public static void main(String args[])
	{
		String s="76945";
		if(isDivisby11(s))
			System.out.println("Divisible");
		else
			System.out.println("Not Divisible");
	}
}
