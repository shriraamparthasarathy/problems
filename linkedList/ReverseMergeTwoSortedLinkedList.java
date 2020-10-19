package linkedList;
//Given two linked lists sorted in increasing order. Merge them such a way that the result
//list is in decreasing order (reverse order).
//
//Examples:
//
//Input:  a: 5->10->15->40
//        b: 2->3->20 
//Output: res: 40->20->15->10->5->3->2
//
//Input:  a: NULL
//        b: 2->3->20 
//Output: res: 20->3->2
class ReverseMergeTwoSortedLinkedList 
{ 
	Node head; 
	static Node a, b; 
	static class Node { 

		int data; 
		Node next; 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	void printlist(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	Node sortedmerge(Node node1, Node node2) 
	{
		if(node1==null&&node2==null)
			return null;
		Node res=null;
		while(node1!=null&&node2!=null)
		{
			if(node1.data<=node2.data)
			{
				Node next=node1.next;
				node1.next=res;
				res=node1;
				node1=next;
			}
			else
			{
				Node next=node2.next;
				node2.next=res;
				res=node2;
				node2=next;
			}
		}
		while(node1!=null)
		{
			Node next=node1.next;
			node1.next=res;
			res=node1;
			node1=next;
		}
		while(node2!=null)
		{
			Node next=node2.next;
			node2.next=res;
			res=node2;
			node2=next;
		}
		return res;
	}

	public static void main(String[] args) { 

		ReverseMergeTwoSortedLinkedList list = new ReverseMergeTwoSortedLinkedList(); 
		Node result = null; 
		a = new Node(5); 
		a.next = new Node(10); 
		a.next.next = new Node(15); 

		b = new Node(2); 
		b.next = new Node(3); 
		b.next.next = new Node(20); 
		System.out.println("List a before merge :"); 
		list.printlist(a); 
		System.out.println(""); 
		System.out.println("List b before merge :"); 
		list.printlist(b); 
		result = list.sortedmerge(a, b); 
		System.out.println(""); 
		System.out.println("Merged linked list : "); 
		list.printlist(result); 

	} 
} 
//algo Time complexity O(n) space O(1)
//The idea is to follow merge style process. Initialize result list as empty. 
//Traverse both lists from beginning to end. Compare current nodes of both lists and insert
//smaller of two at the beginning of the result list.
//
//1) Initialize result list as empty: res = NULL.
//2) Let 'a' and 'b' be heads first and second lists respectively.
//3) While (a != NULL and b != NULL)
//    a) Find the smaller of two (Current 'a' and 'b')
//    b) Insert the smaller value node at the front of result.
//    c) Move ahead in the list of smaller node. 
//4) If 'b' becomes NULL before 'a', insert all nodes of 'a' 
//   into result list at the beginning.
//5) If 'a' becomes NULL before 'b', insert all nodes of 'a' 
//   into result list at the beginning. 