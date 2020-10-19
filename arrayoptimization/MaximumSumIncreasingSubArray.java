package arrayoptimization;
//this is maximum sub increasing sub sequence, not subarray
public class MaximumSumIncreasingSubArray 
{

	static int findMax(int a[])
	{
		int maxarr[]=new int[a.length];
		int max=0;
		for(int i=0;i<a.length;i++)
			maxarr[i]=a[i];
		for(int i=1;i<a.length;i++)
			for(int j=0;j<i;j++)
				if(a[i]>a[j]&&maxarr[i]<a[i]+maxarr[j])
					maxarr[i]=a[i]+maxarr[j];
		for(int i=0;i<a.length;i++)
			if(max<maxarr[i])
				max=maxarr[i];
		return max;
	}
	public static void main(String[] args) 
	{
		int a[]={1, 101, 2, 3, 100, 4, 5};
		System.out.print("The maximum sub is: "+findMax(a));

	}

}
