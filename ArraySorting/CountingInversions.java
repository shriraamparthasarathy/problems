package ArraySorting;

import java.util.Arrays;

public class CountingInversions {

	static int mergecount(int a[],int l,int m,int r)
	{
		int swap=0;
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
			{
				a[k++]=R[j++];
				swap+=(m+1)-(l+i);
			}
		}
		while(i<n1)
			a[k++]=L[i++];
		while(j<n2)
			a[k++]=R[j++];
		return swap;
	}
	static int sort(int a[],int l,int r)
	{
		int count=0;
		if(l<r)
		{
			int m=l+(r-l)/2;
			count+=sort(a,l,m);
			count+=sort(a,m+1,r);
			count+=mergecount(a,l,m,r);
		}
		return count;
	}
	public static void main(String[] args) 
	{
		int a[]= {8, 4, 2, 1};
		System.out.println("The no of inversions is: "+sort(a,0,a.length-1));
		System.out.println(Arrays.toString(a));
	}
	

}
