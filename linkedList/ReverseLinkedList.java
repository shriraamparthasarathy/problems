package linkedList;


class ReverseLinkedList 
{ 

	static Node head; 

	static class Node { 

		int data; 
		Node next; 

		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	Node reverse(Node node) 
	{ 
		Node prev=null;
		Node curr=head;
		Node next=null;
		while(curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	} 

	void printList(Node node) 
	{ 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	public static void main(String[] args) 
	{ 
		ReverseLinkedList list = new ReverseLinkedList(); 
		head = new Node(85); 
		head.next = new Node(15); 
		head.next.next = new Node(4); 
		head.next.next.next = new Node(20); 

		System.out.println("Given Linked list"); 
		list.printList(head); 
		head = list.reverse(head); 
		System.out.println(""); 
		System.out.println("Reversed linked list "); 
		list.printList(head); 
	} 
} 
//algo
//Initialize three pointers prev as NULL, curr as head and next as NULL.
//Iterate trough the linked list. In loop, do following.
//// Before changing next of current,
//// store next node
//next = curr->next
//// Now change next of current
//// This is where actual reversing happens
//curr->next = prev
//
//// Move prev and curr one step forward
//prev = curr
//curr = next