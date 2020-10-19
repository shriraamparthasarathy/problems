package doublyLinkedList;


public class MergeSortDll 
{
	Node head;
	static class Node 
	{ 
		int data; 
		Node prev; 
		Node next; 

		Node(int d) { data = d; prev=next=null;} 
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
	Node merge(Node left,Node right)
	{
		if(left==null)
			return right;
		if(right==null)
			return left;
		if(left.data<right.data)
		{
			left.next=merge(left.next,right);
			left.next.prev=left;
			left.prev=null;
			return left;
		}
		else
		{
			right.next=merge(left,right.next);
			right.next.prev=right;
			right.prev=null;
			return right;
		}
	}

	Node mergeSort(Node left)
	{
		if(left==null||left.next==null)
			return left;
		Node middle=middle(left);
		Node right=middle.next;
		middle.next=null;
		left=mergeSort(left);
	    right=mergeSort(right);
		return merge(left,right);
		
	}
	Node middle(Node head)
	{
		Node slow=head,fast=head;
		while(fast.next!=null&&fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
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
		MergeSortDll dll = new MergeSortDll(); 
		dll.push(1); 
		dll.push(2); 
		dll.push(3); 
		dll.push(4); 
		dll.push(5); 		
		System.out.println("Created DLL is: "); 
		dll.printlist(dll.head); 
		dll.head=dll.mergeSort(dll.head);
		System.out.println("\nlist after sorting "); 
		dll.printlist(dll.head); 
	} 
}
