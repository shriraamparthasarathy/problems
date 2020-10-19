package ArraySorting;

public class WaveForm 
{

	static void swap(int a[],int j,int i)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	static void waveForm(int a[])
	{
		int n=a.length;
		for(int i=0;i<n;i+=2)
		{
			if(i>0&&a[i-1]>a[i])
				swap(a,i-1,i);
			if(i<n-1&&a[i+1]>a[i])
				swap(a,i+1,i);
		}
	}
	public static void main(String[] args) 
	{
		int a[] = {10, 90, 49, 2, 1, 5, 23};
		waveForm(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");

	}

}
