package ArraySorting;
//if there are duplicate elements in the array, we need to have some conditions for that
public class UnionandIntersectionSortedArrays 
{

	static void findUnion(int a1[],int a2[])
	{
		int i,j;
		System.out.print("Union is: ");
		for(i=0,j=0;i<a1.length&&j<a2.length;)
		{
			if(a1[i]==a2[j])
			{
				System.out.print(a1[i]+" ");
				i++;
				j++;
			}
			else if(a1[i]<a2[j])
				System.out.print(a1[i++]+" ");
			else
				System.out.print(a2[j++]+" ");
		}
		while(i<a1.length)
			System.out.print(a1[i++]+" ");
		while(j<a2.length)
			System.out.print(a2[j++]+" ");
		System.out.println();
	}
	static void findIntersection(int a1[],int a2[])
	{
		System.out.print("Intersection is: ");
		for(int i=0,j=0;i<a1.length&&j<a2.length;)
		{
			if(a1[i]==a2[j])
			{
				System.out.print(a1[i]+" ");
				i++;
				j++;
			}
			else if(a1[i]<a2[j])
				i++;
			else
				j++;
		}
	}
	public static void main(String[] args) 
	{
		int arr1[] = {1, 2, 4, 5, 6}; 
        int arr2[] = {2, 3, 5, 7};
        findUnion(arr1,arr2);
        findIntersection(arr1,arr2);

	}

}
