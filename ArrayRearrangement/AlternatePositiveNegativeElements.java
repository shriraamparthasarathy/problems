package ArrayRearrangement;

public class AlternatePositiveNegativeElements 
{
	static int a[]= {-1, 2, -3, 4, 5, 6, -7, 8, 9}; //a[]={-1,-1,-1,2,2}
	public static void swap(int i,int j)
	{
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void alternate()
	{
		int n=a.length,i=-1;
		for(int j=0;j<n;j++)
		{
			if(a[j]%2<0)
			{
				i++;
				swap(i,j);
			}
		}
		int pos=i+1,neg=0;
		while(pos<n&&neg<pos&&a[neg]<0)
		{
			swap(neg,pos);
			pos++;
			neg+=2;
		}
	}
	public static void displayArray()
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args)
	{
		alternate();
		displayArray();
	}
}
