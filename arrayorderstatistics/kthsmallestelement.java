package arrayorderstatistics;
import java.util.PriorityQueue;

public class kthsmallestelement 
{

	static int findMini(int a[][],int n,int k)
	{
		PriorityQueue<Pqnode> pq=new PriorityQueue<>(n,(o1,o2)->
		{
			return o1.data-o2.data;
		});
		for(int i=0;i<n;i++)
		{
			pq.offer(new Pqnode(a[0][i], 0, i));
		}	
		Pqnode node=null;
		for(int i=0;i<k;i++)
		{
			node=pq.poll();
			if(node.r<n-1)
			{
				pq.offer(new Pqnode(a[node.r+1][node.c],node.r+1,node.c));
			}
		}
		return node.data;
	}
	public static void main(String args[])
	{
		int a[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50}};
		int n=4,k=7;
		System.out.println(k+"th smallest term is: "+findMini(a,n,k));
	}
	
	public static class Pqnode//to access this class in our class, we need to make it static or make this a separate class file
	{
		int data,r,c;
		public Pqnode(int data,int r,int c)
		{
			this.data=data;
			this.r=r;
			this.c=c;
		}
	}
}

