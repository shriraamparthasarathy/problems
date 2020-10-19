package ArraySorting;
import java.util.Arrays;
//Approach: First sort the array, and run a nested loop, fix an index and then try to fix an upper and lower index within which we can use all the lengths to form a triangle with that fixed index.
//Algorithm:
//Sort the array and then take three variables l, r and i, pointing to start, end-1 and array element starting from end of the array.
//Traverse the array from end (n-1 to 1), and for each iteration keep the value of l = 0 and r = i-1
//Now if a triangle can be formed using arr[l] and arr[r] then triangles can obviously formed
//from a[l+1], a[l+2]…..a[r-1], arr[r] and a[i], because the array is sorted , which can be directly calculated using (r-l). and then decrement the value of r and continue the loop till l is less than r
//If triangle cannot be formed using arr[l] and arr[r] then increment the value of r and continue the loop till l is less than r
//So the overall complexity of iterating
//through all array elements reduces.
public class CountTriangles 
{
	static void findTriangles(int a[])
	{
		int n=a.length,count=0;
		Arrays.sort(a);
		for(int i=n-1;i>0;i--)
		{
			int l=0,r=i-1;
			while(l<r)
			{
				if(a[l]+a[r]>a[i])
				{
					count+=r-l;
					r--;
				}
				else
					l++;
			}
		}
		System.out.print("\nThe no of triangles is: "+count);
	}
	public static void main(String args[])
	{
		int a[]= {4, 6, 3, 7};//10, 21, 22, 100, 101, 200, 300 
		findTriangles(a);
	}
}
