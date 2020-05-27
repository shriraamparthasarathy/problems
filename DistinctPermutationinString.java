package githubprograms;

public class DistinctPermutationinString 
{
	static boolean checkrepeat(String s,int start,int current)
	{
		char a[]=s.toCharArray();
		for(int i= start;i<current;i++)
		{
			if(a[i]==a[current])
				return false;
		}
		return true;
	}
	static String swap(String s,int i,int j)
	{
		char a[]=s.toCharArray();
		char temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		return String.copyValueOf(a);
	}
	static int count=0;
	static void permute(String s,int l,int r)
	{
		if(l==r)
		{
			System.out.println(s+" ");
			count++;
		}	
		else
		{
			for(int i=l;i<=r;i++)
			{
				if (checkrepeat(s,l,i))
				{
					s=swap(s,l,i);
					permute(s,l+1,r);
				}	
			}
		}
	}
	
	public static void main(String[] args)
	{
		String s=new String("001");
		int n=s.length();
		permute(s,0,n-1);
		System.out.print(count);
	}

}

