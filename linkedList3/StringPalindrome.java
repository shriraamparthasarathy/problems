package linkedList3;
//Given a linked list handling string data, check to see whether data is palindrome or not?
//For example,
//
//Input  : a -> bc -> d -> dcb -> a -> NULL
//Output : True
//String "abcddcba" is palindrome.
//
//Output : a -> bc -> d -> ba -> NULL
//Output : False
//String "abcdba" is not palindrome. 
class StringPalindrome 
{ 
	static class Node 
	{ 
		String data; 
		Node next; 

		Node(String d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 
	Node head; 
	boolean isPalindromeUtil(String str) 
	{ 
		int length = str.length(); 
		for (int i=0; i<length/2; i++) 
			if (str.charAt(i) != str.charAt(length-i-1)) 
				return false; 
		return true; 
	} 
	boolean isPalindrome() 
	{ 
		String str="";
		Node curr=head;
		while(curr!=null)
		{
			str+=curr.data;
			curr=curr.next;
		}
		return isPalindromeUtil(str);
	} 
	public static void main(String[] args) 
	{ 
		StringPalindrome list = new StringPalindrome(); 
		list.head = new Node("a"); 
		list.head.next = new Node("bc"); 
		list.head.next.next = new Node("d"); 
		list.head.next.next.next = new Node("dcb"); 
		list.head.next.next.next.next = new Node("a"); 

		System.out.println(list.isPalindrome()); 

	} 
} 
//algo
//The idea is very simple. Construct a string out of given linked list and check if the
//constructed string is palindrome or not.