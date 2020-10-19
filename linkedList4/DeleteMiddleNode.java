package linkedList4;
//Given a singly linked list, delete middle of the linked list. For example, if given linked list
//is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
//
//If there are even nodes, then there would be two middle nodes, we need to delete the second
//middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified
//to 1->2->3->5->6.
//
//If the input linked list is NULL, then it should remain NULL.
//
//If the input linked list has 1 node, then this node should be deleted and new head should be
//returned.
public class DeleteMiddleNode 
{
	Node head; 
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 
	void push(int new_data) 
	{ 
		Node new_node = new Node(new_data);
		new_node.next = head; 
		head = new_node; 
	} 

	void deleteMid() 
	{ 
		if(head==null||head.next==null)
		{	
			head=null;
			return;
		}	
		Node slow=head,fast=head;
		Node prev=null;
		while(fast!=null&&fast.next!=null)
		{
			prev=slow;
			fast=fast.next.next;
			slow=slow.next;
		}
		prev.next=slow.next;
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
		DeleteMiddleNode llist1 = new DeleteMiddleNode();  
		llist1.push(4); 
		llist1.push(3); 
		llist1.push(2); 
		llist1.push(1); 

		System.out.println("First Linked List:"); 
		llist1.printList(); 

		llist1.deleteMid();

		System.out.println("Modified linked list:"); 
		llist1.printList(); 

	} 
}
//algo
//The idea is to use two pointers, slow_ptr and fast_ptr. Both pointers start from head 
// of list. When fast_ptr reaches end, slow_ptr reaches middle. This idea is same as the one used 
// in method 2 of this post. The additional thing in this post is to keep track of previous of
// middle so the middle node can be deleted.