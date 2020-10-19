package linkedList4;

public class MergeSortedLinkedLists 
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

	node merge(node left,node right)
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

		MergeSortedLinkedLists li1 = new MergeSortedLinkedLists(); 
		
		li1.push(15); 
		li1.push(10); 
		li1.push(5); 
		MergeSortedLinkedLists li2 = new MergeSortedLinkedLists(); 
		li2.push(20); 
		li2.push(3); 
		li2.push(2); 
		MergeSortedLinkedLists li = new MergeSortedLinkedLists(); 
		li.head = li.merge(li1.head,li2.head);
		System.out.print("Sorted Linked List is: \n"); 
		li.printList(li.head); 
	} 
} 
//algo
//use merge function from sorting a linked list

