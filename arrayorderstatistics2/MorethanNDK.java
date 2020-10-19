package arrayorderstatistics2;

public class MorethanNDK 
{
	static class counter
	{
		int c;
		int e;
		public counter(int c)
		{
			this.c=c;
		}
	}
	static void findNdK(int a[],int k)
	{
		counter temp[]=new counter[k];
		for(int i=0;i<k-1;i++)
			temp[i]=new counter(0);
		for(int i=0;i<a.length;i++)
		{
			//{3, 1, 2, 2, 1, 2, 3, 3},k=4
			int j;
			for(j=0;j<k-1;j++)
			{
				if(a[i]==temp[j].e)
				{
					temp[j].c++;
					break;
				}
				
			}
			if(j==k-1)
			{
				int l;
				for(l=0;l<k-1;l++)
				{
					if(temp[l].c==0)
					{
						temp[l].e=a[i];
						temp[l].c=1;
						break;
					}
				}
				if(l==k-1)
				{
					for(l=0;l<k-1;l++)
						temp[l].c--;
				}
			}
		}
		for(int i=0;i<k-1;i++)
		{
			int ac=0;
			for(int j=0;j<a.length;j++)
			{
				if(temp[i].e==a[j])
					ac++;
			}
			if(ac>a.length/k)
				System.out.println("Number : "+ temp[i].e+" Count "+ac);
		}
		
	}
	public static void main(String[] args)
	{
		int a[] = {3, 1, 2, 2, 1, 2, 3, 3},k=4;//int arr1[] = {4, 5, 6, 7, 8, 4, 4}; k=3
		findNdK(a,k);
	}
}
