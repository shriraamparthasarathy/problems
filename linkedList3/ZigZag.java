package linkedList3;
//Given a linked list, rearrange it such that converted list should be of the form 
//a < b > c < d > e < f .. where a, b, c.. are consecutive data node of the linked list.
//
//Examples:
//
//Input:  1->2->3->4
//Output: 1->3->2->4 
//
//Input:  11->15->20->5->10
//Output: 11->20->5->15->10
public class ZigZag 
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
	
	void zigZagList()
	{
		boolean flag =true; // true represents that the next element should be <
		Node curr=head;
		while(curr!=null&&curr.next!=null)
		{
			if(flag)
			{
				if(curr.data>curr.next.data)
				{
					int temp=curr.data;
					curr.data=curr.next.data;
					curr.next.data=temp;
				}
			}
			else
			{
				if(curr.data<curr.next.data)
				{
					int temp=curr.data;
					curr.data=curr.next.data;
					curr.next.data=temp;
				}
			}
			curr=curr.next;
			flag=(!flag);
		}
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
		ZigZag llist = new ZigZag(); 
		llist.push(1); 
		llist.push(2); 
		llist.push(6); 
		llist.push(8); 
		llist.push(7); 
		llist.push(3); 
        llist.push(4); 

		System.out.println("Origional Linked List"); 
		llist.printList(); 

		llist.zigZagList(); 

		System.out.println("Modified Linked List"); 
		llist.printList(); 
	} 
}
