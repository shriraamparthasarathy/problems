package linkedList;

class SegregateEvenOdd { 
	
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
	
	public void segregateEvenOdd()
	{ 
		Node oddstart=null;
		Node oddend=null;
		Node evenstart=null;
		Node evenend=null;
		Node curr=head;
		while(curr!=null)
		{
			if(curr.data%2==0)
			{
				if(evenstart==null)
				{
					evenstart=curr;
					evenend=curr;
				}
				else
				{
					evenend.next=curr;
					evenend=evenend.next;
				}
			}
			else
			{
				if(oddstart==null)
				{
					oddstart=curr;
					oddend=curr;
				}
				else
				{
					oddend.next=curr;
					oddend=oddend.next;
				}
			}
			curr=curr.next;
		}
		if(oddstart==null||evenstart==null)//no odd or even elements
			return;
		evenend.next=oddstart;
		oddend.next=null;
		head=evenstart;
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
		while(temp != null) 
		{ 
			System.out.print(temp.data+" "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 
	
	public static void main(String args[]) 
	{ 
		SegregateEvenOdd llist = new SegregateEvenOdd(); 
		llist.push(11); 
		llist.push(10); 
		llist.push(9); 
		llist.push(6); 
		llist.push(4); 
		llist.push(1); 
		llist.push(0); 
		System.out.println("Origional Linked List"); 
		llist.printList(); 

		llist.segregateEvenOdd(); 

		System.out.println("Modified Linked List"); 
		llist.printList(); 
	} 
} 
//algo
//The idea is to split the linked list into two: one containing all even nodes and other 
//containing all odd nodes. And finally attach the odd node linked list after the even node
//linked list.
//To split the Linked List, traverse the original Linked List and move all odd nodes to a 
//separate Linked List of all odd nodes. At the end of loop, the original list will have all
//the even nodes and the odd node list will have all the odd nodes. To keep the ordering of
//all nodes same, we must insert all the odd nodes at the end of the odd node list. And to
//do that in constant time, we must keep track of last pointer in the odd node list.