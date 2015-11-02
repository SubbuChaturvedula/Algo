package programs;

public class IsPalindrome {

	public static void main(String[] args) {
		
		boolean flag=isIntPalindrome(1221);
		System.err.println();
		System.err.println(" Is Palindrome "+flag);

	}

	public static boolean isIntPalindrome(int x)
	{
	    if (x < 0)
	    return false;
	    int div = 1;
	    while (x / div >= 10)
	    {
	        div *= 10;
	        System.err.println("div is :"+div);
	    }
	 
	    while (x != 0)
	    {
	        int l = x / div;
	        System.err.println("left is "+ l);
	        int r = x % 10;
	        System.err.println("right is "+r);
	        if (l != r)
	            return false;
	        x = (x % div) / 10;
	        System.err.println("X is :"+x);
	        div =div/100;
	        System.err.println(" last div is "+div);
	    }
	    return true;
	}
}
