package ArraySorting;
import java.util.Arrays;
import java.util.HashSet;
//findUnion(arr1,arr2); 				Union with normal method
//findIntersection(arr1,arr2);			Intersection with normal method
//findUnionHashing(arr1,arr2);			Union with hashing
//findIntersectionHashing(arr1,arr2);	Intersection with hashing
public class UnionandIntersectionUnsortedArray 
{

	static void findUnionHashing(int a[],int b[])
	{
		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<a.length;i++)
			hs.add(a[i]);
		for(int i=0;i<b.length;i++)
			hs.add(b[i]);
		System.out.print("\nUnion is: ");
		System.out.println(hs);
	}
	static void findIntersectionHashing(int a[],int b[])
	{
		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<a.length;i++)
			hs.add(a[i]);
		System.out.print("Intersection is: ");
		for(int i=0;i<b.length;i++)
		{
			if(hs.contains(b[i]))
				System.out.print(b[i]+" ");
		}
	}
	static int binarySearch(int a[],int l,int r,int x)
	{
		while(l<=r)
		{
			int m=l+(r-l)/2;
			if(a[m]==x)
				return m;
			else if(x>a[m])
				l=m+1;
			else
				r=m-1;
		}
		return -1;
	}
	static void findUnion(int a1[],int a2[])
	{
		//we sort the array with maximum length and find the elements in the second array from the first array using binary search
		int n1=a1.length,n2=a2.length;
		if(n1<n2)
		{
			int temp[]=a1;
			a1=a2;
			a2=temp;
			int t=n1;
			n1=n2;
			n2=t;
		}
		Arrays.sort(a1);
		System.out.print("Union is: ");
		for(int i=0;i<n1;i++)
			System.out.print(a1[i]+ " ");
		for(int i=0;i<n2;i++)
			if(binarySearch(a1,0,n1-1,a2[i])==-1)
				System.out.print(a2[i]+" ");
	}
	static void findIntersection(int a1[],int a2[])
	{
		int n1=a1.length,n2=a2.length;
		if(n1<n2)
		{
			int temp[]=a1;
			a1=a2;
			a2=temp;
			int t=n1;
			n1=n2;
			n2=t;
		}
		Arrays.sort(a1);
		System.out.print("\nIntersection is: ");
		for(int i=0;i<n2;i++)
			if(binarySearch(a1,0,n1-1,a2[i])!=-1)
				System.out.print(a2[i]+" ");
	}
	public static void main(String[] args) 
	{
		int arr1[] = {7, 1, 5, 2, 3, 6}; 
        int arr2[] = {3, 8, 6, 20, 7}; 
        findUnion(arr1,arr2);
        findIntersection(arr1,arr2);
//        findUnionHashing(arr1,arr2);
//        findIntersectionHashing(arr1,arr2);
	}

}
