package ArrayRearrangement;

public class DoubletheFirstElementpush0toend 
{
	static void pushArray(int a[])
	{
		int count=0;
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]!=0&&a[i+1]==a[i])
			{
				a[i]*=2;
				a[i+1]=0;
			}
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=0)
			 a[count++]=a[i];
		}
		while(count<a.length)
			a[count++]=0;
	}
	public static void main(String args[])
	{
		int a[]= {2, 2, 0, 4, 0, 8};//0, 2, 2, 2, 0, 6, 6, 0, 0, 8
		pushArray(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
