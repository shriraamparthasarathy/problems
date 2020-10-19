package binaryHeap;

class MinHeap
{
	private int[] Heap;
    private int size;
    private int maxsize;

    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos)
    {
        return (pos-1) / 2;
    }
 
    private int left(int pos)
    {
        return (2 * pos) + 1;
    }
 
    private int right(int pos)
    {
        return (2 * pos) + 2;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Inserts a new key 'k'
	public void insertKey(int k)
	{
	    if (size == maxsize)
	    {
	        System.out.println("Overflow: Could not insertKey");
	        return;
	    }
	 
	    // First insert the new key at the end
	    size++;
	    int i = size - 1;
	    Heap[i] = k;
	 
	    // Fix the min heap property if it is violated
	    while (i != 0 && Heap[parent(i)] > Heap[i])
	    {
	       swap(i, parent(i));
	       i = parent(i);
	    }
	}

	// Decreases value of key at index 'i' to new_val.  It is assumed that
	// new_val is smaller than harr[i].
	public void decreaseKey(int i, int new_val)
	{
	    Heap[i] = new_val;
	    while (i != 0 && Heap[parent(i)] > Heap[i])
	    {
	       swap(i, parent(i));
	       i = parent(i);
	    }
	}

	public int extractMin()
	{
	    if (size <= 0)
	        return Integer.MAX_VALUE;
	    if (size == 1)
	    {
	        size--;
	        return Heap[0];
	    }
	 
	    // Store the minimum value, and remove it from heap
	    int root = Heap[0];
	    Heap[0] = Heap[size-1];
	    size--;
	    MinHeapify(0);
	 
	    return root;
	}

	// This function deletes key at index i. It first reduced value to minus
	// infinite, then calls extractMin()
	public void deleteKey(int i)
	{
	    decreaseKey(i, Integer.MIN_VALUE);
	    System.out.println();
	    print();
	    extractMin();
	    System.out.println();
	}

	// A recursive method to heapify a subtree with the root at given index
	// This method assumes that the subtrees are already heapified
	public void MinHeapify(int i)
	{
	    int l = left(i);
	    int r = right(i);
	    int smallest = i;
	    if (l < size && Heap[l] < Heap[i])
	        smallest = l;
	    if (r < size && Heap[r] < Heap[smallest])
	        smallest = r;
	    if (smallest != i)
	    {
	        swap(i, smallest);
	        MinHeapify(smallest);
	    }
	}

	public void print()
    {
        for (int i = 0; i < size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i + 1] 
                + " RIGHT CHILD :" + Heap[2 * i  + 2]);
            System.out.println();
        } 
    }

	public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insertKey(5);
        minHeap.insertKey(3);
        minHeap.insertKey(17);
        minHeap.insertKey(10);
        minHeap.insertKey(84);
        minHeap.insertKey(19);
        minHeap.insertKey(6);
        minHeap.insertKey(22);
        minHeap.insertKey(9);
 
        minHeap.print();
        System.out.println("The Min val is " + minHeap.Heap[0]);
        minHeap.deleteKey(1);
        minHeap.print();
    }
}
//explanation
//insertKey()
//size
//1     3
//2     5 3 
//      3 5 
//3     3 5 17 
//4     3 5 17 10
//5     3 5 17 10 84
//6     3 5 17 10 84 19
//7     3 5 17 10 84 19 6
//      3 5 6 10 84 19 17
//8     3 5 6 10 84 19 17 22
//9     3 5 6 10 84 19 17 22 9
//      3 5 6 9 84 19 17 22 10
//
//deleteKey(index 1(5))
//	 decreaseKey(index 1(5), _) here _ represents the lowest value which is minus infinity 
//	 3 _ 6 9 84 19 17 22 10
//   _ 3 6 9 84 19 17 22 10
//	 extractmin() 
//	 -after swapping minus infinity to last element and reducing the size by 1
//	 10 3  6 9 84 19 17 22 
//	 3 10  6 9 84 19 17 22 
//	 3 9  6 10 84 19 17 22 



//algo for all the functions
//A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.

//The root element will be at Arr[0].
//Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
//Arr[(i-1)/2]	Returns the parent node
//Arr[(2*i)+1]	Returns the left child node
//Arr[(2*i)+2]	Returns the right child node

//1) getMini(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
//
//2) extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is
//O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after 
//removing root.
//
//3) decreaseKey(): Decreases value of key. The time complexity of this operation is O(Logn).
//If the decreases key value of a node is greater than the parent of the node, then we don’t 
//need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
//
//
//
//
//4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree.
//IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to 
//traverse up to fix the violated heap property.
//
//5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minus
//infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, 
//so we call extractMin() to remove the key.