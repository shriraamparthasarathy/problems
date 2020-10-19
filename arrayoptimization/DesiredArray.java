package arrayoptimization;

public class DesiredArray 
{
	static int findMiniSteps(int a[],int n)
	{
		int steps=0;
		while(true)
		{
			int zerocount=0;
			int i;
			for(i=0;i<n;i++)
			{
				if(a[i]%2==1)
					break;
				if(a[i]==0)
					zerocount++;
			}
			if(zerocount ==n)
				return steps;
			if(i!=n)
			{
				for(;i<n;i++)
				{
					if(a[i]%2==1)
					{
						a[i]--;
						steps++;
					}
				}
			}
			else if(i==n)
			{
				for(i=0;i<n;i++)
					a[i]/=2;
				steps++;
			}
		}
	}
	public static void main(String[] args) 
	{
		int a[]= {16,16,16},n=a.length;
		System.out.println("The minimum number of steps to get the desired array from 0 is: "+findMiniSteps(a,n));

	}

}
