package arrayoptimization;

public class SmallestNumberSubset 
{

	static int findMiniSubset(int a[])
	{
		int n=a.length,mini=1;
		for(int i=0;i<n&&a[i]<=mini;i++)
			mini+=a[i];
		return mini;
	}
	public static void main(String[] args) 
	{
		int a[]= {1, 3, 4, 5};
		System.out.println("The minimum number not present is: "+findMiniSubset(a));

	}

}
