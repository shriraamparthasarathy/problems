package arrayorderstatistics;

public class MinMaxElements 
{
	static class pair
	{
		int min;
		int max;
		public pair()
		{
			this.min=0;
			this.max=0;
		}
		public pair(int min,int max)
		{
			this.min=min;
			this.max=max;
		}
	}
	static pair findMinMax(int a[])
	{
		pair t=new pair();
		int n=a.length,i=0;
		if(n%2==0)
		{
			t.min=a[0];
			t.max=a[1];
			i=2;
		}
		else
		{
			t.min=a[0];
			t.max=a[0];
			i=1;
		}
		for(;i<n-1;)
		{
			if(a[i]>a[i+1])
			{
				if(a[i]>t.max)
					t.max=a[i];
				if(a[i+1]<t.min)
					t.min=a[i+1];
			}
			else if(a[i]<a[i+1])
			{
				if(a[i+1]>t.max)
					t.max=a[i+1];
				if(a[i]<t.min)
					t.min=a[i];
			}
			i+=2;
		}
		return t;
	}
	public static void main(String[] args)
	{
		int a[]= {1000, 11, 445, 1, 330, 3000};
		pair p=findMinMax(a);
		System.out.print("The minimum element is: "+p.min+"\nThe maximum element is: "+p.max);
		
	}
}
