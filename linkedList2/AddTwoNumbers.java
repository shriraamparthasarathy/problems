package linkedList2;
//Given two numbers represented by two lists, write a function that returns the sum list.
//The sum list is list representation of the addition of two input numbers.
//Example:
//
//Input:
//List1: 5->6->3 // represents number 365
//List2: 8->4->2 // represents number 248
//Output:
//Resultant list: 3->1->6 // represents number 613
//Explanation: 365 + 248 = 613
//
//Input:
//List1: 7->5->9->4->6 // represents number 64957
//List2: 8->4 // represents number 48
//Output:
//Resultant list: 5->0->0->5->6 // represents number 65005
//Explanation: 64957 + 48 = 65005
class AddTwoNumbers 
{ 

	static Node head1, head2; 

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
	Node addTwoLists(Node first, Node second) 
	{ 
		Node res = null; 
		Node prev = null; 
		Node temp = null; 
		int carry = 0, sum; 

		while(first!=null||second!=null)
		{
			sum=carry+(first!=null?first.data:0) + (second!=null? second.data:0);
			carry=(sum>9?1:0);
			sum=sum%10;
			temp=new Node(sum);
			 // if this is the first node then set 
            // it as head of the resultant list 
			if(res==null)
				res=temp;
			// If this is not the first 
            // node then connect it to the rest. 
			else
				prev.next=temp;
			prev=temp;
			if(first!=null)
				first=first.next;
			if(second!=null)
				second=second.next;
		}
		if(carry>0)
			temp.next=new Node(carry);
		return res;
	} 
	void printList(Node head) 
	{ 
		while (head != null) { 
			System.out.print(head.data + " "); 
			head = head.next; 
		} 
		System.out.println(""); 
	} 

	public static void main(String[] args) 
	{ 
		AddTwoNumbers list = new AddTwoNumbers(); 
		head1 = new Node(7); 
		head1.next = new Node(5); 
		head1.next.next = new Node(9); 
		head1.next.next.next = new Node(4); 
		head1.next.next.next.next = new Node(6); 
		System.out.print("First List is "); 
		list.printList(head1); 
		head2 = new Node(8); 
		head2.next = new Node(4); 
		System.out.print("Second List is "); 
		list.printList(head2); 
		Node rs = list.addTwoLists(head1, head2); 
		System.out.print("Resultant List is "); 
		list.printList(rs); 
	} 
} 
//Traverse the two linked lists from start to end
//Add the two digits each from respective linked lists.
//If one of the list has reached the end then take 0 as its digit.
//Continue it until both the lists end.
//If the sum of two digits is greater than 9 then set carry as and the current digit as sum % 10 
