package githubprograms;
import java.util.Scanner;

public class ElementinRotatedArray 
{
	static Scanner sc=new Scanner(System.in);
	
	public static int findElement(int a[],int l,int h,int s)
	{
		if(l>h)
			return -1;
		int m=l+(h-l)/2;
		if(a[m]==s)
			return m;
		if(a[l]<a[m])
		{
			if(s>=a[l]&&s<=a[m])
				return findElement(a,l,m-1,s);
			return findElement(a,m+1,h,s);
			
		}
		if(s>=a[m+1]&&s<=a[h])
			return findElement(a,m+1,h,s);
		return findElement(a,l,m-1,s);
	}
	
	public static void main(String[] args) 
	{
		int a[]= {3,4,5,1,2},n=a.length,s,res=0;
		System.out.println("Enter the element to be searched: ");
		s=sc.nextInt();
		res=findElement(a,0,n-1,s);
		if(res==-1)
			System.out.println("Element not found");
		else
			System.out.println("Element is in "+res+" Position");
		
	}

}
