package githubprograms;

public class RotateArraybyOne
{
	public static int[] cyclicRotate(int a[])
	{
		int x=a[a.length-1];
		for(int i=a.length-1;i>0;i--)
			a[i]=a[i-1];
		a[0]=x;
		return a;
	}
	
	public static void main(String[] args)
	{
		int a[]= {1,2,3,4,5,6,7};
		a=cyclicRotate(a);
		System.out.println("The rotated array is:");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
