package arrayMatrix2;
//Input:
//0 1 1 0
//1 1 1 1
//1 1 1 1
//1 1 0 0
//Output :
//1 1 1 1
//1 1 1 1
//Explanation : 
//The largest rectangle with only 1's is from 
//(1, 0) to (2, 3) which is
//1 1 1 1
//1 1 1 1 
import java.util.Stack;
public class LargestRectangularAreaof1s
{ 
	static int getMaxArea(int hist[], int n) 
	{ 
		Stack<Integer> s=new Stack<>();
		int i=0,maxarea=0,top,curarea;
		while(i<n)
		{
		    if(s.empty()||hist[s.peek()]<=hist[i])
		    {
		        s.push(i);
		        i++;
		    }  
		    else
		    {
		        top=s.peek();
		        s.pop();
		        curarea=hist[top]*(s.empty()?i:i-s.peek()-1);
		        maxarea=curarea>maxarea?curarea:maxarea;
		    }
		}
		while(!s.empty())
		{
		    top=s.peek();
		    s.pop();
		    curarea=hist[top]*(s.empty()?i:i-s.peek()-1);
		    maxarea=curarea>maxarea?curarea:maxarea;
		}
		return maxarea;
	}	
	
	static int getMaxRectangleArea(int a[][])
	{
	    int r=a.length,c=a[0].length,cur;
	    int maximumarea=getMaxArea(a[0],c);
	    for(int i=1;i<r;i++)
	    {
	        for(int j=0;j<c;j++)
	            if(a[i][j]==1)
	                a[i][j]+=a[i-1][j];
	        cur=getMaxArea(a[i],c);   
	        maximumarea=maximumarea>cur?maximumarea:cur; 
	    }
	    return maximumarea;
	}
	 
	public static void main(String[] args) 
	{ 
		int a[][] = { 
            { 0, 1, 1, 0 }, 
            { 1, 1, 1, 1 }, 
            { 1, 1, 1, 1 }, 
            { 1, 1, 0, 0 }, 
        }; 
		System.out.println("Maximum area is " + getMaxRectangleArea(a)); 
	} 
}
//algo:
//Run a loop to traverse through the rows.
//Now If the current row is not the first row then update the row as follows, if matrix[i][j] 
//is not zero then matrix[i][j] = matrix[i-1][j] + matrix[i][j].
//Find the maximum rectangular area under the histogram, consider the ith row as heights of bars
//of a histogram. This can be calculated as given in this article Largest Rectangular Area in a
//Histogram
//Do the previous two steps for all rows and print the maximum area of all the rows.