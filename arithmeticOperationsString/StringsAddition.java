package arithmeticOperationsString;
//Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.
//
//Examples:
//
//Input  : str1 = "3333311111111111", 
//         str2 =   "44422222221111"
//Output : 3377733333332222
//
//Input  : str1 = "7777555511111111", 
//         str2 =    "3332222221111"
//Output : 7780887733332222
public class StringsAddition 
{
	static String addString(String s1,String s2)
	{
		int n1=s1.length(),n2=s2.length();
		int carry=0,sum=0;
		String res="";
		if(n1>n2)
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
			sum=(s1.charAt(i)-'0') + (s2.charAt(i+diff)-'0')+carry;
			res=(char)(sum%10+'0')+res;
			carry=sum/10;
		}
		for(int i=diff-1;i>=0;i--)
		{
			sum=(s2.charAt(i)-'0')+carry;
			res=(char)(sum%10+'0')+res;
			carry=sum/10;
		}
		if(carry!=0)
			res=(char)(carry+'0') +res;
		return res;
	}
	public static void main(String args[])
	{
		String str1 = "3333311111111111";  
	    String str2 = "44422222221111"; 
	    System.out.println("The sum is: "+addString(str1,str2));
	}
}

//algo: O(n1 + n2) where n1 and n2 are lengths 
//The idea is based on school mathematics. 
//We traverse both strings from end, one by one add digits and keep track of carry.
//To simplify the process, we do following:
// 
//Keep adding digits one by one from n-1’th index to start  of smaller string
//, append the sum % 10 to end of result and keep track of carry as sum/10.