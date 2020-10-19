package arithmeticOperationsString2;

//Remainder with 7 for large numbers
//Given a large number as a string, find the remainder of number when divided by 7.
//
//Examples :
//
//Input : num = 1234
//Output : 2
//
//Input : num = 1232
//Output : 0
//
//Input : num = 12345
//Output : 4
public class Remainderwith7 
{
	static int findMod7(String s,int divisor)
	{
		int remainder=0;
		for(int i=0;i<s.length();i++)
		{
			int dividend=(remainder*10)+(s.charAt(i)-'0');
			remainder=dividend%divisor;
		}
		return remainder;
	}
	public static void main(String args[])
	{
		String s="1231241242141251291292084124021842197445";
		int divisor=7;
		System.out.println("Remainder is: "+findMod7(s,divisor));
	}
}
//algo:
//school division