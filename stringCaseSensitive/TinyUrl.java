package stringCaseSensitive;

public class TinyUrl
{
	static char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	static String idToShortURL(int n)
	{
		String res="";
		while(n>0)
		{
			res=map[n%62]+res;
			n=n/62;
		}
		return res;
		
	}
	static int shortURLtoID(String shortURL)
	{
		int id = 0; 
        for (int i = 0; i < shortURL.length(); i++)  
        {  
            if ('a' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= 'z')  
            id = id * 62 + shortURL.charAt(i) - 'a';  
            if ('A' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= 'Z')  
            id = id * 62 + shortURL.charAt(i) - 'A' + 26;  
            if ('0' <= shortURL.charAt(i) &&  
                       shortURL.charAt(i) <= '9')  
            id = id * 62 + shortURL.charAt(i) - '0' + 52;  
        }  
        return id; 
	}
	public static void main (String[] args)
    { 
        int n = 12345;  
        String shorturl = idToShortURL(n);  
        System.out.println("Generated short url is " + shorturl);  
        System.out.println("Id from url is " +  
                            shortURLtoID(shorturl));  
    }
}
