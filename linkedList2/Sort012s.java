package linkedList2;
//Given a linked list of 0s, 1s and 2s, sort it.
//
//Examples:
//
//Input: 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL
//Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2 -> NULL
//
//Input: 1 -> 1 -> 2 -> 1 -> 0 -> NULL
//Output: 0 -> 1 -> 1 -> 1 -> 2 -> NULL
class Sort012s 
{ 
	Node head;
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 

	void sortList() 
	{ 
		Node curr=head;
		int count[]= {0,0,0};
		while(curr!=null)
		{
			count[curr.data]++;
			curr=curr.next;
		}
		curr=head;
		int i=0;
		while(curr!=null)
		{
			if(count[i]==0)
				i++;
			curr.data=i;
			count[i]--;
			curr=curr.next;
		}
	}				
	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	/* Function to print linked list */
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
		Sort012s llist = new Sort012s();
		llist.push(0); 
		llist.push(1); 
		llist.push(0); 
		llist.push(2); 
		llist.push(1); 
		llist.push(1); 
		llist.push(2); 
		llist.push(1); 
		llist.push(2); 
		
		System.out.println("Linked List before sorting"); 
		llist.printList(); 
		
		llist.sortList(); 

		System.out.println("Linked List after sorting"); 
		llist.printList(); 
	} 
} 
//algo
//Traverse the list and count the number of 0s, 1s and 2s. Let the counts be n1, n2 and n3 
//respectively.
//Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with 1 and finally n3
//nodes with 2.