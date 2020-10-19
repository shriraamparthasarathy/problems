package ArraySorting;

import java.util.Arrays;

//sort array as the mimum number will be multiplied with 0 and maximum will be by n-1
public class MaximizeAi 
{

	static int findMaxSum(int a[])
	{
		int sum=0;
		Arrays.sort(a);
		for(int i=1;i<a.length;i++)
			sum+=a[i]*i;
		return sum;
	}
	public static void main(String[] args) 
	{
		int a[]={ 3, 5, 6, 1 };
		System.out.println("The max sum is:"+ findMaxSum(a));

	}

}
