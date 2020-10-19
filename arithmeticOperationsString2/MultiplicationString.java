package arithmeticOperationsString2;
//Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find product of these two numbers.
//
//Examples:
//
//Input : num1 = 4154  
//        num2 = 51454
//Output : 213739916 
//
//Input :  num1 = 654154154151454545415415454  
//         num2 = 63516561563156316545145146514654 
//Output : 41549622603955309777243716069997997007620439937711509062916
public class MultiplicationString 
{
	static String findMultiply(String s1,String s2)
	{
		int m=s1.length(),n=s2.length();
		int res[]=new int[m+n];
		int carry=0;
		int n1_pos=0,n2_pos=0;
		for(int i=m-1;i>=0;i--)
		{
			n2_pos=0;
			int n1=s1.charAt(i)-'0';
			carry=0;
			for(int j=n-1;j>=0;j--)
			{
				int n2=s2.charAt(j)-'0';
				int sum=n1*n2+ res[n1_pos + n2_pos] + carry;
				res[n1_pos + n2_pos]=sum%10;
				carry=sum/10;
				n2_pos++;
			}
			if(carry>0)
				res[n1_pos + n2_pos]+=carry;
			n1_pos++;
		}
		int i=res.length-1;
		while(i>=0&&res[i]==0)
			i--;
		if(i==-1)
			return "0";
		String r="";
		while(i>=0)
			r+=res[i--];
		return r;
	}
	public static void main(String args[])
	{
		String str1 = "1235421415454545454545454544"; 
	    String str2 = "1714546546546545454544548544544545"; 
	  
	    if ((str1.charAt(0) == '-' || str2.charAt(0) == '-') &&  
	        (str1.charAt(0) != '-' || str2.charAt(0) != '-')) 
	        System.out.print("-"); 
	  
	    if (str1.charAt(0) == '-' &&  
	        str2.charAt(0) != '-')  
	    { 
	        str1 = str1.substring(1); 
	    }  
	    else if (str1.charAt(0) != '-' &&  
	             str2.charAt(0) == '-') 
	    { 
	        str2 = str2.substring(1); 
	    }  
	    else if (str1.charAt(0) == '-' &&  
	             str2.charAt(0) == '-') 
	    { 
	        str1 = str1.substring(1); 
	        str2 = str2.substring(1); 
	    } 
	    System.out.println("AFter multiplication:\n"+findMultiply(str1,str2));
	}
}
