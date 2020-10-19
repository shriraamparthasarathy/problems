package arrayoptimization;
import java.util.Arrays;
public class MinimumDifferenceBetweentwonumbers 
{
	static int findMinimumDifference(int a[])
	{
		int n=a.length,min=Integer.MAX_VALUE;
		Arrays.sort(a);
		for(int i=0;i<n-1;i++)
			if(min>a[i+1]-a[i])
				min=a[i+1]-a[i];
		return min;
	}
	public static void main(String [] args) 
	{
		int a[]= {1, 5, 3, 19, 18, 25};
		System.out.println("The minimum difference is: "+findMinimumDifference(a));
	}
}
