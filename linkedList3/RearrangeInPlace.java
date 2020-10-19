package linkedList3;
//Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so 
//that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
//You are required to do this in-place without altering the nodes’ values.
//Examples:
//
//Input:  1 -> 2 -> 3 -> 4
//Output: 1 -> 4 -> 2 -> 3
//
//Input:  1 -> 2 -> 3 -> 4 -> 5
//Output: 1 -> 5 -> 2 -> 4 -> 3 
class RearrangeInPlace { 

	Node head;
	static class Node 
	{ 

		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	void printlist(Node node) 
	{ 
		if (node == null) { 
			return; 
		} 
		while (node != null) { 
			System.out.print(node.data + " -> "); 
			node = node.next; 
		} 
		System.out.print("NULL");
	} 

	Node reverselist(Node node) 
	{ 
		Node prev = null, curr = node, next; 
		while (curr != null) { 
			next = curr.next; 
			curr.next = prev; 
			prev = curr; 
			curr = next; 
		} 
		node = prev; 
		return node; 
	} 

	void rearrange(Node node) 
	{ 

		Node slow=node,fast=slow.next;
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		Node n1=node;
		Node n2=slow.next;
		slow.next=null;
		n2=reverselist(n2);
		node=new Node(0);
		Node curr=node;
		while(n1!=null||n2!=null)
		{
			if(n1!=null)
			{
				curr.next=n1;
				n1=n1.next;
				curr=curr.next;
			}
			if(n2!=null)
			{
				curr.next=n2;
				n2=n2.next;
				curr=curr.next;
			}
		}
		curr=curr.next;
	} 

	public static void main(String[] args) 
	{ 

		RearrangeInPlace list = new RearrangeInPlace(); 
		list.head = new Node(1); 
		list.head.next = new Node(2); 
		list.head.next.next = new Node(3); 
		list.head.next.next.next = new Node(4); 
		list.head.next.next.next.next = new Node(5); 

		list.printlist(list.head);
		list.rearrange(list.head); 
		System.out.println(""); 
		list.printlist(list.head); 
	} 
} 
//algo: Time complexity O(n)
//1) Find the middle point using tortoise and hare method.
//2) Split the linked list into two halves using found middle point in step 1.
//3) Reverse the second half.
//4) Do alternate merge of first and second halves. 
