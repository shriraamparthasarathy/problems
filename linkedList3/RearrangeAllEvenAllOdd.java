package linkedList3;

//Rearrange a linked list in such a way that all odd position nodes are together and all even
//positions node are together,
//
//Examples:
//
//Input:   1->2->3->4
//Output:  1->3->2->4
//
//Input:   10->22->30->43->56->70
//Output:  10->30->56->22->43->70
public class RearrangeAllEvenAllOdd 
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
	
	public void segregateEvenOdd()
	{ 
		if(head==null)
			return;
		Node oddstart=null;
		Node oddend=null;
		Node evenstart=null;
		Node evenend=null;
		Node curr=head;
		int i=0;
		while(curr!=null)
		{
			if(i%2==0)
			{
				if(evenstart==null)
				{
					evenstart=curr;
					evenend=curr;
				}
				else
				{
					evenend.next=curr;
					evenend=evenend.next;
				}
			}
			else
			{
				if(oddstart==null)
				{
					oddstart=curr;
					oddend=curr;
				}
				else
				{
					oddend.next=curr;
					oddend=oddend.next;
				}
			}
			i++;
			curr=curr.next;
		}
		if(oddstart==null||evenstart==null)//no odd or even elements
			return;
		evenend.next=oddstart;
		oddend.next=null;
		head=evenstart;
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
		RearrangeAllEvenAllOdd llist = new RearrangeAllEvenAllOdd(); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(2); 
		llist.push(1); 

		System.out.println("Origional Linked List"); 
		llist.printList(); 

		llist.segregateEvenOdd(); 

		System.out.println("Modified Linked List"); 
		llist.printList(); 
	} 
}
//algo
//same as segrate even and odd
//the main difference we have a iterting variable i that is checked for even and odd position
//rather than the data in the node