package linkedList2;

class DeleteAlternativeNode 
{ 
	Node head; 
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

	public void deleteAlt()
	{
		Node prev=head;
		Node now=head.next;
		while(prev!=null&&now!=null)
		{
			prev.next=now.next;
			now=null;
			prev=prev.next;
			if(prev!=null)
				now=prev.next;
		}
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
		DeleteAlternativeNode llist = new DeleteAlternativeNode();
		llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
          
        System.out.println("Linked List before calling deleteAlt() "); 
        llist.printList(); 
          
        llist.deleteAlt(); 
          
        System.out.println("Linked List after calling deleteAlt() "); 
        llist.printList(); 
	} 
}