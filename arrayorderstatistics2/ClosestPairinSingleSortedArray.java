package arrayorderstatistics2;

public class ClosestPairinSingleSortedArray 
{
	static void findClosestPair(int a[],int x)
	{
		int res_l=0,res_r=0,l=0,r=a.length-1,diff=Integer.MAX_VALUE;
		while(l<r)
		{
			if(Math.abs(a[l]+a[r]-x)<diff)
			{
				diff=Math.abs(a[l]+a[r]-x);
				res_l=l;
				res_r=r;
			}
			if(a[l]+a[r]>x)
				r--;
			else
				l++;
		}
		System.out.print(a[res_l]+" "+a[res_r]);
	}
	public static void main(String[] args)
	{
		int a[] = {10, 22, 28, 29, 30, 40},x=54;
		System.out.print("The closest pair is: ");
		findClosestPair(a,x);
	}
}
