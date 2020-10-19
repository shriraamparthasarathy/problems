package arrayorderstatistics;

public class MaxNonAdjacentElements 
{
	static int findMax(int a[])
	{
		if(a.length==0)
			return 0;
		else if(a.length==1)
			return a[1];
		else if(a.length==2)
			return Math.max(a[0], a[1]);
		int e=0,o=0;
		for(int i=0;i<a.length;i++)
		{
			if(i%2==0)
				e=Math.max(e+a[i], o);
			else
				o=Math.max(o+a[i],e);
		}
		return Math.max(e, o);
	}
	public static void main(String args[])
	{
		int a[]= {6, 7, 1, 3, 8, 2, 4};
		System.out.print("The max value with elements not adjacent is: "+ findMax(a));
	}
}
