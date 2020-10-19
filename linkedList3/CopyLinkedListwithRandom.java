package linkedList3;

class CopyLinkedListwithRandom 
{ 
 
static class Node 
{ 
	int data; 
	Node next,random; 
	Node(int x) 
	{ 
		data = x; 
		next = random = null; 
	} 
} 

static void print(Node start) 
{ 
	Node ptr = start; 
	while (ptr != null) 
	{ 
		System.out.println("Data = " + ptr.data + 
					", Random = "+ptr.random.data); 
		ptr = ptr.next; 
	} 
} 

static Node clone(Node start) 
{ 
	Node curr=start,temp;
	while(curr!=null)
	{
		temp=curr.next;
		curr.next=new Node(curr.data);
		curr.next.next=temp;
		curr=temp;
	}
	curr=start;
	while(curr!=null)
	{
		if(curr.next!=null)
			curr.next.random=(curr.random!=null)?curr.random.next:curr.random;
		curr=(curr.next!=null)?curr.next.next:curr.next;
	}
	Node original=start;
	Node copy=start.next;
	temp=copy;//have the copy head
	while(original!=null&&copy!=null)
	{
		original.next=(original.next!=null)?original.next.next:original.next;
		copy.next=(copy.next!=null)?copy.next.next:copy.next;
		original=original.next;
		copy=copy.next;
	}
	return temp;//the copy head
} 

public static void main(String[] args) 
{ 
	Node start = new Node(1); 
	start.next = new Node(2); 
	start.next.next = new Node(3); 
	start.next.next.next = new Node(4); 
	start.next.next.next.next = new Node(5); 

	// 1's random points to 3 
	start.random = start.next.next; 

	// 2's random points to 1 
	start.next.random = start; 

	// 3's and 4's random points to 5 
	start.next.next.random = start.next.next.next.next; 
	start.next.next.next.random = start.next.next.next.next; 

	// 5's random points to 2 
	start.next.next.next.next.random = start.next; 

	System.out.println("Original list : "); 
	print(start); 

	System.out.println("Cloned list : "); 
	Node cloned_list = clone(start); 
	print(cloned_list); 

} 
} 
//algo: time complexity O(n) space O(n)
//Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, 
//create a copy of 2 and insert it between 2 & 3. Continue in this fashion, add the copy of N after
//the Nth node
//Now copy the random link in this fashion
//original->next->random= original->random->next;  /*TRAVERSE 
//TWO NODES*/
//This works because original->next is nothing but copy of original and Original->random->next is 
//nothing but copy of random.
//Now restore the original and copy linked lists in this fashion in a single loop.
//original->next = original->next->next;
//     copy->next = copy->next->next;
//Ensure that original->next is NULL and return the cloned list
