package linkedList2;


class IdenticalLinkedList 
{ 
	Node head; 
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) { data = d; next = null; } 
	} 
	boolean areIdentical(IdenticalLinkedList listb) 
	{ 
		Node a=this.head;
		Node b=listb.head;
		while(a!=null&&b!=null)
		{
			if(a.data!=b.data)
				return false;
			a=a.next;
			b=b.next;
		}
//		 If linked lists are identical, then 'a' and 'b' must 
//	     be null at this point. 
		return (a==null&&b==null);
	} 


	void push(int new_data) 
	{
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	public static void main(String args[]) 
	{ 
		IdenticalLinkedList llist1 = new IdenticalLinkedList(); 
		IdenticalLinkedList llist2 = new IdenticalLinkedList(); 


		llist1.push(1); 
		llist1.push(2); 
		llist1.push(3); 

		llist2.push(1); 
		llist2.push(2); 
		llist2.push(3); 

		if (llist1.areIdentical(llist2) == true) 
			System.out.println("Identical "); 
		else
			System.out.println("Not identical "); 

	} 
} 
