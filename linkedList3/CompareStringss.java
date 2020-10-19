package linkedList3;
//Given two strings, represented as linked lists (every character is a node in a linked list).
//Write a function compare() that works similar to strcmp(), i.e., it returns 0 if both strings 
//are same, 1 if first linked list is lexicographically greater, and -1 if the second string is 
//lexicographically greater.
//
//Examples:
//
//Input: list1 = g->e->e->k->s->a
//       list2 = g->e->e->k->s->b
//Output: -1
//
//Input: list1 = g->e->e->k->s->a
//       list2 = g->e->e->k->s
//Output: 1
//
//Input: list1 = g->e->e->k->s
//       list2 = g->e->e->k->s
//Output: 0
class CompareStringss 
{ 

	Node head; 
	Node a, b; 

	static class Node { 

		char data; 
		Node next; 

		Node(char d) { 
			data = d; 
			next = null; 
		} 
	} 

	int compare(Node node1, Node node2) 
	{ 
		if(node1==null&&node2==null)
			return 1;
		while(node1!=null&&node2!=null&node1.data==node2.data)
		{
			node1=node1.next;
			node2=node2.next;
		}
		if(node1!=null&&node2!=null)
			return (node1.data>node2.data)?1:-1;
		if(node1!=null&&node2==null)
			return 1;
		if(node1==null&&node2!=null)
			return -1;
		return 0;
	} 

	public static void main(String[] args) { 

		CompareStringss list = new CompareStringss(); 
		list.a = new Node('g'); 
		list.a.next = new Node('e'); 
		list.a.next.next = new Node('e'); 
		list.a.next.next.next = new Node('k'); 
		list.a.next.next.next.next = new Node('s'); 
		list.a.next.next.next.next.next = new Node('b'); 

		list.b = new Node('g'); 
		list.b.next = new Node('e'); 
		list.b.next.next = new Node('e'); 
		list.b.next.next.next = new Node('k'); 
		list.b.next.next.next.next = new Node('s'); 
		list.b.next.next.next.next.next = new Node('a'); 

		int value; 
		value = list.compare(list.a, list.b); 
		System.out.println(value); 

	} 
} 

//This code has been contributed by Mayank Jaiswal 
