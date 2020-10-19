package arrayoptimization;

public class LargestContiguousSubarray 
{

	static int findLCASum(int a[])
	{
		int res=a[0],cur=a[0];
		for(int i=1;i<a.length;i++)
		{
			cur=Math.max(a[i],a[i]+cur);
			res=Math.max(res, cur);
		}
		return res;
	}
	public static void main(String[] args)
	{
		int a[]= {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.print("The maximum sum is: "+findLCASum(a));

	}

}
