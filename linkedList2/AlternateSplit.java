package linkedList2;
//Given a linked list, split the linked list into two with alternate nodes.
//
//Examples:
//
//Input : 1 2 3 4 5 6 7
//Output : 1 3 5 7
//         2 4 6
//
//Input : 1 4 5 6
//Output : 1 5
//         4 6
class AlternateSplit 
{ 
	static Node head; 
	static class Node  
	{ 
	    int data; 
	    Node next; 
	}; 

	static Node a=null, b=null;
	static void moveNode(Node a, Node b) 
	{ 
	    if (b == null || a == null) 
	        return; 
	  
	    if (a.next != null) 
	        a.next = a.next.next; 
	  
	    if (b.next != null) 
	        b.next = b.next.next; 
	  
	    moveNode(a.next, b.next); 
	} 
	static  void alternateSplit(Node head)
	{
		Node curr =head;
		a=curr;
		b=curr.next;
		Node aref=a,bref=b;
		moveNode(aref,bref);
	}
	static Node push(Node head, int new_data) 
	{ 
	    Node new_node = new Node(); 
	    new_node.data = new_data; 
	    new_node.next = (head); 
	    (head) = new_node; 
	    return head; 
	} 
	static void display(Node dummy) 
	{ 
		Node temp = dummy; 
		while (temp != null) 
		{ 
		System.out.print(temp.data+" "); 
		temp = temp.next; 
		} 
		System.out.println(); 
	} 
	public static void main(String args[]) 
	{ 
		Node head = null;  
	    head = push(head, 7); 
	    head = push(head, 6); 
	    head = push(head, 5); 
	    head = push(head, 4); 
	    head = push(head, 3); 
	    head = push(head, 2); 
	    head = push(head, 1); 
	      
	    alternateSplit(head); 
	  
	    System.out.printf("a : "); 
	    display(a); 
	    System.out.printf("\nb : "); 
	    display(b); 
	} 
}