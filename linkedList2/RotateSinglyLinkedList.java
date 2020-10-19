package linkedList2;
//Given a singly linked list, rotate the linked list counter-clockwise by k nodes.
//Where k is a given positive integer. For example, if the given linked list is
//10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40.
//Assume that k is smaller than the count of nodes in linked list.
class RotateSinglyLinkedList 
{ 
	Node head; 
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 
	void rotate(int k) 
	{ 
		 if(head==null)
			 return;
		 Node curr=head;
		 int count=1;
		 while(count<k&&curr!=null)
		 {
			 count++;
			 curr=curr.next;
		 }
		 if(curr==null)
			 return;
		 Node kthelement=curr;
		 while(curr.next!=null)
			 curr=curr.next;
		 curr.next=head;
		 head=kthelement.next;
		 kthelement.next=null;
	} 

	void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
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
		RotateSinglyLinkedList llist = new RotateSinglyLinkedList();
		for (int i = 60; i >= 10; i -= 10) 
			llist.push(i); 

		System.out.println("Given list"); 
		llist.printList(); 

		llist.rotate(4); 

		System.out.println("Rotated Linked List"); 
		llist.printList(); 
	} 
}
//algo
//To rotate the linked list, we need to change next of kth node to NULL, next of the last node
//to the previous head node, and finally, change head to (k+1)th node. So we need to get hold of 
//three nodes: kth node, (k+1)th node and last node.
//Traverse the list from the beginning and stop at kth node. Store pointer to kth node. We can
//get (k+1)th node using kthNode->next. Keep traversing till the end and store pointer to last node
//also. Finally, change pointers as stated above.