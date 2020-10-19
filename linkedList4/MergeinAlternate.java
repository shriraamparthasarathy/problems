package linkedList4;

class MergeinAlternate 
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

	void merge(MergeinAlternate q) 
	{ 
		Node p_curr=head,q_curr=q.head;
		Node p_next,q_next;
		while(p_curr!=null&&q_curr!=null)
		{
			p_next=p_curr.next;
			q_next=q_curr.next;
			
			p_curr.next=q_curr;
			q_curr.next=p_next;
			
			p_curr=p_next;
			q_curr=q_next;
		}
		q.head=q_curr;
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
		MergeinAlternate llist1 = new MergeinAlternate(); 
		MergeinAlternate llist2 = new MergeinAlternate(); 
		llist1.push(3); 
		llist1.push(2); 
		llist1.push(1); 

		System.out.println("First Linked List:"); 
		llist1.printList(); 

		llist2.push(8); 
		llist2.push(7); 
		llist2.push(6); 
		llist2.push(5); 
		llist2.push(4); 

		System.out.println("Second Linked List:"); 
		llist2.printList(); 
		llist1.merge(llist2); 

		System.out.println("Modified first linked list:"); 
		llist1.printList(); 

		System.out.println("Modified second linked list:"); 
		llist2.printList(); 
	} 
} 
//algo
//The idea is to run a loop while there are available positions in first loop and insert nodes of 
//second list by changing pointers.