package arithmeticOperationsString2;
//Given a large number (represented as a string) which has to divide by another number (represented as int data type). The large number can be very large which does not even fit in long long in C++. The task is to find the division of these numbers.
//
//Examples:
//
//Input : number  = 1260257
//        divisor = 37
//Output : 34061
//(See below diagram)
//
//Input : number  = 12313413534672234
//        divisor = 754
//Output : 16330787181262
//
//Input : number  = 1248163264128256512
//        divisor = 125
//Output : 9985306113026052

public class StringDivision
{
	static String divide(String number,int divisor)
	{
		String res="";
		int carry=0;
		for(int i=0;i<number.length();i++)
		{
			int x=carry*10 + (number.charAt(i)-'0');
			res+=(x/divisor);
			carry=x%divisor;
		}
		for(int i=0;i<res.length();i++)
			if(res.charAt(i)!='0')
				return res.substring(i);
		return "Invalid input";
	}
	public static void main(String args[])
	{
		String number="1248163264128256512";
		int divisor=125;
		System.out.println("The quotient value is: "+divide(number,divisor));
	}
}
