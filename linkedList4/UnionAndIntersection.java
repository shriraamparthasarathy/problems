package linkedList4;

import java.util.HashSet; 

class UnionAndIntersection 
{ 
	Node head; 
	class Node { 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 

	void push(int new_data) 
	{ 
		
		Node new_node = new Node(new_data); 

		new_node.next = head; 

		head = new_node; 
	} 


	

	UnionAndIntersection getIntersection(Node head1, Node head2) 
	{ 
		HashSet<Integer> hs=new HashSet<>();
		Node n1=head1;
		Node n2=head2;
		UnionAndIntersection result=new UnionAndIntersection();
		while(n1!=null)
		{
			hs.add(n1.data);
			n1=n1.next;
		}
		while(n2!=null)
		{
			if(hs.contains(n2.data))
				result.push(n2.data);
			n2=n2.next;
		}
		return result;
	} 

	UnionAndIntersection getUnion(Node head1, Node head2) 
	{ 
		HashSet<Integer> hs=new HashSet<>();
		Node n1=head1;
		Node n2=head2;
		UnionAndIntersection result=new UnionAndIntersection();
		while(n1!=null)
		{
			hs.add(n1.data);
			n1=n1.next;
		}
		while(n2!=null)
		{
			if(!hs.contains(n2.data))
				hs.add(n2.data);
			n2=n2.next;
		}
		for(int i:hs)
			result.push(i);
		return result;
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		UnionAndIntersection llist1 = new UnionAndIntersection(); 
		UnionAndIntersection llist2 = new UnionAndIntersection(); 
		UnionAndIntersection union = new UnionAndIntersection(); 
		UnionAndIntersection intersection = new UnionAndIntersection(); 

		/*create a linked list 10->15->4->20 */
		llist1.push(20); 
		llist1.push(4); 
		llist1.push(15); 
		llist1.push(10); 

		/*create a linked list 8->4->2->10 */
		llist2.push(10); 
		llist2.push(2); 
		llist2.push(4); 
		llist2.push(8); 

		intersection 
			= intersection.getIntersection(llist1.head, 
										llist2.head); 
		union = union.getUnion(llist1.head, llist2.head); 

		System.out.println("First List is"); 
		llist1.printList(); 

		System.out.println("Second List is"); 
		llist2.printList(); 

		System.out.println("Intersection List is"); 
		intersection.printList(); 

		System.out.println("Union List is"); 
		union.printList(); 
	} 
} 
//algo: HASHING