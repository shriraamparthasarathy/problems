package queue3;
import java.util.LinkedList;
import java.util.Queue;
//Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 
//which has the following meaning:
//0: Empty cell
//1: Cells have fresh oranges
//2: Cells have rotten oranges 
//Determine what is the minimum time required so that all the oranges become rotten. A rotten
//orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1]
//		(up, down, left and right). If it is impossible to rot every orange then simply return -1.
//				
//
//Examples:
//
//Input:  arr[][C] = { {2, 1, 0, 2, 1},
//                     {1, 0, 1, 2, 1},
//                     {1, 0, 0, 2, 1}};
//Output:
//All oranges can become rotten in 2-time frames.
//Explanation: 
//At 0th time frame:
// {2, 1, 0, 2, 1}
// {1, 0, 1, 2, 1}
// {1, 0, 0, 2, 1}
//
//At 1st time frame:
// {2, 2, 0, 2, 2}
// {2, 0, 2, 2, 2}
// {1, 0, 0, 2, 2}
//
//At 2nd time frame:
// {2, 2, 0, 2, 2}
// {2, 0, 2, 2, 2}
// {2, 0, 0, 2, 2}

public class RottenOranges 
{
	public final static int R = 3; 
    public final static int C = 5; 
      
    static class Ele 
    { 
        int x = 0; 
        int y = 0; 
        Ele(int x,int y) 
        { 
            this.x = x; 
            this.y = y; 
        } 
    } 
      
    // function to check whether a cell is valid / invalid 
    static boolean isValid(int i, int j) 
    { 
        return (i >= 0 && j >= 0 && i < R && j < C); 
    } 
      
  
    // Function to check whether the cell is delimiter 
    // which is (-1, -1) 
    static boolean isDelim(Ele temp) 
    { 
        return (temp.x == -1 && temp.y == -1); 
    } 
      
    // Function to check whether there is still a fresh 
    // orange remaining 
    static boolean checkAll(int arr[][]) 
    { 
         for (int i=0; i<R; i++) 
               for (int j=0; j<C; j++) 
                  if (arr[i][j] == 1) 
                     return true; 
         return false; 
    } 
    static int rotOranges(int arr[][])
    {
    	Queue<Ele> q=new LinkedList<>();
    	Ele temp;
    	int ans=0;
    	for(int i=0;i<R;i++)
    		for(int j=0;j<C;j++)
    			if(arr[i][j]==2)
    				q.add(new Ele(i,j));
    	q.add(new Ele(-1,-1));
    	while(!q.isEmpty())
    	{
			boolean flag=false;
    		while(!isDelim(q.peek()))
    		{
    			temp=q.poll();
    			if(isValid(temp.x+1,temp.y)&&arr[temp.x+1][temp.y]==1)
    			{
    				if(!flag)
    				{
    					flag=true;
    					ans++;
    				}
    				arr[temp.x+1][temp.y]=2;
    				q.add(new Ele(temp.x+1,temp.y));
    			}
    			if(isValid(temp.x-1,temp.y)&&arr[temp.x-1][temp.y]==1)
    			{
    				if(!flag)
    				{
    					flag=true;
    					ans++;
    				}
    				arr[temp.x-1][temp.y]=2;
    				q.add(new Ele(temp.x-1,temp.y));
    			}
    			if(isValid(temp.x,temp.y+1)&&arr[temp.x][temp.y+1]==1)
    			{
    				if(!flag)
    				{
    					flag=true;
    					ans++;
    				}
    				arr[temp.x][temp.y+1]=2;
    				q.add(new Ele(temp.x,temp.y+1));
    			}
    			if(isValid(temp.x,temp.y-1)&&arr[temp.x][temp.y-1]==1)
    			{
    				if(!flag)
    				{
    					flag=true;
    					ans++;
    				}
    				arr[temp.x][temp.y-1]=2;
    				q.add(new Ele(temp.x,temp.y-1));
    			}
    		}
			q.poll();
    		if(!q.isEmpty())
    			q.add(new Ele(-1,-1));
    	}
    	return checkAll(arr)?-1:ans;
    }
    public static void main(String[] args)  
    { 
        int arr[][] = { {2, 1, 0, 2, 1}, 
                        {1, 0, 1, 2, 1}, 
                        {1, 0, 0, 2, 1}}; 
        int ans = rotOranges(arr); 
        if(ans == -1) 
            System.out.println("All oranges cannot rot"); 
        else
            System.out.println("Time required for all oranges to rot = " + ans); 
    } 
}
//Approach: The idea is to use Breadth First Search. The condition of oranges getting rotten is 
//when they come in contact with other rotten oranges. This is similar to breadth-first search 
//where the graph is divided into layers or circles and the search is done from lower or closer 
//layers to deeper or higher layers. In the previous approach, the idea was based on BFS but the
//implementation was poor and inefficient. To find the elements whose values are no the whole 
//matrix had to be traversed. So that time can be reduced by using this efficient approach of BFS.
//Algorithm:
//Create an empty queue Q.
//Find all rotten oranges and enqueue them to Q. Also enqueue a delimiter to indicate the 
//beginning of next time frame.
//Run a loop While Q is not empty
//Do following while delimiter in Q is not reached
//Dequeue an orange from the queue, rot all adjacent oranges. While rotting the adjacent,
//make sure that the time frame is incremented only once. And the time frame is not incremented
//if there are no adjacent oranges.
//Dequeue the old delimiter and enqueue a new delimiter. The oranges rotten in the previous time 
//frame lie between the two delimiters.