package arrayorderstatistics2;

public class SmallestMissingPositiveElement
{

	static int findMissing(int a[])
	{
		boolean temp[]=new boolean[a.length+1];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>0&&a[i]<=a.length)
				temp[a[i]]=true;
		}
		for(int i=1;i<=a.length;i++)
		{
			if(!temp[i])
				return i;
		}
		return a.length+1;// if the element is not there lie {1,2,3} 4 is the smallest element which is a.length + 1
	}
	public static void main(String[] args) 
	{
		int a[]= {2, 3, -7, 6, 8, 1, -10, 15};
		System.out.print("The missing number is "+findMissing(a));

	}

}
