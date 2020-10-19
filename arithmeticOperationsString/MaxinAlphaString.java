package arithmeticOperationsString;
//Given an alphanumeric string, extract maximum numeric value from that string. Alphabets will only be in lower case.
//One approach to solve the problem is discussed here, other using Regular expressions is given in Set 2
//Examples:
//
//Input : 100klh564abc365bg
//Output : 564
//Maximum numeric value among 100, 564 
//and 365 is 564.
//
//Input : abchsd0sdhs
//Output : 0

public class MaxinAlphaString 
{
	static int findMaxNo(String s)
	{
		int num=0,res=0;
		for(int i=0;i<s.length();i++)
		{
			if(Character.isDigit(s.charAt(i)))
				num=num*10+(s.charAt(i)-'0');
			else
			{	
				res=Math.max(num, res);
				num=0;
			}	
		}
		return Math.max(res,num);
	}
	public static void main(String args[])
	{
		String s="100klh564abc365bg";
		System.out.println("Max number is: "+findMaxNo(s));
	}
}
//algo
//Its solution is simple i.e. Start traversing the string and perform two operations:
//
//If a numeric value is present at the current index then convert it into an integer
//       num = num*10 + (str[i]-'0') 
//Otherwise update maximum value and reset num = 0.