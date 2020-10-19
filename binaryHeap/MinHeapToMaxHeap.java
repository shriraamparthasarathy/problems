package binaryHeap;

class MinHeapToMaxHeap 
{ 
	static void MaxHeapify(int arr[], int i, int n) 
	{ 
		int largest=i;
		int l=2*i + 1;
		int r=2*i + 2;
		if(l<n&&arr[l]>arr[largest])
			largest=l;
		if(r<n && arr[r]>arr[largest])
			largest=r;
		if(largest!=i)
		{
			int t=arr[largest];
			arr[largest]=arr[i];
			arr[i]=t;
			MaxHeapify(arr,largest,n);
		}
	} 

	static void convertMaxHeap(int arr[], int n) 
	{ 

		for (int i = (n-2)/2; i >= 0; --i) 
			MaxHeapify(arr, i, n); 
	} 

	static void printArray(int arr[], int size) 
	{ 
		for (int i = 0; i < size; ++i) 
			System.out.print(arr[i]+" "); 
	} 

	public static void main (String[] args) 
	{  
		int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9}; 
		int n = arr.length; 

		System.out.print("Min Heap array : "); 
		printArray(arr, n); 

		convertMaxHeap(arr, n); 

		System.out.print("\nMax Heap array : "); 
		printArray(arr, n); 
	} 
} 
//algo
//The idea is very simple – we simply build Max Heap without caring about the input.
//We start from bottom-most and rightmost internal mode of min Heap and heapify all internal modes
//in bottom up way to build the Max heap.