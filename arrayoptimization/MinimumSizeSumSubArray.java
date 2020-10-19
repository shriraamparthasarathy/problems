package arrayoptimization;

public class MinimumSizeSumSubArray 
{

	static int findMinlen(int a[],int n,int x)
	{
		int cursum=0,start=0,end=0,minlen=n+1;
		while(end<n)
		{
			while(cursum<=x&&end<n)
				cursum+=a[end++];
			while(cursum>x&&start<n)
			{
				if(minlen>end-start)
					minlen=end-start;
				cursum-=a[start++];	
			}
		}
		return minlen;
	}
	public static void main(String[] args) 
	{
		int a[]= {1, 4, 45, 6, 10, 19},n=a.length,x=51;
		int res=findMinlen(a,n,x);
		if(res==n+1)
			System.out.printf("Not possible");
		else
			System.out.printf("The smallest sub array with max sum:"+ res);
	}

}
