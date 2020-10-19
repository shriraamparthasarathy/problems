package arithmeticOperationsString;
//Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find difference of these two numbers.
//
//Examples:
//
//Input : str1 = "11443333311111111100", 
//        str2 =     "1144422222221111"
//Output : 11442188888888889989
//
//Input :str1 = "122387876566565674",
//       str2 =     "31435454654554"
//Output : 122356441111911120

public class StringSubtraction 
{
	static String subtractString(String s1,String s2)
	{
		int n1=s1.length(),n2=s2.length();
		int carry=0,sub=0;
		String res="";
		if(n1>n2)//making s2 to be the larger number
		{
			String t=s1;
			s1=s2;
			s2=t;
			n1=s1.length();
			n2=s2.length();
		}
		int diff=n2-n1;
		for(int i=n1-1;i>=0;i--)
		{
			sub=(s2.charAt(i+diff)-'0') - (s1.charAt(i)-'0')-carry;
			if(sub<0)
			{
				sub+=10;
				carry=1;
			}
			else
				carry=0;
			res=(char)(sub+'0')+res;
		}
		//subtract remaining digits of larger number 
		for(int i=diff-1;i>=0;i--)
		{
			sub=(s2.charAt(i)-'0')-carry;
			if(sub<0)
			{
				sub=9;
				carry=1;
			}
			else 
				carry=0;
			if(i==0&&sub==0)
				continue;
			res=(char)(sub+'0')+res;
		}
		return res;
	}
	
	public static void main(String args[])
	{
		String str1 = "88";  
	    String str2 = "1079"; 
	    System.out.println("The sum is: "+subtractString(str1,str2));
	}
}
//algo
//This is simple based on school mathematics. 
//We traverse both strings from end, one by one subtract digits.
//
//Keep subtracting digits one by one from n-1th index 
//to start of smaller string, append the diff if it’s positive to end of result.
//If difference(diff) is negative then add 10 and keep track of carry as 1 
//if it’s positive then carry is 0.