package queue;

import java.util.LinkedHashSet;
public class LRUCache 
{
	static LinkedHashSet<Integer> cache;
	static int capacity;
	static boolean get(int x)
	{
		if(cache.contains(x))
		{
			cache.remove(x);
			cache.add(x);
			return false;
		}
		else
			return true;
			
	}
	static void put(int x)
	{
		if(cache.contains(x))
			cache.remove(x);
		else if(cache.size()==capacity)
		{
			int firstkey=cache.iterator().next();
			cache.remove(firstkey);
		}
		cache.add(x);
	}
	static void refer(int x)
	{
		if(get(x))
			put(x);
	}
	static void display()
	{
		for(int d: cache)
			System.out.println(d);
	}
	public static void main(String[] args) 
    { 
        capacity=4;
        cache=new LinkedHashSet<>(capacity);
        refer(1); 
        refer(2); 
        refer(3); 
        refer(1); 
        refer(4); 
        refer(5); 
        display(); 
    } 
}
//refer https://www.geeksforgeeks.org/lru-cache-implementation/