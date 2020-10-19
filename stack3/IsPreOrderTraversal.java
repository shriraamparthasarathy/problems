package stack3;
import java.util.Stack;
//Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, else return false. Expected time complexity is O(n).
//
//Examples:
//
//Input:  pre[] = {2, 4, 3}
//Output: true
//Given array can represent preorder traversal
//of below tree
//    2
//     \
//      4
//     /
//    3
//
//Input:  pre[] = {2, 4, 1}
//Output: false
//Given array cannot represent preorder traversal
//of a Binary Search Tree.
//
//Input:  pre[] = {40, 30, 35, 80, 100}
//Output: true
//Given array can represent preorder traversal
//of below tree
//     40
//   /   \
// 30    80 
//  \      \
//  35     100 
//
//
//Input:  pre[] = {40, 30, 35, 20, 80, 100}
//Output: false
//Given array cannot represent preorder traversal
//of a Binary Search Tree.
public class IsPreOrderTraversal 
{
	static boolean ispreOrderTraversal(int tree[])
	{
		Stack<Integer> s=new Stack<>();
		int root=Integer.MIN_VALUE;
		for(int i=0;i<tree.length;i++)
		{
			if(tree[i]<root)
				return false;
			while(!s.isEmpty()&&s.peek()<tree[i])
				root=s.pop();
			s.push(tree[i]);
		}
		return true;
	}
	public static void main(String args[])
	{
		int tree[]= {40, 30, 35, 80, 100};
		if(ispreOrderTraversal(tree))
			System.out.println("We can do tree order traversal");
		else
			System.out.println("We cannot do tree order traversal");
		int tree1[]= {40, 30, 35, 20, 80, 100};
		if(ispreOrderTraversal(tree1))
			System.out.println("We can do tree order traversal");
		else
			System.out.println("We cannot do tree order traversal");
	}
}
//algo
//1) Create an empty stack.
//2) Initialize root as INT_MIN.
//3) Do following for every element pre[i]
//     a) If pre[i] is smaller than current root, return false.
//     b) Keep removing elements from stack while pre[i] is greater
//        then stack top. Make the last removed item as new root (to
//        be compared next).
//        At this point, pre[i] is greater than the removed root
//        (That is why if we see a smaller element in step a), we 
//        return false)
//     c) push pre[i] to stack (All elements in stack are in decreasing
//        order)  