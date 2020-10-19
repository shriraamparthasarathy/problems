package doublyLinkedList;


public class SwapKthElement
{
	Node head,tail;
	class Node 
	{ 
		int data; 
		Node prev; 
		Node next; 

		Node(int d) { data = d; } 
	} 
	public void push(int new_data) 
	{ 
		Node new_node=new Node(new_data);
		new_node.prev=null;
		new_node.next=head;
		if(head==null)
			tail=new_node;
		if(head!=null)
			head.prev=new_node;
		head=new_node;
	} 

	
	void swap(int k)
	{
		if(k>=getCount())
		{	
			System.out.println("K is greter than size");
			return;
		}	
		Node x=head,y=tail;
		for(int i=1;i<k;i++)
		{
			x=x.next;
			y=y.prev;
		}
		int t=x.data;
		x.data=y.data;
		y.data=t;
	}
	int getCount()
	{
		Node curr=head;
		int count=0;
		while(curr!=null)
		{
			curr=curr.next;
			count++;
		}
		return count;
	}
	public void printlist(Node node) 
	{ 
		Node last = null; 
		System.out.println("Traversal in forward Direction"); 
		while (node != null) { 
			System.out.print(node.data + " "); 
			last = node; 
			node = node.next; 
		} 
		System.out.println(); 
		System.out.println("Traversal in reverse direction"); 
		while (last != null) { 
			System.out.print(last.data + " "); 
			last = last.prev; 
		} 
	} 
	public static void main(String[] args) 
	{ 
		SwapKthElement dll = new SwapKthElement(); 
		dll.push(1); 
		dll.push(2); 
		dll.push(3); 
		dll.push(4); 
		dll.push(5); 
		
		System.out.println("Created DLL is: "); 
		dll.printlist(dll.head); 
		int k=2;
		dll.swap(k);
		System.out.println("\nlist after swapping the "+k+" node from start and end: "); 
		dll.printlist(dll.head); 
	} 
}
