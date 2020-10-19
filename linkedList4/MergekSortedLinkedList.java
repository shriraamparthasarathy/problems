package linkedList4;

public class MergekSortedLinkedList 
{
	Node head = null; 
	static class Node { 
		int val; 
		Node next; 

		public Node(int val) 
		{ 
			this.val = val; 
		} 
	} 

	static Node merge(Node left,Node right)
	{
		Node result=null;
		if(left==null)
			return right;
		if(right==null)
			return left;
		if(left.val<=right.val)
		{
			result=left;
			result.next=merge(left.next,right);
		}
		else
		{
			result=right;
			result.next=merge(left,right.next);
		}
		return result;
	}
	static Node mergeKLists(Node arr[],int last)
	{
		while(last!=0)
		{
			int i=0,j=last;
			while(i<j)
			{
				arr[i]=merge(arr[i],arr[j]);
				i++;
				j--;
				if(i>=j)
					last=j;
			}
		}
		return arr[0];
	}
	void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 
	static void printList(Node headref) 
	{ 
		while (headref != null) { 
			System.out.print(headref.val + " "); 
			headref = headref.next; 
		} 
	} 

	public static void main(String[] args) 
	{ 
		int k = 3; 
        Node arr[] = new Node[k]; 
  
        arr[0] = new Node(1); 
        arr[0].next = new Node(3); 
        arr[0].next.next = new Node(5); 
        arr[0].next.next.next = new Node(7); 
  
        arr[1] = new Node(2); 
        arr[1].next = new Node(4); 
        arr[1].next.next = new Node(6); 
        arr[1].next.next.next = new Node(8); 
  
        arr[2] = new Node(0); 
        arr[2].next = new Node(9); 
        arr[2].next.next = new Node(10); 
        arr[2].next.next.next = new Node(11); 
        Node head = mergeKLists(arr, k - 1); 
        printList(head); 
	} 
} 
//algo divide and conquer
//This approach doesn’t require extra space for heap and works in O(nk Log k)
//
//It is known that merging of two linked lists can be done in O(n) time and O(1) space 
//(For arrays O(n) space is required).
//
//The idea is to pair up K lists and merge each pair in linear time using O(1) space.
//After first cycle, K/2 lists are left each of size 2*N. After second cycle, K/4 lists are 
//left each of size 4*N and so on.
//Repeat the procedure until we have only one list left.

