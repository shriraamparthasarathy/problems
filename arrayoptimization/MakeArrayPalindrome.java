package arrayoptimization;

public class MakeArrayPalindrome 
{
	static int findNoMerge(int a[],int n)
	{
		int res=0;
		for(int i=0,j=n-1;i<j;)
		{
			if(a[i]==a[j])
			{
				i++;
				j--;
			}
			else if(a[i]>a[j])
			{
				j--;
				a[j]+=a[j+1];
				res++;
			}
			else
			{
				i++;
				a[i]+=a[i-1];
				res++;
			}
		}
		return res;
	}
	public static void main(String[] args) 
	{
		int a[]= {1, 4, 5, 9, 1},n=a.length;
		System.out.println("The number of merge operations is:"+findNoMerge(a,n));

	}

}
