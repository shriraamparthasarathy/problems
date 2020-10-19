package arrayoptimization;
import java.util.Arrays;
import java.util.HashMap;

//Best solution is O(n)
//the solution is we need to find a[i]=b[i] => a[i]-b[i]=0
//First let c[i] = a[i] - b[i], then question become find i, j, which sum(c[i], c[i+1], ..., c[j]) = 0, and max j - i.
//
//Second let d[0] = 0, d[i + 1] = d[i] + c[i], i >= 0, then question become find i, j, which d[j + 1] == d[i](since c[i] =0), and max j - i.
//
//The value of d is in range [-n, n], so we can use following code to find the answer

public class LongestSpanSumTwoArrays 
{

	static int findMaxSumLen(int a1[],int a2[])
	{
		int a[]=new int[a1.length],n=a1.length,maxlen=0,sum=0;
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<n;i++)
			a[i]=a1[i]-a2[i]; 
		System.out.println(Arrays.toString(a));// this is c[]
		for(int i=0;i<n;i++)
		{
			sum+=a[i];// sum is d[]
			
			if(sum==0)
				maxlen=i+1;
			if(hm.containsKey(sum))
				maxlen=Math.max(maxlen, i- hm.get(sum));
			else
				hm.put(sum,i);
		}
		return maxlen;
	}
	public static void main(String[] args) 
	{
		int a1[]= {0,1,0,1,1,1,1};
		int a2[]= {1,1,1,1,1,0,1};
		System.out.println("The maximum length is: "+findMaxSumLen(a1,a2));

	}

}
