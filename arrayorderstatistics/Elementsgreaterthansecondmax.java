package arrayorderstatistics;

public class Elementsgreaterthansecondmax 
{
	static void findsecondMax(int a[])
	{
		int first=Integer.MIN_VALUE;
		int second=first;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>first)
			{
				second=first;
				first=a[i];
			}
			else if(a[i]>second)
				second=a[i];
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<second)
				System.out.print(a[i]+" ");
		}
		
	}
	public static void main(String[] args)
	{
		int a[]= {2, 8, 7, 1, 5};//7, -2, 3, 4, 9, -1
		findsecondMax(a);
	}
}
