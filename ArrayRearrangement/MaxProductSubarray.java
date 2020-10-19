package ArrayRearrangement;

public class MaxProductSubarray 
{
	static int maxProduct(int a[])
	{
		int maxVal= a[0],minVal=a[0],maxpro=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<0)
			{
				int temp=minVal;
				minVal=maxVal;
				maxVal=temp;
			}
			minVal=Math.min(a[i], minVal*a[i]);
			maxVal=Math.max(a[i], maxVal*a[i]);
			maxpro=Math.max(maxVal, maxpro);
		}
		return maxpro;
	}
	public static void main(String[] args)
	{
		int a[]= {-1, -3, -10, 0, 60 };// 6, -3, -10, 0, 2
		System.out.println("The max product is: "+maxProduct(a));
	}
}
