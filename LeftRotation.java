package githubprograms;
import java.util.*;
//Print left rotation of array in O(n) time and O(1) space
//Examples:
//
//Input : arr[] = {1, 3, 5, 7, 9}
//        k1 = 1
//        k2 = 3
//        k3 = 4
//        k4 = 6
//Output : 3 5 7 9 1
//         7 9 1 3 5
//         9 1 3 5 7
//         3 5 7 9 1
//
//Input : arr[] = {1, 3, 5, 7, 9}
//        k1 = 14 
//Output : 9 1 3 5 7

public class LeftRotation {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) 
	{
		
		int arr[]=new int[25];
		System.out.print("Enter the aray size:");
		int n=sc.nextInt();
		int k;
		System.out.print("Enter the array");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.print("Enter the no of elements to be rotated or enter 0 to exit:");
		while((k=sc.nextInt())!=0)
		{
			rotation(arr,n,k);
			System.out.print("\nEnter the no of elements to be rotated or enter 0 to exit:");
		}
		

	}

	private static void rotation(int[] a, int n, int k) 
	{
		System.out.println("The array is:");
		for(int i=k;i<k+n;i++)
		{
			System.out.print(a[i%n] + " ");
		}
	}

}
