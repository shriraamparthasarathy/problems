package linkedList5;
//Given a singly linked list and a number k, find the last node whose n%k == 0,
//where n is the number of nodes in the list.
//
//Examples:
//
//Input : list = 1->2->3->4->5->6->7
//        k = 3
//Output : 6
//
//Input : list = 3->7->1->9->8
//        k = 2
//Output : 9
public class ModularNode 
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

	
	Node findModular(int k)
	{
		if(k<=0||head==null)
			return null;
		Node curr=head;
		Node modular=null;
		int i=0;
		while(curr!=null)
		{
			if(i%k==0)
			{
				modular=curr;
			}
			curr=curr.next;
			i++;
		}
		return modular;
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
		ModularNode llist1 = new ModularNode();
		llist1.push(6); 
		llist1.push(5); 
		llist1.push(4); 
		llist1.push(3); 
		llist1.push(2); 
		llist1.push(1); 
		int k=2;
		System.out.println("Linked List:"); 

		Node answer=llist1.findModular(k);

		System.out.println("Modular node is: "+answer.data); 
	} 
}
//algo
//1. Take a pointer modularNode and initialize it with NULL. Traverse the linked list.
//2. For every i%k=0, update modularNode.