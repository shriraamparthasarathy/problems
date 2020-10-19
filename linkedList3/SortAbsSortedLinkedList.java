package linkedList3;
//Given a linked list which is sorted based on absolute values. Sort the list based on actual
//values.
//
//Examples:
//
//Input :  1 -> -10 
//output: -10 -> 1
//
//Input : 1 -> -2 -> -3 -> 4 -> -5 
//output: -5 -> -3 -> -2 -> 1 -> 4 
//
//Input : -5 -> -10 
//Output: -10 -> -5
//
//Input : 5 -> 10 
//output: 5 -> 10
class SortAbsSortedLinkedList 
{ 
	Node head; 
	static class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 
	Node sortedList(Node head) 
	{ 
		Node prev=head,curr=head.next;
		while(curr!=null)
		{
			if(prev.data>curr.data)
			{
				prev.next=curr.next;
				curr.next=head;
				head=curr;
				curr=prev;
			}
			else
			{
				prev=curr;
			}
			curr=curr.next;
		}
		return head;
	} 
	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 
	void printList(Node head) 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
		System.out.print(temp.data+" "); 
		temp = temp.next; 
		} 
		System.out.println(); 
	} 
	public static void main(String args[]) 
	{ 
		SortAbsSortedLinkedList llist = new SortAbsSortedLinkedList(); 
		
		/* Constructed Linked List is 1->2->3->4->5->6-> 
		7->8->8->9->null */
		llist.push(-5); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(-2); 
		llist.push(1); 
		llist.push(0); 
		
		System.out.println("Original List :"); 
		llist.printList(llist.head); 
		
		llist.head = llist.sortedList(llist.head); 

		System.out.println("Sorted list :"); 
		llist.printList(llist.head); 
	} 
} 
//algo
//An efficient solution can work in O(n) time. An important observation is, all negative
//elements are present in reverse order. So we traverse the list, whenever we find an element
//that is out of order, we move it to the front of linked list.
