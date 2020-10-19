package arrayorderstatistics2;

public class MaximumPathSuminSortedArrays
{	
	static int max(int a,int b)
	{
		return a>b?a:b;
	}
	static int findMaxSum(int a1[],int a2[])
	{
		int i=0,j=0,res=0,sum1=0,sum2=0;
		while(i<a1.length&&j<a2.length)
		{
			if(a1[i]<a2[j])
				sum1+=a1[i++];
			else if(a1[i]>a2[j])
				sum2+=a2[j++];
			else
			{
				res+=max(sum1,sum2)+a1[i++];
				j++;
				sum1=0;
				sum2=0;
			}
		}
		while(i<a1.length)
			sum1+=a1[i++];
		while(j<a2.length)
			sum2+=a2[j++];
		res+=max(sum1,sum2);
		return res;
	}
	public static void main(String[] args)
	{
//		int ar1[]={2,3,7,7,12};
//		int ar2[]={1,5,7,7,7,7};
		int a1[] = {2, 3, 7, 10, 12, 15, 30, 34}; 
        int a2[] = {1, 5, 7, 8, 10, 15, 16, 19};
        System.out.print("The maximum path sum is: "+findMaxSum(a1,a2));
	}
}
