package queue3;
//Suppose there is a circle. There are n petrol pumps on that circle. 
//You are given two sets of data.
//The amount of petrol that every petrol pump has.
//Distance from that petrol pump to the next petrol pump.
//Calculate the first point from where a truck will be able to complete the circle 
//(The truck will stop at each petrol pump and it has infinite capacity). 
//Expected time complexity is O(n). Assume for 1-litre petrol, the truck can go 1 unit of distance.
//
//For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump
//value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where the truck can make
//a circular tour is 2nd petrol pump. Output should be “start = 1” (index of 2nd petrol pump).
public class GasTour
{
	static class petrolPump 
    { 
        int petrol; 
        int distance; 
          
        // constructor 
        public petrolPump(int petrol, int distance)  
        { 
            this.petrol = petrol; 
            this.distance = distance; 
        } 
    } 
	static int printTour(petrolPump arr[],int n)
	{
		int start=0;
		int end=1;
		int curr_petrol=arr[start].petrol-arr[start].distance;
		while(end!=start||curr_petrol<0)
		{
			while(start!=end && curr_petrol<0)
			{
				curr_petrol-=arr[start].petrol-arr[start].distance;
				start=(start+1)%n;
				if(start==0)
					return -1;
			}
			curr_petrol+=arr[end].petrol-arr[end].distance;
			end=(end+1)%n;
		}
		return start;
	}
	public static void main(String[] args)  
    { 
          
        petrolPump[] arr = {new petrolPump(4,6), 
                            new petrolPump(6,5), 
                            new petrolPump(7, 3),
                            new petrolPump(4,5)}; 
          
        int start = printTour(arr, arr.length); 
          
        System.out.println(start == -1 ? "No Solution" : "Start = " + start);  
  
    } 
}
//An efficient approach is to use a Queue to store the current tour. We first enqueue first
//petrol pump to the queue, we keep enqueueing petrol pumps till we either complete the tour,
//or the current amount of petrol becomes negative. If the amount becomes negative, then we
//keep dequeuing petrol pumps until the queue becomes empty.
//Instead of creating a separate queue, we use the given array itself as a queue.
//We maintain two index variables start and end that represent the rear and front of the queue.