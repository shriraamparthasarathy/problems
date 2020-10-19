package arrayorderstatistics2;

public class ClosesttPairinTwoSortedArrays 
{
	static void findClosePair(int a1[],int a2[],int x)
	{
		int diff=Integer.MAX_VALUE,l=0,r=a2.length-1,res_l=0,res_r=0;
		while(l<a1.length&&r>=0)
		{
			if(Math.abs(a1[l]+a2[r]-x)<diff)
			{
				diff=Math.abs(a1[l]+a2[r]-x);
				res_l=l;
				res_r=r;
			}
			if(a1[l]+a2[r]>x)
				r--;
			else
				l++;
		}
		System.out.print(a1[res_l]+" "+a2[res_r]);
	}
	public static void main(String args[])
	{
		int a1[]= {1, 4, 5, 7},a2[]= {10, 20, 30, 40},x=38;
		System.out.print("The closest pairs are: ");
		findClosePair(a1,a2,x);
	}
}
