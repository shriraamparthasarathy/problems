package linkedList5;

public class DeleteWithReference 
{
	static Node head; 
	static class Node { 
		int data; 
		Node next; 
		
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 
	static void delete(Node node_ref) 
	{ 
		Node temp=node_ref.next;
		node_ref.data=temp.data;
		node_ref.next=temp.next;
		
	}  
	static void display() 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
	} 

	public static void main (String[] args) 
	{ 
		head = null; 
		head = new Node(1); 
		head.next = new Node(2); 
		head.next.next = new Node(4); 
		head.next.next.next = new Node(5); 
		
		System.out.println("Linked list before"+ 
						" insertion: "); 
		display(); 

		delete(head);

		System.out.println("\nLinked list after"+ 
						" insertion: "); 
		display(); 
	} 
}
//algo
//Fast solution is to copy the data from the next node to the node to be deleted and delete
//the next node. Something like following.
//
//// Find next node using next pointer
//struct Node *temp  = node_ptr->next;
//
//// Copy data of next node to this node
//node_ptr->data  = temp->data;
//
//// Unlink next node
//node_ptr->next  = temp->next;
//
//// Delete next node
//free(temp);