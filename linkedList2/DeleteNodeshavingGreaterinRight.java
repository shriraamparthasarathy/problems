package linkedList2;
//Given a singly linked list, remove all the nodes which have a greater value on right side.
//
//Examples:
//a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. Note that
//12, 10, 5 and 2 have been deleted because there is a greater value on the right side.
//
//When we examine 12, we see that after 12 there is one node with value greater than 12 (i.e. 15), 
//so we delete 12.
//When we examine 15, we find no node after 15 that has value greater than 15 so we keep this node.
//When we go like this, we get 15->6->3
//
//b) The list 10->20->30->40->50->60->NULL should be changed to 60->NULL. Note that 10, 20, 30, 40 
//and 50 have been deleted because they all have a greater value on the right side.
//
//c) The list 60->50->40->30->20->10->NULL should not be changed.

class DeleteNodeshavingGreaterinRight
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

	void delLesserNodes() 
	{
		reverseList(); 
		_delLesserNodes(); 
		reverseList(); 
	} 
	void _delLesserNodes() 
	{ 
		Node curr=head;
		Node max=curr;
		while(curr!=null&&curr.next!=null)
		{
			if(curr.next.data<max.data)
			{
				Node temp=curr.next;
				curr.next=temp.next;
				temp=null;
			}
			else
			{
				curr=curr.next;
				max=curr;
			}
		}
	}
	void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	void reverseList() 
	{ 
		Node current = head; 
		Node prev = null; 
		Node next; 
		while (current != null) { 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
		} 
		head = prev; 
	} 
	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 
	public static void main(String args[]) 
	{ 
		DeleteNodeshavingGreaterinRight llist = new DeleteNodeshavingGreaterinRight(); 

		/* Constructed Linked List is 12->15->10->11-> 
		5->6->2->3 */
		llist.push(3); 
		llist.push(2); 
		llist.push(6); 
		llist.push(5); 
		llist.push(11); 
		llist.push(10); 
		llist.push(15); 
		llist.push(12); 

		System.out.println("Given Linked List"); 
		llist.printList(); 

		llist.delLesserNodes(); 

		System.out.println("Modified Linked List"); 
		llist.printList(); 
	} 
} 
//algo time complexity:  O(n)
//1. Reverse the list.
//2. Traverse the reversed list. Keep max till now. If next node is less than max, then delete the 
//next node, otherwise max = next node.
//3. Reverse the list again to retain the original order.