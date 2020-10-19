package stringReverse;
//Example: Let the input string be “i like this program very much”.
//The function should change the string to “much very program this like i”
public class ReverseWords 
{
	static void reverse(int l,int r,char ch[])
	{
		while(l<r)
		{
			char t=ch[l];
			ch[l]=ch[r];
			ch[r]=t;
			l++;
			r--;
		}
	}
	static char[] reverseWords(char ch[])
	{
		int l=0,r=0,start=0,i=0;  //start is to find the first character that is not space in the string
		for(i=0;ch[i]==' ';i++)
			start++;
		l=start;
		for(i=start;i<ch.length;i++)
		{
			if(ch[i]==' ')
			{
				r=i-1;
				reverse(l,r,ch);
				l=i+1;
			}
		}
		reverse(l,i-1,ch);//to reverse the last word
		l=start;
		r=ch.length-1;
		reverse(l,r,ch);
		return ch;
			
	}
	public static void main(String[] args) 
    { 
		//one method is this
//        String s[] = "i like this program very much".split(" "); 
//        String ans = ""; 
//        for (int i = s.length - 1; i >= 0; i--) { 
//            ans += s[i] + " "; 
//        } 
//        System.out.println("Reversed String:"); 
//        System.out.println(ans.substring(0, ans.length() - 1)); 
        char ch[]="i like this program very much".toCharArray();
        String s=new String(reverseWords(ch));
        System.out.println(s);
    }
}
//algo
//reverse each words
//finally reverse the whole sentence
