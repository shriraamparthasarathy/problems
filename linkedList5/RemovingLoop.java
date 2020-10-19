package linkedList5;

import java.util.HashSet;; 

public class RemovingLoop 
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
	 public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	void printList(Node node) 
	{ 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	 boolean removeLoop(Node h) 
	{ 
		HashSet<Node> s = new HashSet<Node>(); 
		Node prev=h;
		while(h!=null)
		{
			if(s.contains(h))
			{
				prev.next=null;
				return true;		
			}
			else
			{
				s.add(h);
				prev=h;
				h=h.next;
			}
		}
		return false;
	} 

	/* Driver program to test above function */
	public static void main(String[] args) 
	{ 
		RemovingLoop llist = new RemovingLoop(); 
		llist.push(20); 
		llist.push(4); 
		llist.push(15); 
		llist.push(10); 
		llist.head.next.next.next.next = llist.head; 

		if (llist.removeLoop(llist.head)) { 
			System.out.println("Linked List after removing loop"); 
			llist.printList(llist.head); 
		} 
		else
			System.out.println("No Loop found"); 
	} 
} 
//algo
//using hashing
