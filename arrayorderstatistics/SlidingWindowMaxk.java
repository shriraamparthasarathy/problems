package arrayorderstatistics;

//reference
//another method using deque:  https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

//current method using dynamic programming: https://stackoverflow.com/questions/8031939/finding-maximum-for-every-window-of-size-k-in-an-array/17249084#17249084
import java.util.Arrays;
public class SlidingWindowMaxk 
{
	static int max(int a, int b)
	{
		return a>b?a:b;
	}
	static int[] findmaxArray(int a[],int n,int w)
	{
		int k=n-w+1;
		int l[]=new int[n],r[]=new int[n], max_val[]=new int[k];
		for(int i=1;i<n;i++)   // left array with respect to starting of block(i%w=1)
		{
			if(i%w==1)
				l[i]=a[i];
			else
				l[i]=max(a[i],l[i-1]);
		}
		for(int i=n-1;i>0;i--)  //right array with respect to ending of block(i%2=0)
		{
			if(i==n-1)
				r[i]=a[i];
			else if(i%w==0)
				r[i]=a[i];
			else
				r[i]=max(a[i],r[i+1]);
		}
		for(int i=1;i<k;i++)
		{
			max_val[i]=max(r[i],l[i+w-1]);
		}
		return max_val;
		
	}
	public static void main(String args[])
	{
		int a[]= {0,1, 2, 3, 1, 4, 5, 2, 3, 6},n=a.length,w=3;// added one zero in the start since im gonna have the array start from index 1
		int maxvalue[]=findmaxArray(a,n,w);
		System.out.print(Arrays.toString(maxvalue));
	}
}
