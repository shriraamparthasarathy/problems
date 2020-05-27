package githubprograms;

public class LargerNumberDivisiblebyFour 
{

	public static void main(String args[])
	{
		String s="1234567589333864";
		int n=s.length()-1;
		boolean flag;
		if(n==1)
		{
			if((s.charAt(n)-'0')%4==0)
				flag=true;
			else
				flag=false;
		}
		else
		{
			int no=(s.charAt(n-1)-'0')*10+(s.charAt(n)-'0');
			if(no%4==0)
				flag=true;
			else
				flag=false;	
		}
		if(flag)
			System.out.println("Divisible");
		else
			System.out.println("Not Divisible");
	}
}
