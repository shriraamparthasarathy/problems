package doublyLinkedList;


public class DLL
{ 
	Node head;
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
		if(head!=null)
			head.prev=new_node;
		head=new_node;
	} 

	public void InsertAfter(Node prev_node, int new_data) 
	{ 
		if(prev_node==null)
		{
			System.out.println("Previous node cant be null");
			return;
		}
		Node new_node=new Node(new_data);
		new_node.next=prev_node.next;
		prev_node.next=new_node;
		new_node.prev=prev_node;
		if(new_node.next!=null)
			new_node.next.prev=new_node;
	} 
	void append(int new_data) 
	{ 
		Node new_node=new Node(new_data);
		new_node.next=null;
		Node curr=head;
		if(head==null)
		{
			new_node.prev=null;
			head=new_node;
			return;
		}
		while(curr.next!=null)
			curr=curr.next;
		curr.next=new_node;
		new_node.prev=curr;
	} 
	void deleteNode(Node del)
	{
		if(head==null||del==null)
			return;
		if(head==del)
			head=head.next;
		if(del.next!=null)
			del.next.prev=del.prev;
		if(del.prev!=null)
			del.prev.next=del.next;
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
		DLL dll = new DLL(); 
		dll.append(6); 
		dll.push(7); 
		dll.push(1); 
		dll.append(4); 
		dll.InsertAfter(dll.head.next, 8); 
		System.out.println("Created DLL is: "); 
		dll.printlist(dll.head); 
		dll.deleteNode(dll.head.next); 
		System.out.println("list after deleting the second node: "); 
		dll.printlist(dll.head); 
	} 
} 
//algo for delete O(1) time O(1) space
//Let the node to be deleted be del.
//If node to be deleted is head node, then change the head pointer to next current head.
//if headnode == del then
//      headnode =  del.nextNode
//Set next of previous to del, if previous to del exists.
//if del.nextNode != none 
//      del.nextNode.previousNode = del.previousNode 
//Set prev of next to del, if next to del exists.
//if del.previousNode != none 
//      del.nextNode.nextNode = del.next
