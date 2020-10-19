package linkedList5;
import java.util.Stack; 
//Given a singly linked list containing n nodes. Modify the value of first half nodes 
//such that 1st node’s new value is equal to the last node’s value minus first node’s
//current value, 2nd node’s new value is equal to the second last node’s value minus
//2nd node’s current value, likewise for first half nodes. If n is odd then the value 
//of the middle node remains unchanged.
//(No extra memory to be used).
//
//Examples:
//
//Input : 10 -> 4 -> 5 -> 3 -> 6
//Output : 4 -> 1 -> 5 -> 3 -> 6
//
//Input : 2 -> 9 -> 8 -> 12 -> 7 -> 10
//Output : -8 -> 2 -> -4 -> 12 -> 7 -> 10
class ModifyingContentbasedonCriteria 
{ 
 
	static class Node 
	{ 

		int data; 
		Node next; 
	}; 

	static Node push(Node head_ref, int new_data)
	{
		Node new_node = new Node(); 
		new_node.data = new_data; 
		new_node.next = head_ref; 
		head_ref = new_node; 
		return head_ref; 
	} 
	static void printList(Node head) 
	{ 
		if (head == null) 
		{ 
			return; 
		} 

		while (head.next != null) 
		{ 
			System.out.print(head.data + "->"); 
			head = head.next; 
		} 
		System.out.print(head.data + "\n"); 
	} 
	static Node find_mid(Node head) 
	{ 
		Node  slow = head, fast = head; 

		while (fast != null && fast.next != null) 
		{ 
			slow = slow.next; 
			fast = fast.next.next; 
		} 

		if (fast != null) 
		{ 
			slow = slow.next; 
		} 

		return slow; 
	} 
	static void modifyTheList(Node head, Node slow) 
	{  
		Stack<Integer> s = new Stack<Integer>(); 
		Node temp = head; 

		while (slow != null) 
		{ 
			s.add(slow.data); 
			slow = slow.next; 
		} 
		while (!s.empty()) 
		{ 
			temp.data = temp.data - s.pop(); 
			temp = temp.next; 
		} 

	} 

	public static void main(String[] args) 
	{ 
		Node head = null, mid; 
 
		head = push(head, 10); 
		head = push(head, 7); 
		head = push(head, 12); 
		head = push(head, 8); 
		head = push(head, 9); 
		head = push(head, 2); 
 
		mid = find_mid(head); 
		modifyTheList(head, mid); 
		System.out.print("Modified List:" + "\n"); 
		printList(head); 
	} 
} 
//algo
//1. Find the starting point of second half Linked List.
//2. Push all elements of second half list into stack s.
//3. Traverse list starting from head using temp until stack is not empty
//and do Modify temp->data by subtracting the top element of stack for every node.
