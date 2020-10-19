package arrayorderstatistics;
import java.util.PriorityQueue;	// another way is to sort the array and multiply the first k elements
public class MinProductofSizek 
{
	static int findMiniProduct(int a[],int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<a.length;i++)
			pq.add(a[i]);
		int count=0,res=1;
		while(pq.isEmpty()==false&&count<k)
		{
			res*=pq.poll();
			count++;
		}
		return res;
	}
	public static void main(String[] args)
	{
		int a[]= {198, 76, 544, 123, 154, 675},k=2;
		System.out.print("Mini product is: "+findMiniProduct(a,k));
	}
}
