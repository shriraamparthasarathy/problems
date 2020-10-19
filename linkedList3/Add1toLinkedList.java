package linkedList3;
//Number is represented in linked list such that each digit corresponds to a node
//in linked list. Add 1 to it. For example 1999 is represented as (1-> 9-> 9 -> 9) and
//adding 1 to it should change it to (2->0->0->0)
public class Add1toLinkedList 
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
	void reverse() 
	{ 
		Node prev=null;
		Node curr=head;
		Node next=null;
		while(curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head= prev;
	} 
	void addOne()
	{
		int carry=1,sum=0;
		reverse();
		Node curr=head;
		while(curr!=null&&carry>0)
		{
			sum=carry+curr.data;
			carry=(sum>9)?1:0;
			curr.data=sum%10;
			curr=curr.next;
		}
		reverse();
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
		Add1toLinkedList llist = new Add1toLinkedList(); 
		llist.push(9); 
		llist.push(9); 
		llist.push(9); 
		llist.push(1); 


		System.out.println("Origional Linked List"); 
		llist.printList(); 

		llist.addOne();
		System.out.println("Modified Linked List"); 
		llist.printList(); 
	} 

}
//algo
//Reverse given linked list. For example, 1-> 9-> 9 -> 9 is converted to 9-> 9 -> 9 ->1.
//Start traversing linked list from leftmost node and add 1 to it. If there is a carry, move to the
//next node. Keep moving to the next node while there is a carry.
//Reverse modified linked list and return head.