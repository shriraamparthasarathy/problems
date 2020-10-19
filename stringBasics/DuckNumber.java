package stringBasics;
//Input : 707069
//Output : It is a duck number.
//Explanation: 707069 does not contains zeros at the beginning.
//
//Input : 02364
//Output : It is not a duck number.
//Explanation: in 02364 there is a zero at the beginning of the number.
public class DuckNumber 
{
	static boolean isDuckno(String num)
	{
		int i=0,n=num.length();
		while(i<n&&num.charAt(i)=='0')
			i++;
		while(i<n)
		{
			if(num.charAt(i)=='0')
				return true;
			i++;
		}
		return false;
	}
	public static void main(String args[])
	{
		String num="1023";
		if(isDuckno(num))
			System.out.println("Duck number");
		else
			System.out.println("Not a duck number");
	}
}
