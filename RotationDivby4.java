package githubprograms;

public class RotationDivby4 
{
	public static int countPair(String s)
	{
		int n=s.length(),number=0,count=0;
		if(n==1)
		{
			number=s.charAt(0)-'0';
			if(number%4==0)
				return 1;
			else
				return 0;
		}
		for(int i=0;i<n-1;i++)
		{
			number= (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
			if(number%4==0)
				count++;
		}
		number=(s.charAt(n-1)-'0')*10 + (s.charAt(0)-'0');
		if(number%4==0)
			count++;
		return count;
	}
	public static void main(String[] args)
	{
		String s="43292816";
		System.out.println("The count is: "+ countPair(s));
		
	}
}
