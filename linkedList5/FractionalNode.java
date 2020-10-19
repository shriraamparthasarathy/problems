package linkedList5;

//Given a singly linked list and a number k, write a function to find the (n/k)-th element, where n is the number of elements in the list. We need to consider ceil value in case of decimals.
//
//Examples:
//
//Input : list = 1->2->3->4->5->6 
//        k = 2
//Output : 3
//Since n = 6 and k = 2, we print (6/2)-th node 
//which is 3.
//
//Input : list = 2->7->9->3->5
//        k = 3
//Output : 7 
//Since n is 5 and k is 3, we print ceil(5/3)-th 
//node which is 2nd node, i.e., 7.
public class FractionalNode 
{
	Node head; 
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 
	void push(int new_data) 
	{ 
		Node new_node = new Node(new_data);
		new_node.next = head; 
		head = new_node; 
	} 

	
	Node findFractional(int k)
	{
		if(k<=0||head==null)
			return null;
		Node curr=head;
		Node fract=null;
		int i=0;
		while(curr!=null)
		{
			if(i%k==0)
			{
				if(fract==null)
					fract=head;
				else	
					fract=fract.next;
			}
			curr=curr.next;
			i++;
		}
		return fract;
	}
	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
		System.out.print(temp.data+" "); 
		temp = temp.next; 
		} 
		System.out.println(); 
	} 

	public static void main(String args[]) 
	{ 
		FractionalNode llist1 = new FractionalNode();
		llist1.push(6); 
		llist1.push(5); 
		llist1.push(4); 
		llist1.push(3); 
		llist1.push(2); 
		llist1.push(1); 
		int k=2;
		System.out.println("Linked List:"); 

		Node answer=llist1.findFractional(k);

		System.out.println("Fractional node is: "+answer.data); 
	} 
}
//algo
//Take two pointers temp and fractionalNode and initialize them with null and head respectively.
//For every k jumps of the temp pointer, make one jump of the fractionalNode pointer.