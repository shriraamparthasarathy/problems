package binaryHeap2;

public class KthLargestElement
{
	static class MinHeap
	{
		int[] Heap;
	    int size;
	    int maxsize;

	    MinHeap(int a[], int size) 
	    { 
	        this.size = size; 
	        Heap = a;  
	    } 

	    int parent(int pos)
	    {
	        return (pos-1) / 2;
	    }
	 
	    int left(int pos)
	    {
	        return (2 * pos) + 1;
	    }
	 
	    int right(int pos)
	    {
	        return (2 * pos) + 2;
	    }

	    void swap(int fpos, int spos)
	    {
	        int tmp;
	        tmp = Heap[fpos];
	        Heap[fpos] = Heap[spos];
	        Heap[spos] = tmp;
	    }

		void replaceMin(int x)
		{
			Heap[0]=x;
			MinHeapify(0);
		}
		void buildHeap()
		{
			int i=(size-1)/2;
			while(i>=0)
			{
				MinHeapify(i);
				i--;
			}
		}
		int getMin()
		{
			return this.Heap[0];
		}

		public void MinHeapify(int i)
		{
		    int l = left(i);
		    int r = right(i);
		    int smallest = i;
		    if (l < size && Heap[l] < Heap[smallest])
		        smallest = l;
		    if (r < size && Heap[r] < Heap[smallest])
		        smallest = r;
		    if (smallest != i)
		    {
		        swap(i, smallest);
		        MinHeapify(smallest);
		    }
		}

		static void kthLargest(int k)
		{
			int a[]={10, 20, 11, 70, 50, 40, 100, 5};
			int count=0,i=0;
			int arr[]=new int[k];
			MinHeap mh=new MinHeap(arr,k);
			while(i<a.length)
			{
				System.out.print("Element entered: "+a[i]+" -> ");
				if(count<k-1)
				{
					arr[count]=a[i];
					count++;
					System.out.println(k+" largest is: _");
				}
				else
				{
					if(count==k-1)
					{
						arr[count]=a[i];
						mh.buildHeap();
					}
					else
					{
						if(a[i]>mh.getMin())
							mh.replaceMin(a[i]);
					}
					count++;
					System.out.println(k+" largest is: "+mh.getMin());
				}
				i++;
			}
			
		}
		public static void main(String[] arg)
	    {
	        int k=3;
	        kthLargest(k);
	    }
	}
}
//algo
//An Efficient Solution is to use Min Heap of size k to store k largest elements of stream.
//The k’th largest element is always at root and can be found in O(1) time.
//How to process a new element of stream?
//Compare the new element with root of heap. If new element is smaller, then ignore it.
//Otherwise replace root with new element and call heapify for the root of modified heap. 
//Time complexity of finding the k’th largest element is O(Logk).