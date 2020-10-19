package arraySearching;
//Given an array of n integers. The task is to check whether an arithmetic progression can be formed using all the given elements. If possible print “Yes”, else print “No”.
//
//Examples:
//
//Input : arr[] = {0, 12, 4, 8}
//Output : Yes
//Rearrange given array as {0, 4, 8, 12} 
//which forms an arithmetic progression.
//
//Input : arr[] = {12, 40, 11, 20}
//Output : No
import java.util.Arrays;
public class isAP 
{
	static boolean isArithmeticProgression(int a[])
	{
		Arrays.sort(a);
		int d=a[1]-a[0];
		for(int i=2;i<a.length;i++)
			if(a[i]-a[i-1]!=d)
				return false;
		return true;
	}
	public static void main(String args[])
	{
		int a[]={0, 12, 4, 8};
		if(isArithmeticProgression(a))
			System.out.println("The array forms AP");
		else
			System.out.println("The array doesnt form AP");
	}
}
