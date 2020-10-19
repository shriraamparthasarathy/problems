package ArrayRearrangement;

public class MultiplyPreviousNext 
{
	static void changeArray(int a[])
	{
		int prev=a[0],n=a.length;
		a[0]=prev*a[1];
		for(int i=1;i<n-1;i++)
		{
			int curr=a[i];
			a[i]=prev*a[i+1];
			prev=curr;
		}
		a[n-1]=prev*a[n-1];
	}
	public static void main(String[] args)
	{
		int a[]= {2, 3, 4, 5, 6};
		changeArray(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
