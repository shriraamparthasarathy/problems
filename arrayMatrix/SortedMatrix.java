package arrayMatrix;
import java.util.Arrays;
public class SortedMatrix 
{
	static void sort2d(int a[][])
	{
		int t[]=new int[a.length*a[0].length],n=-1;
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
				t[++n]=a[i][j];
		Arrays.sort(t);
		n=0;
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
				a[i][j]=t[n++];
	}
	public static void main(String [] args)
	{
		int a[][] = { { 5, 4, 7 }, 
                { 1, 3, 8 }, 
                { 2, 9, 6 } };
		sort2d(a);
		for(int i[]:a)
			System.out.println(Arrays.toString(i));
	}
}
