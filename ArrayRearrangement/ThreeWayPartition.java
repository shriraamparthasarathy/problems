package ArrayRearrangement;

public class ThreeWayPartition
{
	static void threewaypartition(int a[],int high,int low)
	{
		int start=0,end=a.length-1,t;
		for(int i=0;i<=end;)
		{
			if(a[i]<high)
			{
				t=a[start];
				a[start]=a[i];
				a[i]=t;
				start++;
				i++;
			}
			else if(a[i]>low)
			{
				t=a[end];
				a[end]=a[i];
				a[i]=t;
				end--;
			}
			else
				i++;
		}
	}
	public static void main(String[] args)
	{
		int a[]= {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
		threewaypartition(a,10,20);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
