package githubprograms;

public class MaximumSumOfindexarray
{
	public static void main(String[] args)
	{
		int arr[]= {8,3,1,2},n=arr.length,cum=0,max=0,cur=0,res;
		for(int i=0;i<n;i++)
		{
			cum+=arr[i];
			cur+=i*arr[i];
		}	
		max=cum;
		for(int i=1;i<n;i++)
		{
			res=cur-(cum-arr[i-1]) + arr[i-1]*(n-1);
			cur=res;
			if(res>max)
				max=res;
		}
		System.out.println("The maximum is "+ max);
	}

}
