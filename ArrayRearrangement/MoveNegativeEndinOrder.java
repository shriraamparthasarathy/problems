package ArrayRearrangement;

public class MoveNegativeEndinOrder 
{
	static void moveOrder(int a[])
	{
		int j=0,t[]=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>=0)
				t[j++]=a[i];
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<0)
				t[j++]=a[i];
		}
		for(int i=0;i<t.length;i++)
			System.out.print(t[i]+" ");
	}
	public static void main(String[] args)
	{
		int a[]= {1, -1, -3, -2, 7, 5, 11, 6};//-5, 7, -3, -4, 9, 10, -1, 11
		moveOrder(a);
	}
}
