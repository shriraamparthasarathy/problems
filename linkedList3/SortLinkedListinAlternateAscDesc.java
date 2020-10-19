package linkedList3;
//Given a Linked List. The Linked List is in alternating ascending and descending orders. 
//Sort the list efficiently.
//Example:
//
//Input List: 10 -> 40 -> 53 -> 30 -> 67 -> 12 -> 89 -> NULL
//Output List: 10 -> 12 -> 30 -> 43 -> 53 -> 67 -> 89 -> NULL
//
//Input List: 1 -> 4 -> 3 -> 2 -> 5 -> NULL
//Output List: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
class SortLinkedListinAlternateAscDesc 
{ 
	Node head; 
	class Node { 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	Node newNode(int key) 
	{ 
		return new Node(key); 
	} 

	void sort() 
	{ 
		/* Create 2 dummy nodes and initialise as 
		heads of linked lists */
		Node Ahead = new Node(0), Dhead = new Node(0); 
		splitList(Ahead, Dhead); 

		Ahead = Ahead.next; 
		Dhead = Dhead.next; 

		Dhead = reverseList(Dhead); 

		head = mergeList(Ahead, Dhead); 
	} 

	Node reverseList(Node Dhead) 
	{ 
		Node current = Dhead; 
		Node prev = null; 
		Node next; 
		while (current != null) { 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
		} 
		Dhead = prev; 
		return Dhead; 
	}
	Node mergeList(Node head1, Node head2) 
	{ 
		// Base cases 
		if (head1 == null) 
			return head2; 
		if (head2 == null) 
			return head1; 

		Node temp = null; 
		if (head1.data < head2.data) { 
			temp = head1; 
			head1.next = mergeList(head1.next, head2); 
		} 
		else { 
			temp = head2; 
			head2.next = mergeList(head1, head2.next); 
		} 
		return temp; 
	} 
	// "Ahead" is reference to head of ascending linked list 
	// "Dhead" is reference to head of descending linked list 
	void splitList(Node Ahead, Node Dhead) 
	{ 
		Node ascn = Ahead; 
		Node dscn = Dhead; 
		Node curr = head; 

		while (curr != null)
		{ 
			ascn.next = curr; 
			ascn = ascn.next; 
			curr = curr.next; 

			if (curr != null) 
			{ 
				dscn.next = curr; 
				dscn = dscn.next; 
				curr = curr.next; 
			} 
		} 

		ascn.next = null; 
		dscn.next = null; 
	}
	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 

	 

	public static void main(String args[]) 
	{ 
		SortLinkedListinAlternateAscDesc llist = new SortLinkedListinAlternateAscDesc(); 
		llist.head = llist.newNode(10); 
		llist.head.next = llist.newNode(40); 
		llist.head.next.next = llist.newNode(53); 
		llist.head.next.next.next = llist.newNode(30); 
		llist.head.next.next.next.next = llist.newNode(67); 
		llist.head.next.next.next.next.next = llist.newNode(12); 
		llist.head.next.next.next.next.next.next = llist.newNode(89); 

		System.out.println("Given linked list"); 
		llist.printList(); 

		llist.sort(); 

		System.out.println("Sorted linked list"); 
		llist.printList(); 
	} 

}
//algo
//Separate two lists.
//Reverse the one with descending order
//Merge both lists.