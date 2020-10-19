package arithmeticOperationsString2;
//You are given an n-digit large number, you have to check whether it is divisible by 999 without dividing or finding modulo of number by 999.
//
//Examples:
//
//Input : 235764 
//Output : Yes
//
//Input : 23576 
//Output : No

public class Divisibilityby9
{
	static int isDivis999(String no)
	{
		int gsum=0;
		int n=no.length();
		if(n%3==1)
			no="00"+no;
		else if(n%3==2)
			no='0'+no;
		for(int i=0;i<n;i++)
		{
			int group=0;
			group+=(no.charAt(i++)-'0')*100;
			group+=(no.charAt(i++)-'0')*10;
			group+=no.charAt(i)-'0';
			gsum+=group;
		}
		System.out.println(gsum);
		if(gsum>999)
			gsum=isDivis999(Integer.toString(gsum));
		return gsum;
	}
	public static void main(String args[])
	{
		String s="1998";
		if(isDivis999(s)==999)
			System.out.println("Divisible");
		else
			System.out.println("Not Divisible");
	}
}
//algo
//Input : 235764 
//Output : Yes
//Explanation : Step I - read input : 235, 764
//              Step II - 235 + 764 = 999
//              As result is 999 then we can 
//              conclude that it is divisible by 999.
//
//Input : 1244633121
//Output : Yes
//Explanation : Step I - read input : 1, 244, 633, 121
//              Step II - 001 + 244 + 633 + 121 = 999
//              As result is 999 then we can conclude 
//              that it is divisible by 999.
//
//Input : 999999999
//Output : Yes
//Explanation : Step I - read input : 999, 999, 999
//              Step II - 999 + 999 + 999 = 2997
//              Step III - 997 + 002 = 999
//              As result is 999 then we can conclude  
//              that it is divisible by 999.
//
//How does this work?
//
//Let us consider 235764, we can write it as
//235764 = 2*105 + 3*104 + 5*103 + 
//         7*102 + 6*10 + 4
//
//The idea is based on below observation:
//Remainder of 103 divided by 999 is 1
//For i > 3, 10i % 999 = 10i-3 % 999 
//
//Let us see how we use above fact.
//Remainder of 2*105 + 3*104 + 5*103 + 
//7*102 + 6*10 + 4
//Remainder with 999 can be written as : 
//2*100 + 3*10 + 5*1 + 7*100 + 6*10 + 4 
//The above expression is basically sum of
//groups of size 3.
//
//Since the sum is divisible by 999, answer is yes.