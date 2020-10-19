package linkedList2;

class DeleteNnodesafterMnodes 
{ 

static class Node 
{ 
	int data; 
	Node next; 
}; 
static Node push( Node head_ref, int new_data) 
{
	Node new_node = new Node(); 
	new_node.data = new_data; 

	new_node.next = (head_ref); 
	(head_ref) = new_node; 
	
	return head_ref; 
} 

static void printList( Node head) 
{ 
	Node temp = head; 
	while (temp != null) 
	{ 
		System.out.printf("%d ", temp.data); 
		temp = temp.next; 
	} 
	System.out.printf("\n"); 
} 
static void skipMdeleteN( Node head, int M, int N) 
{ 
	Node curr=head,t;
	int i;
	while(curr!=null)
	{
		for(i=1;i<M&&curr!=null;i++)
			curr=curr.next;
		t=curr.next;
		for(i=1;i<=N&&t!=null;i++)
		{
			Node temp=t;
			t=t.next;
			temp=null;
		}
		curr.next=t;
		curr=curr.next;
	}
} 

public static void main(String args[]) 
{ 
	/* Create following linked list 
	1.2.3.4.5.6.7.8.9.10 */
	Node head = null; 
	int M=2, N=3; 
	head=push(head, 10); 
	head=push(head, 9); 
	head=push(head, 8); 
	head=push(head, 7); 
	head=push(head, 6); 
	head=push(head, 5); 
	head=push(head, 4); 
	head=push(head, 3); 
	head=push(head, 2); 
	head=push(head, 1); 

	System.out.printf("M = %d, N = %d \nGiven" + 
						"Linked list is :\n", M, N); 
	printList(head); 

	skipMdeleteN(head, M, N); 

	System.out.printf("\nLinked list after deletion is :\n"); 
	printList(head); 
} 
} 
