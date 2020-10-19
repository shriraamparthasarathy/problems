package ArrayRearrangement;

public class MinimumSwapsReqdElementsClose 
{
	public static int miniSwap(int a[],int k)
	{
		int count=0,bad=0,n=a.length;
		for(int i=0;i<n;i++)
		{
			if(a[i]<=k)
				count++;
		}
		for(int i=0;i<count;i++)
		{
			if(a[i]>count)
				bad++;
			
		}
		int res=bad;
		for(int i=0,j=count;i<n&&j<n;i++,j++)
		{
			if(a[i]>k)
				bad--;
			if(a[j]>k)
				bad++;
			res=bad<res?bad:res;
		}
		return res;
	}
	public static void main(String[] args)
	{
		int arr[]= {2,1,5,6,3},k=3;//{2, 7, 9, 5, 8, 7, 4},k=5
		System.out.println("The number of swaps is : "+ miniSwap(arr,k));
	}
}
