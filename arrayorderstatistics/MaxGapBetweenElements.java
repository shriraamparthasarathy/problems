package arrayorderstatistics;

public class MaxGapBetweenElements 
{
	//Alternate solution
	/*static int maxDiff (int arr[], int n)  
    {  
        // Initialize diff, current  
        // sum and max sum  
        int diff = arr[1] - arr[0];  
        int curr_sum = diff;  
        int max_sum = curr_sum;  
  
        for(int i = 1; i < n - 1; i++)  
        {  
            // Calculate current diff  
            diff = arr[i + 1] - arr[i];  
  
            // Calculate current sum  
            if (curr_sum > 0)  
            curr_sum += diff;  
            else
            curr_sum = diff;  
  
        // Update max sum, if needed  
            if (curr_sum > max_sum)  
            max_sum = curr_sum;  
        }  
        if(max_sum<0)
            return 0;
        else
            return max_sum;  
    }*/
	static int findMax(int a[])
	{
		int max_diff=a[1]-a[0],min=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]-min>max_diff)
				max_diff=a[i]-min;
			if(a[i]<min)
				min=a[i];
		}
		if(max_diff<0) // if there is no large number after every number
			return 0;
		else
			return max_diff;
	}
	public static void main(String[] args)
	{
		int a[] = {6, 5, 10, 2, 4, 8, 1}; //2, -1, 5, -6, 3 //9, 3, 2, 1//8, 19, 3 ,2 ,7 
		System.out.print("The maximum difference is: "+findMax(a));
	}
}
