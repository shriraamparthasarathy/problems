package ArraySorting;
import java.util.Arrays;
public class MergeSort 
{
	static void merge(int a[],int l,int m,int r)
	{
		int n1=m-l+1;
		int n2=r-m;
		int L[]=new int[n1];
		int R[]=new int[n2];
		int i=0,j=0,k;
		while(i<n1)
		{	
			L[i]=a[l+i];
			i++;
		}	
		while(j<n2)
		{	
			R[j]=a[m+1+j];
			j++;
		}	
		i=0;
		j=0;
		k=l;
		while(i<n1&&j<n2)
		{
			if(L[i]<=R[j])
				a[k++]=L[i++];
			else
				a[k++]=R[j++];
		}
		while(i<n1)
			a[k++]=L[i++];
		while(j<n2)
			a[k++]=R[j++];
	}
	static void sort(int a[],int l,int r)
	{
		if(l<r)
		{
			int m=l+(r-l)/2;
			sort(a,l,m);
			sort(a,m+1,r);
			merge(a,l,m,r);
		}
	}
	public static void main(String[] args) 
	{
		int a[]= {12, 11, 13, 5, 6, 7};
		sort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
