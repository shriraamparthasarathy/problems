package arrayorderstatistics2;
//alternate solution :: https://www.geeksforgeeks.org/count-strictly-increasing-subarrays/ method 2
public class CountStrictlyIncreasingSubArrays 
{
	static int findCount(int a[])
	{
		int c=0,res=0;
		for(int i=1;i<a.length;i++)
		{
			if(a[i-1]<a[i])
			{
				c++;
				res+=c;
			}
			else
				c=0;
		}
		return res;
	}
	public static void main(String[] args)
	{
		int a[]= {1,2,2,4};
		System.out.print("The count of strictly increasing sub array is:"+findCount(a));
	}
}
