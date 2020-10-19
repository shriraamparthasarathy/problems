package ArraySorting;
//import java.util.Arrays;
public class SumClosesttoZero 
{

	static int partition(int a[],int low,int high)
	{
		int i=low-1,pivot=a[high];
		for(int j=low;j<high;j++)
		{
			if(a[j]<pivot)
			{
				i++;
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
		int t=a[i+1];
		a[i+1]=a[high];
		a[high]=t;
		return i+1;
	}
	static void quickSort(int a[],int low,int high)
	{
		if(low<high)
		{	
			int pi=partition(a,low,high);
			quickSort(a,low,pi-1);
			quickSort(a,pi+1,high);
		}	
	}
	static void findSumClosesttoZero(int a[])
	{
		quickSort(a,0,a.length-1);
		int minl=0,minr=a.length-1;
		int l=minl,r=minr;
		int sum=Integer.MAX_VALUE;
		while(l<r)
		{
			if(Math.abs(a[l]+a[r])<Math.abs(sum))
			{
				minl=l;
				minr=r;
				sum=a[l]+a[r];
			}
			if(sum<0)
				l++;
			else
				r--;
		}
		System.out.println("The mimum elements are: "+a[minl]+" "+a[minr]);
		
	}
	public static void main(String[] args) 
	{
		int a[]= {1, 60, -10, 70, -80, 85};
		findSumClosesttoZero(a);

	}

}
