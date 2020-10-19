package arrayMatrix2;

//problem
//https://media.geeksforgeeks.org/wp-content/cdn-uploads/histogram1.png

import java.util.Stack; 
public class HistogramArea 
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
	
	 
	public static void main(String[] args) 
	{ 
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length)); 
	} 
} 

//
//For every bar in the histogram, consider it to be included in the required rectangle of
//maximum area. Now calculate the area of the rectangle that it can form. This bar can form the 
//rectangle between its previous smaller bar and next smaller bar.
//
//So we need index of previous and next smaller bar for every bar. For this we use stack and keep
//pushing in it the indexes of bars which are longer than the one at the top. If a incoming bar is 
//of smaller height than the bar at the top of stack, we have got the right smaller index for the 
//bar at the top of stack. So we pop the top element i.e index of bar whose area we're going to 
//calculate.
//Index of previous smaller is now saved at the top of the stack and next smaller is the incoming
//bar that is waiting to be pushed in the stack. Now we can calculate its area.
//
//We'll do this for every bar and keep track of the maximum area. Handle the corner cases like 
//left smaller index of the first bar and right smaller index of last bar.