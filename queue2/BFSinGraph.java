package queue2;
import java.util.LinkedList;
import java.util.Queue;
public class BFSinGraph 
{
	LinkedList<Integer> a[];
	int v;
	public BFSinGraph(int v)
	{
		this.v=v;
		a=new LinkedList[v];
		for(int i=0;i<v;i++)
			a[i]=new LinkedList<>();
	}
	void addEdge(int v,int d)
	{
		a[v].add(d);
	}
	void BFS(int s)
	{
		boolean visited[]=new boolean[v];
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		while(!q.isEmpty())
		{
			s=q.poll();
			System.out.print(s+" ");
			for(int n:a[s])
			{
				if(!visited[n])
				{
					q.add(n);
					visited[n]=true;
				}
			}
		}
	}
	public static void main(String args[]) 
    { 
        BFSinGraph g = new BFSinGraph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
    } 
}
//Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree
//(See method 2 of this post). The only catch here is, unlike trees, graphs may contain cycles,
//so we may come to the same node again. To avoid processing a node more than once, we use a boolean
//visited array. For simplicity, it is assumed that all vertices are reachable from the starting 
//vertex.
//For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, 
//we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark 
//visited vertices, then 2 will be processed again and it will become a non-terminating process. 
//A Breadth First Traversal of the following graph is 2, 0, 3, 1.