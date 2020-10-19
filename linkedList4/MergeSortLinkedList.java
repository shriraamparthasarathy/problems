package linkedList4;


public class MergeSortLinkedList 
{ 
	node head = null; 
	static class node { 
		int val; 
		node next; 

		public node(int val) 
		{ 
			this.val = val; 
		} 
	} 

	node merge(node left, node right)
	{
		node result=null;
		if(left==null)
			return right;
		if(right==null)
			return left;
		if(left.val<=right.val)
		{
			result=left;
			result.next=merge(left.next,right);
		}
		else
		{
			result=right;
			result.next=merge(left,right.next);
		}
		return result;
	}

	node mergeSort(node h)
	{
		if(h==null||h.next==null)
			return h;
		node middle=getMiddle(h);
		node middleNext=middle.next;
		middle.next=null;
		node left=mergeSort(h);
		node right=mergeSort(middleNext);
		node sorted=merge(left,right);
		return sorted;
	}
	public static node getMiddle(node head) 
	{ 
		if (head == null) 
			return head; 

		node slow = head, fast = head; 

		while (fast.next != null && fast.next.next != null) { 
			slow = slow.next; 
			fast = fast.next.next; 
		} 
		return slow; 
	} 

	void push(int new_data) 
	{ 
		node new_node = new node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 
	void printList(node headref) 
	{ 
		while (headref != null) { 
			System.out.print(headref.val + " "); 
			headref = headref.next; 
		} 
	} 

	public static void main(String[] args) 
	{ 

		MergeSortLinkedList li = new MergeSortLinkedList(); 
		
		li.push(15); 
		li.push(10); 
		li.push(5); 
		li.push(20); 
		li.push(3); 
		li.push(2); 
		li.head = li.mergeSort(li.head); 
		System.out.print("Sorted Linked List is: \n"); 
		li.printList(li.head); 
	} 
} 
//algo
//MergeSort(headRef)
//1) If the head is NULL or there is only one element in the Linked List 
//    then return.
//2) Else divide the linked list into two halves.  
//      FrontBackSplit(head, &a, &b); /* a and b are two halves */
//3) Sort the two halves a and b.
//      MergeSort(a);
//      MergeSort(b);
//4) Merge the sorted a and b (using SortedMerge() discussed here) 
//   and update the head pointer using headRef.
//     *headRef = SortedMerge(a, b);
