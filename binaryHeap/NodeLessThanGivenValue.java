package binaryHeap;
//Given a binary min heap and a value x, print all the binary heap nodes having value less than the
//given value x.
//
//Examples : Consider the below min heap as
//        common input two both below examples.
//                   2
//                /     \
//               3        15
//            /    \     / \
//           5       4  45  80
//          / \     / \
//         6   150 77 120
//
//Input  : x = 15        
//Output : 2 3 5 6 4
//
//Input  : x = 80
//Output : 2 3 5 6 4 77 15 45
public class NodeLessThanGivenValue 
{ 
static class MinHeap 
{ 
	int[] harr; 
	int capacity; 
	int heap_size; 
	public MinHeap(int cap) 
	{ 
		heap_size = 0; 
		capacity = cap; 
		harr = new int[cap]; 
	} 

	int parent(int i) { return (i - 1) / 2; } 
	int left(int i) { return (2 * i + 1); } 
	int right(int i) { return (2 * i + 2); } 
	void printSmallerThan(int x, int pos) 
	{ 
		if(pos>=heap_size)
			return;
		if(harr[pos]>=x)
			return;
		System.out.print(harr[pos]+" ");
		printSmallerThan(x,left(pos));
		printSmallerThan(x,right(pos));
	} 

 
	void insertKey(int k) 
	{ 
		if (heap_size == capacity) 
		{ 
			System.out.println("Overflow: Could not insertKey"); 
			return; 
		} 

		heap_size++; 
		int i = heap_size - 1; 
		harr[i] = k; 

		while (i != 0 && harr[parent(i)] > harr[i]) 
		{ 
			swap(i, parent(i)); 
			i = parent(i); 
		} 
	} 

	void swap(int x, int y) 
	{ 
		int temp = harr[x]; 
		harr[x] = harr[y]; 
		harr[y] = temp; 
	} 

}
public static void main(String[] args) 
{ 
	MinHeap h = new MinHeap(15); 
	h.insertKey(3); 
	h.insertKey(2); 
	h.insertKey(15); 
	h.insertKey(5); 
	h.insertKey(4); 
	h.insertKey(45); 
	h.insertKey(80); 
	h.insertKey(6); 
	h.insertKey(150); 
	h.insertKey(77); 
	h.insertKey(120); 
 
	int x = 100; 
	h.printSmallerThan(x, 0); 
} 
}
//algo
//The idea is to do a preorder traversal of the give Binary heap. While doing preorder traversal,
//if the value of a node is greater than the given value x, we return to the previous recursive call.
//Because all children nodes in a min heap are greater than the parent node. Otherwise we print
//current node and recur for its children.