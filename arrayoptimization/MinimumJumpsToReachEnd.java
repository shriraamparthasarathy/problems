package arrayoptimization;

public class MinimumJumpsToReachEnd 	
{
	static int findMiniJump(int a[])
	{
		if(a.length<1)
			return 0;
		else if(a[0]==0)
			return -1;
		int maxreach=a[0],step=a[0],jump=1;
		for(int i=1;i<a.length;i++)
		{
			if(i==a.length-1)
				return jump;
			maxreach=Math.max(maxreach, i+a[i]);
			step--;
			if(step==0)
			{
				if(i>=maxreach)
					return -1;
				step=maxreach-i;
				jump++;
			}
		}
		return jump;
	}
	public static void main(String[] args)
	{
		int a[]={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.print("The minimum no of jumps is: "+findMiniJump(a));
	}
}
