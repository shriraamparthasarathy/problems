package arrayorderstatistics2;

//explanation https://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
public class LIS 
{
	static int ceilval(int a[],int l,int r,int key)
	{
		while(r-l>1)
		{
			int m=l+(r-l)/2;
			if(a[m]>=key)
				r=m;
			else
				l=m;
		}
		return r;
	}
	static void findLIS(int a[])
	{
		int tail[]=new int[a.length];
		tail[0]=a[0];
		int len=1;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<tail[0])
				tail[0]=a[i]; // if its the lowest, make the smaller element into this
			else if(a[i]>tail[len-1])
				tail[len++]=a[i];// if its the largest, add this to the large element
			else
				tail[ceilval(tail,-1,len-1,a[i])]=a[i]; // else add to the minimum value > a[i]
		}
		System.out.println("The length is "+len );
		for(int i=0;i<len;i++)
			System.out.print(tail[i]+" ");
	}
	public static void main(String[] args) 
	{
		int a[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		findLIS(a);
	}

}
