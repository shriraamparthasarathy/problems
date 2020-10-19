package arithmeticOperationsString2;
//The problem is to check whether the decimal representation of the given binary number is divisible by 5 or not. Take care, the number could be very large and may not fit even in long long int. The approach should be such that there are zero or minimum number of multiplication and division operations. No leading 0’s are there in the input.
//
//Examples:
//
//Input : 1010
//Output : YES
//(1010)2 = (10)10,
//and 10 is divisible by 5.
//
//Input : 10000101001
//Output : YES
public class BinaryDivisibleby5 
{
	static int equivalentBase4(String t)
	{
		if(t.equals("00"))				//you can use t.compareTo("00") as well
			return 0;
		if(t.equals("01"))
			return 1;
		if(t.equals("10"))
			return 2;
		else
			return 3;
	}
	static boolean isDivisby5(String s)
	{
		int n =s.length(),odd=0,even=0;
		if(n%2!=0)
			s='0'+s;
		int oddpos=1;		//initial position is odd
		for(int i=0;i<n;i+=2)
		{
			String t=s.charAt(i)+""+s.charAt(i+1);
			if(oddpos!=0)
				odd+=equivalentBase4(t);
			else
				even+=equivalentBase4(t);
			oddpos^=1;						//changing between odd position and even position
		}
		return (odd-even)%5==0;
	}
	public static void main(String args[])
	{
		String s="10000101001";
		if(isDivisby5(s))
			System.out.println("Divisible");
		else
			System.out.println("Not divisible");
	}
}
//algo:
//Convert the binary number to base 4.
//Numbers in base 4 contains only 0, 1, 2, 3 as their digits.
//5 in base 4 is equivalent to 11.
//Now apply the rule of divisibility by 11 where you add all the digits at odd places and
//add all the digits at even places and then subtract one from the other.
//If the result is divisible by 11(which remember is 5), then the binary number is divisible by 5.
//	
//How to convert binary number to base 4 representation?
//Check whether the length of binary string is even or odd.
//If odd, the add ‘0’ in the beginning of the string.
//Now, traverse the string from left to right.
//extract substrings of size 2 and add their equivalent decimal to the resultant string.