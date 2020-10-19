package ArrayRearrangement;

public class RearrangeEvenandOddPosition 
{
	public static void rearrangeArray(int arr[])
	{
		int temp;
		for(int i=0;i<arr.length-1;i++)
		{
			if(i%2==0 && arr[i]>arr[i+1])
			{
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			if(i%2!=0 && arr[i]<arr[i+1])
			{
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
	}
	public static void displayArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args)
	{
		int arr[]= {1,2,3,4,5};//1, 3, 2, 2, 5
		System.out.println("Array before rearrangement: ");
		displayArray(arr);
		System.out.println("\nArray after rearrangement: ");
		rearrangeArray(arr);
		displayArray(arr);
	}
}
