package linkedList2;
//Given a linked list, write a function to reverse every k nodes (where k is an input
//		to the function).
//
//Example:
//
//Input: 1->2->3->4->5->6->7->8->NULL, K = 3
//Output: 3->2->1->6->5->4->8->7->NULL
//
//Input: 1->2->3->4->5->6->7->8->NULL, K = 5
//Output: 5->4->3->2->1->8->7->6->NULL
class ReverseinKClasses 
{ 
	Node head; 
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

	Node reverse(Node head, int k) 
	{ 
		Node next=null;
		Node curr=head;
		Node prev=null;
		int count=0;
		while(count<k&&curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
		}
		if(next!=null)
		head.next=reverse(next,k);
		return prev;
	}					 

	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 
	void printList() 
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
		ReverseinKClasses llist = new ReverseinKClasses();
		llist.push(9); 
		llist.push(8); 
		llist.push(7); 
		llist.push(6); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(2); 
		llist.push(1); 
		
		System.out.println("Given Linked List"); 
		llist.printList(); 
		
		llist.head = llist.reverse(llist.head, 3); 

		System.out.println("Reversed list"); 
		llist.printList(); 
	} 
} 
//algo
//Reverse the first sub-list of size k. While reversing keep track of the next node and previous
//node. Let the pointer to the next node be next and pointer to the previous node be prev.
//head->next = reverse(next, k) ( Recursively call for rest of the list and link the two sub-lists )
//Return prev ( prev becomes the new head of the list