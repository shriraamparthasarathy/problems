package queue2;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//In operating systems that use paging for memory management, page replacement algorithm are needed to decide which page needed to be replaced when new page comes in. Whenever a new page is referred and not present in memory, page fault occurs and Operating System replaces one of the existing pages with newly needed page. Different page replacement algorithms suggest different ways to decide which page to replace. The target for all algorithms is to reduce number of page faults.
//
//First In First Out (FIFO) page replacement algorithm –
//This is the simplest page replacement algorithm. In this algorithm, operating system keeps track of all pages in the memory in a queue, oldest page is in the front of the queue. When a page needs to be replaced page in the front of the queue is selected for removal.
public class FIFOPageReplacement 
{
	static int pageFaults(int pages[],int capacity)
	{
		HashSet<Integer> s=new HashSet<>();
		Queue<Integer> index=new LinkedList<>();
		int pagefault=0;
		for(int x:pages)
		{
			if(index.size()<capacity)
			{
				if(!s.contains(x))
				{
					s.add(x);
					index.add(x);
					pagefault++;
				}
			}
			else
			{
				if(!s.contains(x))
				{	
					int val=index.poll();
					s.remove(val);
					s.add(x);
					index.add(x);
					pagefault++;
				}	
			}
		}
		return pagefault;
	}
	public static void main(String args[]) 
    { 
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 
                        2, 3, 0, 3, 2}; 
   
        int capacity = 4; 
        System.out.println(pageFaults(pages, capacity)); 
    } 
} 