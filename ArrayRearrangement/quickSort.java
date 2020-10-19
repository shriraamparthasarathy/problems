package ArrayRearrangement;

public class quickSort 
{
	static int partition(int a[],int low,int high)
	{
		int i=low-1,piv=a[high],t;
		for(int j=low;j<high;j++)
		{
			if(a[j]<piv)
			{
				i++;
				t=a[j];
				a[j]=a[i];
				a[i]=t;
			}
		}
		i++;
		//putting the pivot element in its place
		t=a[i];
		a[i]=a[high];
		a[high]=t;
		return i;
	}
	
	static void sorting(int a[],int low,int high)
	{
		if(low<high)
		{
			int pi=partition(a,low,high);
			sorting(a,low,pi-1);
			sorting(a,pi+1,high);
		}
	}
	public static void main(String[] args)
	{
		int a[]= {10, 7, 8, 9, 1, 5,6};
		sorting(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
