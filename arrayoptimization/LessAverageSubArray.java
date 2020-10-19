package arrayoptimization;

public class LessAverageSubArray 
{
	static void findLeastAverage(int a[], int k)
	{
		int resind=0,curr=0;
		for(int i=0;i<k;i++)
			curr+=a[i];
		int minavg=curr;
		for(int i=k;i<a.length;i++)
		{
			curr=curr+a[i]-a[i-k];
			if(curr<minavg)
			{
				minavg=curr;
				resind=i-k+1;
			}
		}
		System.out.print(resind+ " "+ (resind+k-1));
	}

	public static void main(String[] args) 
	{
		int a[]= {3, 7, 90, 20, 10, 50, 40},k=3;
		System.out.print("The least average sub array is+ ");
		findLeastAverage(a,k);
	}

}
